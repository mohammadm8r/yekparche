package biz.vrls.services ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletException;

import biz.vrls.customer.CustomerProfile;
import biz.vrls.customer.CustomerProfileImpl;
import biz.vrls.listing.Listing;
import biz.vrls.listing.ListingImpl;
import biz.vrls.partner.Partner;
import biz.vrls.partner.PartnerImpl;
import biz.vrls.struts.form.OptionsCollectionElement;
import biz.vrls.util.TextUtils;

/**************************************************
*
* This singleton service class provides atomic access
* to data model objects from persisted storage.
*
***************************************************/
public class DomainService {

    private static DomainService domainService ;
    
    private LoggingService loggingService = null ;
    
    /***************************************************
    *
    * Private constructor conforming to singleton pattern
    *
    ***************************************************/
    private DomainService() {
        loggingService = LoggingService.getInstance() ;
    }
    
    /***************************************************
    *
    * Static method to access singleton instance of class
    *
    * @return  the singleton instance of this class
    *
    ***************************************************/
    public static final DomainService getInstance() {
        if (domainService == null) {
            domainService = new DomainService() ;
        }
        return domainService ;
    }

    public static final String SQL_CUSTOMER_SELECT_BY_ID = 
        "select * from vrls_customer_profile_data where cust_id = ?" ;
    
    public static final String SQL_CUSTOMER_SELECT_BY_LOGIN =
        "select * from vrls_customer_profile_data where cust_login = ?" ;

    public static final String SQL_CUSTOMER_COUNT =
        "select * from vrls_customer_profile_data where cust_login = ?" ;

    public static final String SQL_CUSTOMER_UPDATE =
        "update vrls_customer_profile_data" +
        "   set cust_password_hash       = ? " +
        ",      cust_first_name          = ? " +
        ",      cust_middle_name         = ? " +
        ",      cust_last_name           = ? " +
        ",      cust_address1            = ? " +
        ",      cust_address2            = ? " +
        ",      cust_city                = ? " +
        ",      cust_state_province_code = ? " +
        ",      cust_postal_code         = ? " +
        ",      cust_country_code        = ? " +
        ",      cust_phone               = ? " +
        ",      cust_email_address       = ? " +
        " where cust_id = ?" ;
    
    public static final String SQL_CUSTOMER_INSERT =
        "insert into vrls_customer_profile_data" +
        "   (cust_login, cust_password_hash" +
        "   ,cust_first_name, cust_middle_name, cust_last_name" +
        "   ,cust_address1, cust_address2" +
        "   ,cust_city, cust_state_province_code, cust_postal_code" +
        "   ,cust_country_code, cust_phone, cust_email_address" +
        "   ,referring_partner_id, date_entered) " +
        "   values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate()) ;" ;

    public static final String SQL_PARTNER_SELECT =
        "select * from vrls_partners" ;
    
    public static final String SQL_PARTNER_SELECT_BY_ID =
        "select * from vrls_partners where partner_id = ?" ;
    
    public static final String SQL_PARTNER_SELECT_BY_CODE =
        "select * from vrls_partners where partner_code = ?" ;

    public static final String SQL_PARTNER_UPDATE =
        "update vrls_partners " +
        "   set partner_name                = ? " +
        ",      partner_desc                = ? " +
        ",      partner_contact_name        = ? " +
        ",      partner_address1            = ? " +
        ",      partner_address2            = ? " +
        ",      partner_state_province_code = ? " +
        ",      partner_postal_code         = ? " +
        ",      partner_country_code        = ? " +
        ",      partner_contact_email       = ? " ;
    
    public static final String SQL_PARTNER_INSERT =
        "insert into vrls_partners " +
        "   (partner_name, partner_desc, partner_contact_name, partner_address1, partner_address2, " +
        "    partner_state_province_code, partner_postal_code, partner_country_code, partner_contact_email) " +
        "values(?,?,?,?,?,?,?,?,?);" ;

    public static final String SQL_LISTING_SELECT_BY_ID =
        "select * from vrls_listings where listing_id = ?" ;
    
