package biz.vrls.services ;

import java.sql.* ;
import javax.sql.* ;

import org.apache.commons.logging.* ;

import biz.vrls.customer.* ;
import biz.vrls.partner.* ;
import biz.vrls.listing.* ;

public class LoggingService {

    private static LoggingService loggingService ;
    
    private Log log = null ;
    
    /***************************************************
    *
    * Private constructor conforming to singleton pattern
    *
    ***************************************************/
    private LoggingService() {
        log = LogFactory.getLog("biz.vrls") ;
    }
    
    /***************************************************
    *
    * Static method to access singleton instance of class
    *
    * @return  the singleton instance of this class
    *
    ***************************************************/
    public static final LoggingService getInstance() {
        if (loggingService == null) {
            loggingService = new LoggingService() ;
        }
        return loggingService ;
    }

    public void assertLog(boolean p_assertion, String p_msg) {
        if (! p_assertion) {
            error(p_msg) ;
        }
    } 
    
    public void debug(Object p_message) {
        log.debug(p_message) ;
    }

    public void debug(Object p_message, Throwable p_throwable) {
        log.debug(p_message, p_throwable) ;
    }

    public void error(Object p_message) {
        log.error(p_message) ;
    }

    public void error(Object p_message, Throwable p_throwable) {
        log.error(p_message, p_throwable) ;
    }

    public void fatal(Object p_message) {
        log.fatal(p_message) ;
    }

    public void fatal(Object p_message, Throwable p_throwable) {
        log.fatal(p_message, p_throwable) ;
    }

    public void info(Object p_message) {
        log.info(p_message) ;
    }

    public void info(Object p_message, Throwable p_throwable) {
        log.info(p_message, p_throwable) ;
    }

    public void trace(Object p_message) {
        log.trace(p_message) ;
    }

    public void trace(Object p_message, Throwable p_throwable) {
        log.trace(p_message, p_throwable) ;
    }
    
    public void warn(Object p_message) {
        log.warn(p_message) ;
    }

    public void warn(Object p_message, Throwable p_throwable) {
        log.warn(p_message, p_throwable) ;
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled() ;
    }

    public boolean isErrorEnabled() {
        return log.isErrorEnabled() ;
    }

    public boolean isFatalEnabled() {
        return log.isFatalEnabled() ;
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled() ;
    }

    public boolean isTraceEnabled() {
        return log.isTraceEnabled() ;
    }

    public boolean isWarnEnabled() {
        return log.isWarnEnabled() ;
    }

}