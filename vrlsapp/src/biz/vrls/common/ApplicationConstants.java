package biz.vrls.common ;

/**************************************************
*
* Common interface specifying global application constants
*
***************************************************/
public interface ApplicationConstants {

    public static final String APP_NAVBAR_PREFIX = "app.navbar." ;
    public static final String APP_NAVBAR_SUFFIX_AUTH = ".auth" ;

    public static final String ATTRIBUTE_NAME_CUSTOMER = "customer";
    public static final String ATTRIBUTE_NAME_PARTNER = "partner";
    public static final String ATTRIBUTE_NAME_SEARCH_RESULTS = "searchResults";
    public static final String ATTRIBUTE_NAME_LISTING_ID = "listingId";
    public static final String ATTRIBUTE_NAME_LISTING = "listing";
	
    public static final String ACTION_FORWARD_LOGIN   = "login";
    public static final String ACTION_FORWARD_LOGOUT  = "logout";
    public static final String ACTION_FORWARD_SUCCESS = "success";
    public static final String ACTION_FORWARD_ONE     = "one";
    public static final String ACTION_FORWARD_MANY    = "many";
    public static final String ACTION_FORWARD_NOT_AUTHORIZED = "notauthorized";

    public static final String REQUEST_PARAM_PARTNER  = "partner";

    public static final String ERRORS = "errors";
}