    public static final String SQL_LISTING_UPDATE =
        "" ;
    
    public static final String SQL_LISTING_INSERT =
        "" ;

    public static final String SQL_LISTING_IMAGE_SELECT_BY_ID =
        "select listing_image_url from vrls_listing_images where listing_id = ? and is_primary_image = 'y'" ;
    
    public CustomerProfile retrieveCustomerProfileById(int p_customerId) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        CustomerProfile customer = null ;

        try {
            conn = das.getConnection() ;
            ps = conn.prepareStatement(SQL_CUSTOMER_SELECT_BY_ID) ;
            ps.setInt(1, p_customerId) ;
            rs = ps.executeQuery() ;
            if (rs.next()) {
                customer = new CustomerProfileImpl(rs.getInt("referring_partner_id")) ;
                customer.setId(rs.getInt("cust_id")) ;
                customer.setLogin(rs.getString("cust_login")) ;
                customer.setPasswordHash(rs.getString("cust_password_hash")) ;
                customer.setFirstName(rs.getString("cust_first_name")) ;
                customer.setMiddleName(rs.getString("cust_middle_name")) ;
                customer.setLastName(rs.getString("cust_last_name")) ;
                customer.setAddress1(rs.getString("cust_address1")) ;
                customer.setAddress2(rs.getString("cust_address2")) ;
                customer.setCity(rs.getString("cust_city")) ;
                customer.setStateProvinceCode(rs.getString("cust_state_province_code")) ;
                customer.setPostalCode(rs.getString("cust_postal_code")) ;
                customer.setCountryCode(rs.getString("cust_country_code")) ;
                customer.setEmailAddress(rs.getString("cust_email_address")) ;
                customer.setPhoneNumber(rs.getString("cust_phone")) ;
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve CustomerProfile: " + sqle) ;
            throw new ServletException("Could not retrieve CustomerProfile.", sqle) ;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close() ;
                }
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve CustomerProfile: " + sqle2) ;
            }
        }
        return customer ;
    }

    public CustomerProfile retrieveCustomerProfileByLogin(String p_customerLogin) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        CustomerProfile customer = null ;
        
        try {
            conn = das.getConnection() ;
            ps = conn.prepareStatement(SQL_CUSTOMER_SELECT_BY_LOGIN) ;
            ps.setString(1, p_customerLogin) ;
            rs = ps.executeQuery() ;
            if (rs.next()) {
                customer = new CustomerProfileImpl(rs.getInt("referring_partner_id")) ;
                customer.setId(rs.getInt("cust_id")) ;
                customer.setLogin(rs.getString("cust_login")) ;
                customer.setPasswordHash(rs.getString("cust_password_hash")) ;
                customer.setFirstName(rs.getString("cust_first_name")) ;
                customer.setMiddleName(rs.getString("cust_middle_name")) ;
                customer.setLastName(rs.getString("cust_last_name")) ;
                customer.setAddress1(rs.getString("cust_address1")) ;
                customer.setAddress2(rs.getString("cust_address2")) ;
                customer.setCity(rs.getString("cust_city")) ;
                customer.setStateProvinceCode(rs.getString("cust_state_province_code")) ;
                customer.setPostalCode(rs.getString("cust_postal_code")) ;
                customer.setCountryCode(rs.getString("cust_country_code")) ;
                customer.setPhoneNumber(rs.getString("cust_phone")) ;
                customer.setEmailAddress(rs.getString("cust_email_address")) ;
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve CustomerProfile: " + sqle) ;
            throw new ServletException("Could not retrieve CustomerProfile.", sqle) ;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close() ;
                }
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve CustomerProfile: " + sqle2) ;
            }
        }
        return customer ;
    }
    public int usernameExistence(String p_customerLogin) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        String count ="0";

        try {
            conn = das.getConnection() ;
            ps = conn.prepareStatement(SQL_CUSTOMER_COUNT) ;
            ps.setString(1,p_customerLogin) ;
            System.out.println(p_customerLogin);
            rs = ps.executeQuery() ;
            if (rs.next()) {
                count  = rs.getString(1) ;
                System.out.println(count);
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve CustomerProfile: " + sqle) ;
            throw new ServletException("Could not retrieve CustomerProfile.", sqle) ;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close() ;
                }
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve CustomerProfile: " + sqle2) ;
            }
        }
        return Integer.parseInt(count) ;
    }

    public boolean persistCustomerProfile(CustomerProfile p_customer) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        boolean successful = false ;
        
        try {
            loggingService.info("Getting connection...") ;
            conn = das.getConnection() ;
            loggingService.info("Got connection...") ;
            if (p_customer.getId() <= 0) {
                loggingService.info("Getting ready to insert...") ;
                ps = conn.prepareStatement(SQL_CUSTOMER_INSERT) ;
                ps.setString(1, p_customer.getLogin()) ;
				loggingService.info(p_customer.getLogin());
                ps.setString(2, p_customer.getPasswordHash()) ;
				loggingService.info(p_customer.getPasswordHash());
                ps.setString(3, p_customer.getFirstName()) ;
				loggingService.info(p_customer.getFirstName());
                ps.setString(4, p_customer.getMiddleName()) ;
				loggingService.info(p_customer.getMiddleName());
                ps.setString(5, p_customer.getLastName()) ;
				loggingService.info(p_customer.getLastName());
                ps.setString(6, p_customer.getAddress1()) ;
				loggingService.info(p_customer.getAddress1());
                ps.setString(7, p_customer.getAddress2()) ;
				loggingService.info(p_customer.getAddress2());
                ps.setString(8, p_customer.getCity()) ;
				loggingService.info(p_customer.getCity());
                ps.setString(9, p_customer.getStateProvinceCode()) ;
				loggingService.info(p_customer.getStateProvinceCode());
                ps.setString(10, p_customer.getPostalCode()) ;
				loggingService.info(p_customer.getPostalCode());
                ps.setString(11, p_customer.getCountryCode()) ;
				loggingService.info(p_customer.getCountryCode());
                ps.setString(12, p_customer.getPhoneNumber()) ;
				loggingService.info(p_customer.getPhoneNumber());
                ps.setString(13, p_customer.getEmailAddress()) ;
				loggingService.info(p_customer.getEmailAddress());
                ps.setInt(14, p_customer.getReferringPartnerId()) ;
                loggingService.info("About to insert...") ;
                int result = ps.executeUpdate() ;
                loggingService.info("Done inserting... (" + result + ")") ;
                if (result == 1) {
                    loggingService.info("Success...") ;
                    successful = true ;
                }
            }
            else {    
                loggingService.info("Getting ready to update...") ;
                ps = conn.prepareStatement(SQL_CUSTOMER_UPDATE) ;
                ps.setString(1, p_customer.getPasswordHash()) ;
                ps.setString(2, p_customer.getFirstName()) ;
                ps.setString(3, p_customer.getMiddleName()) ;
                ps.setString(4, p_customer.getLastName()) ;
                ps.setString(5, p_customer.getAddress1()) ;
                ps.setString(6, p_customer.getAddress2()) ;
                ps.setString(7, p_customer.getCity()) ;
                ps.setString(8, p_customer.getStateProvinceCode()) ;
                ps.setString(9, p_customer.getPostalCode()) ;
                ps.setString(10, p_customer.getCountryCode()) ;
                ps.setString(11, p_customer.getPhoneNumber()) ;
                ps.setString(12, p_customer.getEmailAddress()) ;
                ps.setInt(13, p_customer.getId()) ;
                loggingService.info("About to update...") ;
                int result = ps.executeUpdate() ;
                loggingService.info("Done updating...") ;
                if (result == 1) {
                    loggingService.info("Success...") ;
                    successful = true ;
                }
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not persist CustomerProfile: " + sqle) ;
            throw new ServletException("Could not persist CustomerProfile.", sqle) ;
        }
        finally {
            try {
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.commit();
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during persist CustomerProfile: " + sqle2) ;
            }
        }
        return successful ;
    }

    public Collection<Partner> retrievePartners() throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        Partner partner = null ;
        Collection<Partner> partners = new ArrayList<Partner>();        
        try {
            conn = das.getConnection() ;
            loggingService.error(conn.toString()) ;
            ps = conn.prepareStatement(SQL_PARTNER_SELECT) ;
            rs = ps.executeQuery() ;
            while (rs.next()) {
                partner = new PartnerImpl() ;
                partner.setId(rs.getInt("partner_id")) ;
                partner.setName(rs.getString("partner_name")) ;
                partner.setDescription(rs.getString("partner_desc")) ;
                partner.setContactName(rs.getString("partner_contact_name")) ;
                partner.setAddress1(rs.getString("partner_address1")) ;
                partner.setAddress2(rs.getString("partner_address2")) ;
                partner.setStateProvinceCode(rs.getString("partner_state_province_code")) ;
                partner.setPostalCode(rs.getString("partner_postal_code")) ;
                partner.setCountryCode(rs.getString("partner_country_code")) ;
                partner.setEmailAddress(rs.getString("partner_contact_email")) ;
                // partner.setPhone(rs.getString("partner_phone")) ;
                partner.setCode(rs.getString("partner_code")) ;
                partner.setPrefix(rs.getString("partner_prefix")) ;
                // partner.setDateLastVisited(rs.getDate("partner_last_visited")) ;
        	    partners.add(partner);
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve Partner: " + sqle) ;
            throw new ServletException("Could not retrieve Partner.", sqle) ;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close() ;
                }
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve Partner: " + sqle2) ;
            }
        }
        return partners ;
    }

    public Partner retrievePartnerById(int p_partnerId) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        Partner partner = null ;
                
        try {
            conn = das.getConnection() ;
            ps = conn.prepareStatement(SQL_PARTNER_SELECT_BY_ID) ;
            ps.setInt(1, p_partnerId) ;
            rs = ps.executeQuery() ;
            if (rs.next()) {
                partner = new PartnerImpl() ;
                partner.setId(rs.getInt("partner_id")) ;
                partner.setName(rs.getString("partner_name")) ;
                partner.setDescription(rs.getString("partner_desc")) ;
                partner.setContactName(rs.getString("partner_contact_name")) ;
                partner.setAddress1(rs.getString("partner_address1")) ;
                partner.setAddress2(rs.getString("partner_address2")) ;
                partner.setStateProvinceCode(rs.getString("partner_state_province_code")) ;
                partner.setPostalCode(rs.getString("partner_postal_code")) ;
                partner.setCountryCode(rs.getString("partner_country_code")) ;
                partner.setEmailAddress(rs.getString("partner_contact_email")) ;
                // partner.setPhone(rs.getString("partner_phone")) ;
                partner.setCode(rs.getString("partner_code")) ;
                // partner.setDateLastVisited(rs.getDate("partner_last_visited")) ;
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve Partner: " + sqle) ;
            throw new ServletException("Could not retrieve Partner.", sqle) ;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close() ;
                }
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve Partner: " + sqle2) ;
            }
        }
        return partner ;
    }

    public Partner retrievePartnerByCode(String p_partnerCode) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        Partner partner = null ;
        
        try {
            conn = das.getConnection() ;
            ps = conn.prepareStatement(SQL_PARTNER_SELECT_BY_CODE) ;
            ps.setString(1, p_partnerCode) ;
            rs = ps.executeQuery() ;
            if (rs.next()) {
                partner = new PartnerImpl() ;
                partner.setId(rs.getInt("partner_id")) ;
                partner.setName(rs.getString("partner_name")) ;
                partner.setDescription(rs.getString("partner_desc")) ;
                partner.setContactName(rs.getString("partner_contact_name")) ;
                partner.setAddress1(rs.getString("partner_address1")) ;
                partner.setAddress2(rs.getString("partner_address2")) ;
                partner.setStateProvinceCode(rs.getString("partner_state_province_code")) ;
                partner.setPostalCode(rs.getString("partner_postal_code")) ;
                partner.setCountryCode(rs.getString("partner_country_code")) ;
                partner.setEmailAddress(rs.getString("partner_contact_email")) ;
                partner.setPhoneNumber(rs.getString("partner_phone")) ;
                partner.setCode(rs.getString("partner_code")) ;
                return partner ;
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve Partner: " + sqle) ;
            throw new ServletException("Could not retrieve Partner.", sqle) ;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close() ;
                }
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve Partner: " + sqle2) ;
            }
        }
        return partner ;
    }

    public boolean persistPartner(Partner p_partner) throws ServletException {
        loggingService.info("Persisting partner...") ;
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        boolean successful = false ;
        
        try {
            loggingService.info("Getting connection...") ;
            conn = das.getConnection() ;
            loggingService.info("Got connection [whoo hoo!]...") ;
            if (p_partner.getId() <= 0) {
                loggingService.info("Inserting...") ;
                ps = conn.prepareStatement(SQL_PARTNER_INSERT) ;
                loggingService.info("Statement prepared...") ;
                ps.setString(1, p_partner.getName()) ;
                ps.setString(2, p_partner.getDescription()) ;
                ps.setString(3, p_partner.getContactName()) ;
                ps.setString(4, p_partner.getAddress1()) ;
                ps.setString(5, p_partner.getAddress2()) ;
                ps.setString(6, p_partner.getStateProvinceCode()) ;
                ps.setString(7, p_partner.getPostalCode()) ;
                ps.setString(8, p_partner.getCountryCode()) ;
                ps.setString(9, p_partner.getEmailAddress()) ;
                loggingService.info("Statement executing...") ;
                int result = ps.executeUpdate() ;
                loggingService.info("Partner should have been inserted: (" + result + ")") ;
            }
            else {    
                loggingService.info("Updating...") ;
                ps = conn.prepareStatement(SQL_PARTNER_UPDATE) ;
                loggingService.info("Statement prepared...") ;
                ps.setString(1, p_partner.getName()) ;
                ps.setString(2, p_partner.getDescription()) ;
                ps.setString(3, p_partner.getContactName()) ;
                ps.setString(4, p_partner.getAddress1()) ;
                ps.setString(5, p_partner.getAddress2()) ;
                ps.setString(6, p_partner.getStateProvinceCode()) ;
                ps.setString(7, p_partner.getPostalCode()) ;
                ps.setString(8, p_partner.getCountryCode()) ;
                ps.setString(9, p_partner.getEmailAddress()) ;
                ps.setInt(10, p_partner.getId()) ;
                loggingService.info("Statement executing...") ;
                int result = ps.executeUpdate() ;
                loggingService.info("Partner should have been updated: (" + result + ")") ;
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not persist Partner: " + sqle) ;
            throw new ServletException("Could not persist Partner.", sqle) ;
        }
        finally {
            try {
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during persist Partner: " + sqle2) ;
            }
        }
        return successful ;
    }

    public Listing retrieveListingById(int p_listingId) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        Listing listing = null ;
                
        try {
            conn = das.getConnection() ;
            ps = conn.prepareStatement(SQL_LISTING_SELECT_BY_ID) ;
            ps.setInt(1, p_listingId) ;
            rs = ps.executeQuery() ;
            if (rs.next()) {
                listing = new ListingImpl(rs.getInt("referring_partner_id")) ;
                listing.setId(rs.getInt("listing_id")) ;
                listing.setTitle(rs.getString("listing_title")) ;
                listing.setDescription(rs.getString("listing_desc")) ;
                listing.setType(rs.getInt("listing_type_code")) ;
                listing.setOfferType(rs.getInt("listing_offer_type_code")) ;
                listing.setRegion(rs.getString("listing_region")) ;
                listing.setNumBedrooms(rs.getInt("listing_num_bedrooms")) ;
                listing.setNumBathrooms(rs.getInt("listing_num_bathrooms")) ;
                listing.setMonthlyPayment(rs.getFloat("listing_monthly_payment")) ;
                listing.setPurchasePrice(rs.getFloat("listing_purchase_price")) ;
                listing.setStatus(rs.getInt("listing_status_code")) ;
                listing.setDateEntered(rs.getDate("date_entered")) ;
                listing.setDateLastModified(rs.getDate("date_last_modified")) ;
                ps = conn.prepareStatement(SQL_LISTING_IMAGE_SELECT_BY_ID) ;
                ps.setInt(1, p_listingId) ;
                rs = ps.executeQuery() ;
                if (rs.next()) {
                    listing.setMainImageUrl(rs.getString("listing_image_url")) ;
                }
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not retrieve Listing: " + sqle) ;
            throw new ServletException("Could not retrieve Listing.", sqle) ;
        }
        finally {
            try {
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during retrieve Listing: " + sqle2) ;
            }
        }
        return listing ;
    }

    public boolean persistListing(Listing p_listing) throws ServletException {
        DataAccessService das = DataAccessService.getInstance() ;
        Connection conn = null ;
        PreparedStatement ps = null ;
        boolean successful = false ;
                
        try {
            conn = das.getConnection() ;
            if (p_listing.getId() < 0) {
                ps = conn.prepareStatement(SQL_LISTING_INSERT) ;
                ps.setInt(1, p_listing.getType()) ;
                ps.setInt(2, p_listing.getOfferType()) ;
                ps.setFloat(3, p_listing.getNumBedrooms()) ;
                ps.setFloat(4, p_listing.getNumBathrooms()) ;
                ps.setFloat(5, p_listing.getPurchasePrice()) ;
                ps.setFloat(6, p_listing.getMonthlyPayment()) ;
                ps.setInt(7, p_listing.getStatus()) ;
                int result = ps.executeUpdate() ;
                if (result == 1) {
                    successful = true ;
                }
            }
            else {    
                ps = conn.prepareStatement(SQL_LISTING_UPDATE) ;
                ps.setInt(1, p_listing.getType()) ;
                ps.setInt(2, p_listing.getOfferType()) ;
                ps.setFloat(3, p_listing.getNumBedrooms()) ;
                ps.setFloat(4, p_listing.getNumBathrooms()) ;
                ps.setFloat(5, p_listing.getPurchasePrice()) ;
                ps.setFloat(6, p_listing.getMonthlyPayment()) ;
                ps.setInt(7, p_listing.getStatus()) ;
                ps.setInt(8, p_listing.getId()) ;
                int result = ps.executeUpdate() ;
                if (result == 1) {
                    successful = true ;
                }
            }
        }
        catch (SQLException sqle) {
            loggingService.error("Could not persist Listing: " + sqle) ;
            throw new ServletException("Could not persist Listing.", sqle) ;
        }
        finally {
            try {
                if (ps != null) {
                    ps.close() ;
                }
                if (conn != null) {
                    loggingService.info("Closing connection after retrieve Partner.") ;
                    conn.close() ;
                    loggingService.info("Connection closed.") ;
                }
            }
            catch (SQLException sqle2) {
                loggingService.error("Cleanup error during persist Listing: " + sqle2) ;
            }
        }
        return successful ;
    }

    public ResultSet retrieveSearchResults(String[] p_propertyTypes,
        String[] p_offerTypes, String p_minBedrooms, String p_minBathrooms)
        throws ServletException { 
            ResultSet rs ;
            StringBuffer query = new StringBuffer() ;
            try {
                query.append("select * from vrls_listings where 1 = 1") ;
                query.append(" and listing_num_bedrooms >= "  + p_minBedrooms) ;
                query.append(" and listing_num_bathrooms >= " + p_minBathrooms) ;
                if (p_propertyTypes != null && p_propertyTypes.length > 0) {
                    List<String> propertyTypeList =
                        Arrays.asList(p_propertyTypes) ;
                    String propertyTypeString =
                        TextUtils.collectionToString(propertyTypeList, ", ") ;
                    query.append(" and listing_type_code in (" + 
                        propertyTypeString + ")") ;
                }
                if (p_offerTypes != null && p_offerTypes.length > 0) {
                    List<String> offerTypeList =
                        Arrays.asList(p_offerTypes) ;
                    String offerTypeString =
                        TextUtils.collectionToString(offerTypeList, ", ") ;
                    query.append(" AND listing_offer_type_code IN (" + 
                        offerTypeString + ")") ;
                }
                loggingService.info("The query is: " + query.toString()) ;
                rs = DataAccessService.getInstance().executeQuery(query.toString()) ;
            }
            catch (Exception e) {
                loggingService.error("Could not retrieve search results: " + e) ;
                throw new ServletException("Could not retrieve search results.", e) ;
            }
            
            return rs ;
    }

    public Collection<OptionsCollectionElement> getStateProvinceOptions() throws ServletException {
        Collection<OptionsCollectionElement> c =
        	new TreeSet<OptionsCollectionElement>(OptionsCollectionElement.SORT_BY_VALUE) ;
        try {
            ResultSet rs =
                DataAccessService.getInstance().executeQuery("select * from vrls_xref_state_province") ;
            while (rs.next()) {
                String value = rs.getString("state_province_code") ;
                String label = rs.getString("state_province_name") ;
                OptionsCollectionElement oce = new OptionsCollectionElement(value, label) ;
                c.add(oce) ;
            }
        }
        catch (Exception e) {
            LoggingService.getInstance().error("Could not retrieve state/province option list: " + e) ;
            throw new ServletException("Could not retrieve state/province option list: " + e) ;
        }
        
        return c ;
    }

    public Collection<OptionsCollectionElement> getCountryOptions() throws ServletException {
        Collection<OptionsCollectionElement> c =
        	new TreeSet<OptionsCollectionElement>(OptionsCollectionElement.SORT_BY_LABEL) ;
        try {
            ResultSet rs =
                DataAccessService.getInstance().executeQuery("select * from vrls_xref_country") ;
            while (rs.next()) {
                String value = rs.getString("country_code") ;
                String label = rs.getString("country_name") ;
                OptionsCollectionElement oce = new OptionsCollectionElement(value, label) ;
                c.add(oce) ;
            }
        }
        catch (Exception e) {
            LoggingService.getInstance().error("Could not retrieve countries option list: " + e) ;
            throw new ServletException("Could not retrieve countries option list: " + e) ;
        }
        
        return c ;
    }

    public Collection<OptionsCollectionElement> getListingTypeOptions() throws ServletException {
        Collection<OptionsCollectionElement> c =
        	new TreeSet<OptionsCollectionElement>(OptionsCollectionElement.SORT_BY_VALUE) ;
        try {
            ResultSet rs =
                DataAccessService.getInstance().executeQuery("select * from vrls_xref_listing_type") ;
            while (rs.next()) {
                int value = rs.getInt("listing_type_code") ;
                String label = rs.getString("listing_type_name") ;
                OptionsCollectionElement oce = new OptionsCollectionElement(Integer.toString(value), label) ;
                c.add(oce) ;
            }
        }
        catch (Exception e) {
            LoggingService.getInstance().error("Could not retrieve listing types option list: " + e) ;
            throw new ServletException("Could not retrieve listing types option list: " + e) ;
        }
        
        return c ;
    }

    public Collection<OptionsCollectionElement> getListingOfferTypeOptions() throws ServletException {
        Collection<OptionsCollectionElement> c =
        	new TreeSet<OptionsCollectionElement>(OptionsCollectionElement.SORT_BY_VALUE) ;
        try {
            ResultSet rs =
                DataAccessService.getInstance().executeQuery("select * from vrls_xref_listing_offer_type") ;
            while (rs.next()) {
                int value = rs.getInt("listing_offer_type_code") ;
                String label = rs.getString("listing_offer_type_name") ;
                OptionsCollectionElement oce = new OptionsCollectionElement(Integer.toString(value), label) ;
                c.add(oce) ;
            }
        }
        catch (Exception e) {
            LoggingService.getInstance().error("Could not retrieve listing offer types option list: " + e) ;
            throw new ServletException("Could not retrieve listing offer types option list: " + e) ;
        }
        
        return c ;
    }

}