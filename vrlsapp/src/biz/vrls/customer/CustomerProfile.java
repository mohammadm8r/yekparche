package biz.vrls.customer ;

import biz.vrls.common.* ;

/**************************************************
*
* Specifies interface for <code>CustomerProfile</code>s
* representing individual customer information and preferences.
*
***************************************************/
public interface CustomerProfile extends Identifiable, Logged {

    /***************************************************
    *
    * Returns the customer's login.
    *
    * @return  The customer's login
    *
    ***************************************************/
    public String getLogin() ;
    
    /***************************************************
    *
    * Sets the customer's login.
    *
    * @param  login  The customer's login.
    *
    ***************************************************/
    public void setLogin(String login) ;

    /***************************************************
    *
    * Returns the customer's encrypted password hash.
    *
    * @return  The customer's encrypted password hash
    *
    ***************************************************/
    public String getPasswordHash() ;
    
    /***************************************************
    *
    * Sets the customer's encrypted password hash.
    *
    * @param  passwordHash  The customer's encrypted password hash.
    *
    ***************************************************/
    public void setPasswordHash(String passwordHash) ;

    /***************************************************
    *
    * Returns the customer's first name.
    *
    * @return  The customer's first name 
    *
    ***************************************************/
    public String getFirstName() ;
    
    /***************************************************
    *
    * Sets the customer's first name.
    *
    * @param  firstName  The customer's first name.
    *
    ***************************************************/
    public void setFirstName(String firstName) ;

    /***************************************************
    *
    * Returns the customer's middle name.
    *
    * @return  The customer's middle name 
    *
    ***************************************************/
    public String getMiddleName() ;
    
    /***************************************************
    *
    * Sets the customer's middle name.
    *
    * @param  middleName  The customer's middle name.
    *
    ***************************************************/
    public void setMiddleName(String middleName) ;

    /***************************************************
    *
    * Returns the customer's last name.
    *
    * @return  The customer's last name 
    *
    ***************************************************/
    public String getLastName() ;
    
    /***************************************************
    *
    * Sets the customer's last name.
    *
    * @param  lastName  The customer's last name.
    *
    ***************************************************/
    public void setLastName(String lastName) ;

    /***************************************************
    *
    * Returns the customer's primary address information.
    *
    * @return  The customer's primary address information
    *
    ***************************************************/
    public String getAddress1() ;
    
    /***************************************************
    *
    * Sets the customer's primary address information.
    *
    * @param  address1  The customer's primary address information.
    *
    ***************************************************/
    public void setAddress1(String address1) ;

    /***************************************************
    *
    * Returns the customer's secondary address information.
    *
    * @return  The customer's secondary address information
    *
    ***************************************************/
    public String getAddress2() ;
    
    /***************************************************
    *
    * Sets the customer's secondary address information.
    *
    * @param  address2  The customer's secondary address information.
    *
    ***************************************************/
    public void setAddress2(String address2) ;

    /***************************************************
    *
    * Returns the customer's city.
    *
    * @return  The customer's city
    *
    ***************************************************/
    public String getCity() ;
    
    /***************************************************
    *
    * Sets the customer's city.
    *
    * @param  address2  The customer's city.
    *
    ***************************************************/
    public void setCity(String city) ;

    /***************************************************
    *
    * Returns the customer's state/province code.
    *
    * @return  The customer's state/province code
    *
    ***************************************************/
    public String getStateProvinceCode() ;
    
    /***************************************************
    *
    * Sets the customer's state/province code.
    *
    * @param  stateProvinceCode  The customer's state/province code
    *
    ***************************************************/
    public void setStateProvinceCode(String stateProvinceCode) ;

    /***************************************************
    *
    * Returns the customer's postal code.
    *
    * @return  The customer's postal code
    *
    ***************************************************/
    public String getPostalCode() ;
    
    /***************************************************
    *
    * Sets the customer's postal code.
    *
    * @param  postalCode  The customer's postal code
    *
    ***************************************************/
    public void setPostalCode(String postalCode) ;

    /***************************************************
    *
    * Returns the customer's country code.
    *
    * @return  The customer's country code
    *
    ***************************************************/
    public String getCountryCode() ;
    
    /***************************************************
    *
    * Sets the customer's country code.
    *
    * @param  countryCode  The customer's country code
    *
    ***************************************************/
    public void setCountryCode(String countryCode) ;

    /***************************************************
    *
    * Returns the customer's e-mail address.
    *
    * @return  The customer's e-mail address
    *
    ***************************************************/
    public String getEmailAddress() ;
    
    /***************************************************
    *
    * Sets the customer's e-mail address.
    *
    * @param  emailAddress  The customer's e-mail address
    *
    ***************************************************/
    public void setEmailAddress(String emailAddress) ;

    /***************************************************
    *
    * Returns the customer's phone number.
    *
    * @return  The customer's phone number
    *
    ***************************************************/
    public String getPhoneNumber() ;
    
    /***************************************************
    *
    * Sets the customer's phone number.
    *
    * @param  phoneNumber  The customer's phone number
    *
    ***************************************************/
    public void setPhoneNumber(String phoneNumber) ;

    /***************************************************
    *
    * Returns the customer's level.
    *
    * @return  The customer's level
    *
    ***************************************************/
    public String getLevel() ;
    
    /***************************************************
    *
    * Sets the customer's level.
    *
    * @param  level  The customer's level
    *
    ***************************************************/
    public void setLevel(String level) ;

    /***************************************************
    *
    * Returns the ID for the <code>Partner</code>
    * that referred this customer.
    *
    * @return  The ID for the <code>Partner</code>
    *          that referred this customer
    *
    ***************************************************/
    public int getReferringPartnerId() ;

}