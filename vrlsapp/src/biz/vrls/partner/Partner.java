package biz.vrls.partner ;

import biz.vrls.common.* ;

/**************************************************
*
* Specifies interface for <code>Partner</code>s
* representing individual partner information.

*
***************************************************/
public interface Partner extends Identifiable, Describable, Logged {

    /***************************************************
    *
    * Returns the partner's identifying name.
    *
    * @return  The partner's identifying name
    *
    ***************************************************/
    public String getName() ;
    
    /***************************************************
    *
    * Sets the partner's identifying name.
    *
    * @param  name  The partner's identifying name.
    *
    ***************************************************/
    public void setName(String name) ;

    /***************************************************
    *
    * Returns the partner's contact name.
    *
    * @return  The partner's contact name 
    *
    ***************************************************/
    public String getContactName() ;
    
    /***************************************************
    *
    * Sets the partner's contace name.
    *
    * @param  contactName  The partner's contact name.
    *
    ***************************************************/
    public void setContactName(String contactName) ;

    /***************************************************
    *
    * Returns the partner's primary address information.
    *
    * @return  The partner's primary address information
    *
    ***************************************************/
    public String getAddress1() ;
    
    /***************************************************
    *
    * Sets the partner's primary address information.
    *
    * @param  address1  The partner's primary address information.
    *
    ***************************************************/
    public void setAddress1(String address1) ;

    /***************************************************
    *
    * Returns the partner's secondary address information.
    *
    * @return  The partner's secondary address information
    *
    ***************************************************/
    public String getAddress2() ;
    
    /***************************************************
    *
    * Sets the partner's secondary address information.
    *
    * @param  address2  The partner's secondary address information.
    *
    ***************************************************/
    public void setAddress2(String address2) ;

    /***************************************************
    *
    * Returns the partner's state/province code.
    *
    * @return  The partner's state/province code
    *
    ***************************************************/
    public String getStateProvinceCode() ;
    
    /***************************************************
    *
    * Sets the partner's state/province code.
    *
    * @param  stateProvinceCode  The partner's state/province code
    *
    ***************************************************/
    public void setStateProvinceCode(String stateProvinceCode) ;

    /***************************************************
    *
    * Returns the partner's postal code.
    *
    * @return  The partner's postal code
    *
    ***************************************************/
    public String getPostalCode() ;
    
    /***************************************************
    *
    * Sets the partner's postal code.
    *
    * @param  postalCode  The partner's postal code
    *
    ***************************************************/
    public void setPostalCode(String postalCode) ;

    /***************************************************
    *
    * Returns the partner's country code.
    *
    * @return  The partner's country code
    *
    ***************************************************/
    public String getCountryCode() ;
    
    /***************************************************
    *
    * Sets the partner's country code.
    *
    * @param  countryCode  The partner's country code
    *
    ***************************************************/
    public void setCountryCode(String countryCode) ;

    /***************************************************
    *
    * Returns the partner's e-mail address.
    *
    * @return  The partner's e-mail address
    *
    ***************************************************/
    public String getEmailAddress() ;
    
    /***************************************************
    *
    * Sets the partner's e-mail address.
    *
    * @param  emailAddress  The partner's e-mail address
    *
    ***************************************************/
    public void setEmailAddress(String emailAddress) ;

    /***************************************************
    *
    * Returns the partner's phone number.
    *
    * @return  The partner's phone number
    *
    ***************************************************/
    public String getPhoneNumber() ;
    
    /***************************************************
    *
    * Sets the partner's phone number.
    *
    * @param  phoneNumber  The partner's phone number
    *
    ***************************************************/
    public void setPhoneNumber(String phoneNumber) ;

    /***************************************************
    *
    * Returns the partner code used as the name of the partner's creative media folder.
    *
    * @return  The partner code used as the name of the partner's creative media folder
    *
    ***************************************************/
    public String getCode() ;
    
    /***************************************************
    *
    * Sets the partner code used as the name of the partner's creative media folder.
    *
    * @param  code  The partner code used as the name of the partner's 
    *                 creative media folder
    *
    ***************************************************/
    public void setCode(String code) ;

    /***************************************************
    *
    * Returns the URL prefix used for identifying partner URLs
    *
    * @return  The URL prefix used for identifying partner URLs
    *
    ***************************************************/
    public String getPrefix() ;
    
    /***************************************************
    *
    * Sets the URL prefix used for identifying partner URLs
    *
    * @param  prefix  URL prefix used used for identifying partner URLs
    *
    ***************************************************/
    public void setPrefix(String prefix) ;

    /***************************************************
    *
    * Returns the date that the information for this <code>Partner</code>
    * was entered.
    *
    * @return  The date that the information for this <code>Partner</code>
    *          was entered
    *
    ***************************************************/

    public java.util.Date getDateEntered() ;
    
    /***************************************************
    *
    * Returns the date that any information for this <code>Partner</code>
    * was last changed.
    *
    * @return  The date that any information for this <code>Partner</code>
    *          was last changed
    *
    ***************************************************/
    public java.util.Date getDateLastModified() ;
    

}
