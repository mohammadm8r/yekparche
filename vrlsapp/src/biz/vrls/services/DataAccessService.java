package biz.vrls.services ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import sun.jdbc.rowset.CachedRowSet;

/**************************************************
*
* This singleton service class utilizes the <i>Data
* Access Object</i> (DAO) design pattern to provide
* a single point of access to database functions.
*
***************************************************/
public class DataAccessService {

    private Properties dataSourceProps = null ;
    
    private static DataAccessService instance ;
    
    private LoggingService loggingService = null ;
    
    /***************************************************
    *
    * Private constructor conforming to singleton pattern
    *
    ***************************************************/
    private DataAccessService() {
        loggingService = LoggingService.getInstance() ;
    }
    
    /***************************************************
    *
    * Static method to access singleton instance of class
    *
    * @return  the singleton instance of this class
    *
    ***************************************************/
    public static DataAccessService getInstance() {
        if (instance == null) {
            instance = new DataAccessService() ;
        }
        return instance ;
    }

    /***************************************************
    *
    * Gets the name of the <tt>DataSource</tt>
    *
    * @return  the name of the <tt>DataSource</tt>
    *
    ***************************************************/
    public String getDataSourceName() {
        ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources") ;
        String dataSourceName = bundle.getString("app.datasource.name") ;
        return (dataSourceName == null || dataSourceName.equals("") ? "???" : dataSourceName) ;
    }
    
    /***************************************************
    *
    * Gets a database <tt>Connection</tt> through the <tt>DataSource</tt>
    *
    * @return  a database <tt>Connection</tt>
    *
    * @throws  ServletException  if errors occur getting the <tt>Connection</tt>
    *
    ***************************************************/
    public Connection getConnection() throws ServletException {
        DataSource ds = null ;
        Connection conn = null ;
        try {
            loggingService.info("DataAccessService.getConnection(): getting DataSource...") ;
            ds = getDataSource(getDataSourceName()) ; 
            loggingService.info("DataAccessService.getConnection(): got DataSource...") ;
            if (ds != null) {
                conn = ds.getConnection() ;
                if (conn == null) {
                    throw new ServletException("Could not get connection. " +
                        "Check server status or datasource definition.") ;
                }
                conn.setAutoCommit(false) ;
                loggingService.info("DataAccessService.getConnection(): got Connection...") ;
            }
            else {
                loggingService.error("Could not get datasource. " +
                    "Check datasource definition.") ;
                throw new ServletException("Could not get datasource. "+
                    "Check datasource definition.") ;
            }
        }
        catch (SQLException e) {
            loggingService.error("Could not get connection. " +
                "Check server status or datasource definition:" + e) ;
            throw new ServletException("Could not get connection. "+
                "Check server status or datasource definition.", e) ;
        }
        loggingService.info("DataAccessService.getConnection(): returning Connection...") ;
        return conn ;        
    }
    
    /***************************************************
    *
    * Gets the named <tt>DataSource</tt>
    *
    * @param   p_name  the <tt>DataSource</tt> name
    *
    * @return  the named <tt>DataSource</tt>
    *
    * @throws  ServletException  if errors occur getting the <tt>Connection</tt>
    *
    ***************************************************/
    public DataSource getDataSource(String p_dataSourceName) throws ServletException {
        DataSource ds = null ;
        try {
            Context initCtx = new InitialContext() ;
            loggingService.info("Looking up datasource 'java:/comp/env/" + p_dataSourceName + "'...") ;
            ds = (DataSource) initCtx.lookup("java:/comp/env/" + p_dataSourceName) ;
            loggingService.info("Found datasource 'java:/comp/env/" + p_dataSourceName + "'...") ;
        }
        catch (NamingException e) {
            loggingService.error("Could not get datasource. " +
                "Check datasource definition:" + e) ;
            throw new ServletException("Could not get datasource. " +
                "Check datasource definition.", e) ;
        }
        return ds ;
    }
    
    /***************************************************
    *
    * Execute an SQL query using a database <tt>Connection</tt>
    *
    * @param  p_query  the SQL query
    *
    * @param  p_connection  the database <tt>Connection</tt>
    *
    * @return  the <tt>ResultSet</tt> from executing the query
    *
    * @throws  ServletException  if errors occur during query execution
    *
    ***************************************************/
    public ResultSet executeQuery(String p_query, Connection p_connection) throws ServletException {
        Statement stmt = null ;
        try {
            stmt = p_connection.createStatement() ;
            ResultSet rs = stmt.executeQuery(p_query) ;
            CachedRowSet crs = new CachedRowSet() ;
            crs.populate(rs) ;
            stmt.close() ;
            p_connection.close() ;
            return ((ResultSet) crs) ;
        }
        catch (SQLException sqle) {
            try {
                LoggingService.getInstance().error("Could not execute query, rolling back: " + sqle) ;
                p_connection.rollback() ;
                if (stmt != null) {
                    stmt.close() ;
                }
                p_connection.close() ;
                throw new ServletException("Could not execute query.", sqle) ;
            }
            catch (SQLException sqle2) {
                LoggingService.getInstance().error("Could not rollback query: " + sqle2) ;
                throw new ServletException("Could not rollback query.", sqle2) ;
            }
        }
    }    
    
    /***************************************************
    *
    * Execute an SQL query using the default database <tt>Connection</tt>
    *
    * @param  p_query  the SQL query
    *
    * @return  the <tt>ResultSet</tt> from executing the query
    *
    * @throws  ServletException  if errors occur during query execution
    *
    ***************************************************/
    public ResultSet executeQuery(String p_query) throws ServletException {
        return executeQuery(p_query, getConnection()) ;
    }
    
    /***************************************************
    *
    * Execute an SQL update/insert statementusing a database <tt>Connection</tt>
    *
    * @param  p_query  the SQL update statement
    *
    * @param  p_connection  the database <tt>Connection</tt>
    *
    * @return  the result code from executing the query
    *
    * @throws  ServletException  if errors occur during query execution
    *
    ***************************************************/
    public int executeUpdate(String p_query, Connection p_connection) throws ServletException {
        Statement stmt = null ;
        try {
            stmt = p_connection.createStatement() ;
            int result = stmt.executeUpdate(p_query) ;
            p_connection.commit() ;
            stmt.close() ;
            p_connection.close() ;
            return result ;
        }
        catch (SQLException sqle) {
            try {
                LoggingService.getInstance().error("Could not execute query, rolling back: " + sqle) ;
                p_connection.rollback() ;
                if (stmt != null) {
                    stmt.close() ;
                }
                p_connection.close() ;
                throw new ServletException("Could not execute query.", sqle) ;
            }
            catch (SQLException sqle2) {
                LoggingService.getInstance().error("Could not rollback query: " + sqle2) ;
                throw new ServletException("Could not rollback query.", sqle2) ;
            }
        }
    }

    /***************************************************
    *
    * Execute an SQL update/insert statement using the 
    * default database <tt>Connection</tt>
    *
    * @param  p_query  the SQL update/insert statement
    *
    * @return  the result code from executing the query
    *
    * @throws  ServletException  if errors occur during query execution
    *
    ***************************************************/
    public int executeUpdate(String p_query) throws ServletException {
        return executeUpdate(p_query, getConnection()) ;
    }
}