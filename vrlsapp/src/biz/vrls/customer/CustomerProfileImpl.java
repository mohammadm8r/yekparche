package biz.vrls.customer ;

import biz.vrls.common.* ;

/**************************************************
*
* Implementation for <code>CustomerProfile</code>s
* representing individual customer information and preferences.
*
***************************************************/
public class CustomerProfileImpl implements CustomerProfile {
    
    /*************************************************************
    *
    * Customer id
    *
    *************************************************************/
    private int id ;
    
    /*************************************************************
    *
    * Customer login
    *
    *************************************************************/
    private String login ;
    
    /*************************************************************
    *
    * Customer password hash
    *
    *************************************************************/
    private String passwordHash ;
    
    /*************************************************************
    *
    * Customer first name
    *
    *************************************************************/
    private String firstName ;
    
    /*************************************************************
    *
    * Customer middle name
    *
    *************************************************************/
    private String middleName ;
    
    /*************************************************************
    *
    * Customer last name
    *
    *************************************************************/
    private String lastName ;

    /*************************************************************
    *
    * Customer address, part 1
    *
    *************************************************************/
    private String address1 ;
    
    /*************************************************************
    *
    * Customer address, part 2
    *
    *************************************************************/
    private String address2 ;
    
    /*************************************************************
    *
    * City
    *
    *************************************************************/
    private String city ;
    
    /*************************************************************
    *
    * Customer state/province code
    *
    *************************************************************/
    private String stateProvinceCode ;
    
    /*************************************************************
    *
    * Customer postal code
    *
    *************************************************************/
    private String postalCode ;
    
    /*************************************************************
    *
    * Customer country code
    *
    *************************************************************/
    private String countryCode ;
    
    /*************************************************************
    *
    * Customer email address
    *
    *************************************************************/
    private String emailAddress ;
    
    /*************************************************************
    *
    * Customer phone number
    *
    *************************************************************/
    private String phoneNumber ;
    
    /*************************************************************
    *
    * Customer level
    *
    *************************************************************/
    private String level ;
    
    /*************************************************************
    *
    * Id for partner that referred customer
    *
    *************************************************************/
    private int referringPartnerId ;
    
    /*************************************************************
    *
    * Date customer was first entered
    *
    *************************************************************/
    private java.util.Date dateEntered ;

    /*************************************************************
    *
    * Date customer was last modified
    *
    *************************************************************/
    private java.util.Date dateLastModified ;

    /***************************************************
    *
    * Basic constructor.
    *
    * @param  referringPartnerId  Id of partner who referred this customer
    *
    ***************************************************/
    public CustomerProfileImpl(int referringPartnerId) {
        this.referringPartnerId = referringPartnerId ;
        java.util.Date now = new java.util.Date() ;
        dateEntered = now ;
        dateLastModified = now ;
    }
    
    /***************************************************
    *
    * Returns the customer's id.
    *
    * @return  The customer's id
    *
    ***************************************************/
    public int getId() {
        return id ;
    }
    
    /***************************************************
    *
    * Sets the customer's id.
    *
    * @param  id  The customer's id
    *
    ***************************************************/
    public void setId(int id) {
        this.id = id ;
    }
    
    /***************************************************
    *
    * Returns the customer's login.
    *
    * @return  The customer's login
    *
    ***************************************************/
    public String getLogin() {
        return login ;
    }
    
    /***************************************************
    *
    * Sets the customer's login.
    *
    * @param  login  The customer's login.
    *
    ***************************************************/
    public void setLogin(String login) {
    	this.login = login ;
    }

    /***************************************************
    *
    * Returns the customer's encrypted password hash.
    *
    * @return  The customer's encrypted password hash
    *
    ***************************************************/
    public String getPasswordHash() {
        return passwordHash ;
    }
    
    /***************************************************
    *
    * Sets the customer's encrypted password hash.
    *
    * @param  passwordHash  The customer's encrypted password hash.
    *
    ***************************************************/
    public void setPasswordHash(String passwordHash) {
    	this.passwordHash = passwordHash ;
    }

    /***************************************************
    *
    * Returns the customer's first name.
    *
    * @return  The customer's first name 
    *
    ***************************************************/
    public String getFirstName() {
        return firstName ;
    }
    
    /***************************************************
    *
    * Sets the customer's first name.
    *
    * @param  firstName  The customer's first name.
    *
    ***************************************************/
    public void setFirstName(String firstName) {
    	this.firstName = firstName ;
    }

    /***************************************************
    *
    * Returns the customer's middle name.
    *
    * @return  The customer's middle name 
    *
    ***************************************************/
    public String getMiddleName() {
        return middleName ;
    }
    
    /***************************************************
    *
    * Sets the customer's middle name.
    *
    * @param  middleName  The customer's middle name.
    *
    ***************************************************/
    public void setMiddleName(String middleName) {
    	this.middleName = middleName ;
    }

    /***************************************************
    *
    * Returns the customer's last name.
    *
    * @return  The customer's last name 
    *
    ***************************************************/
    public String getLastName() {
        return lastName ;
    }
    
    /***************************************************
    *
    * Sets the customer's last name.
    *
    * @param  lastName  The customer's last name.
    *
    ***************************************************/
    public void setLastName(String lastName) {
    	this.lastName = lastName ;
    }

    /***************************************************
    *
    * Returns the customer's primary address information.
    *
    * @return  The customer's primary address information
    *
    ***************************************************/
    public String getAddress1() {
        return address1 ;
    }
    
    /***************************************************
    *
    * Sets the customer's primary address information.
    *
    * @param  address1  The customer's primary address information.
    *
    ***************************************************/
    public void setAddress1(String address1) {
    	this.address1 = address1 ;
    }

    /***************************************************
    *
    * Returns the customer's secondary address information.
    *
    * @return  The customer's secondary address information
    *
    ***************************************************/
    public String getAddress2() {
        return address2 ;
    }
    
    /***************************************************
    *
    * Sets the customer's secondary address information.
    *
    * @param  address2  The customer's secondary address information.
    *
    ***************************************************/
    public void setAddress2(String address2) {
    	this.address2 = address2 ;
    }

    /***************************************************
    *
    * Returns the customer's city.
    *
    * @return  The customer's city
    *
    ***************************************************/
    public String getCity() {
        return city ;
    }
    
    /***************************************************
    *
    * Sets the customer's city.
    *
    * @param  address2  The customer's city.
    *
    ***************************************************/
    public void setCity(String city) {
    	this.city = city ;
    }

    /***************************************************
    *
    * Returns the customer's state/province code.
    *
    * @return  The customer's state/province code
    *
    ***************************************************/
    public String getStateProvinceCode() {
        return stateProvinceCode ;
    }
    
    /***************************************************
    *
    * Sets the customer's state/province code.
    *
    * @param  stateProvinceCode  The customer's state/province code
    *
    ***************************************************/
    public void setStateProvinceCode(String stateProvinceCode) {
    	this.stateProvinceCode = stateProvinceCode ;
    }

    /***************************************************
    *
    * Returns the customer's postal code.
    *
    * @return  The customer's postal code
    *
    ***************************************************/
    public String getPostalCode() {
        return postalCode ;
    }
    
    /***************************************************
    *
    * Sets the customer's postal code.
    *
    * @param  postalCode  The customer's postal code
    *
    ***************************************************/
    public void setPostalCode(String postalCode) {
    	this.postalCode = postalCode ;
    }

    /***************************************************
    *
    * Returns the customer's country code.
    *
    * @return  The customer's country code
    *
    ***************************************************/
    public String getCountryCode() {
        return countryCode ;
    }
    
    /***************************************************
    *
    * Sets the customer's country code.
    *
    * @param  countryCode  The customer's country code
    *
    ***************************************************/
    public void setCountryCode(String countryCode) {
    	this.countryCode = countryCode ;
    }

    /***************************************************
    *
    * Returns the customer's e-mail address.
    *
    * @return  The customer's e-mail address
    *
    ***************************************************/
    public String getEmailAddress() {
        return emailAddress ;
    }
    
    /***************************************************
    *
    * Sets the customer's e-mail address.
    *
    * @param  emailAddress  The customer's e-mail address
    *
    ***************************************************/
    public void setEmailAddress(String emailAddress) {
    	this.emailAddress = emailAddress ;
    }

    /***************************************************
    *
    * Returns the customer's phone number.
    *
    * @return  The customer's phone number
    *
    ***************************************************/
    public String getPhoneNumber() {
        return phoneNumber ;
    }
    
    /***************************************************
    *
    * Sets the customer's phone number.
    *
    * @param  phoneNumber  The customer's phone number
    *
    ***************************************************/
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber ;
    }

    /***************************************************
    *
    * Returns the customer's level.
    *
    * @return  The customer's level
    *
    ***************************************************/
    public String getLevel() {
        return level ;
    }
    
    /***************************************************
    *
    * Sets the customer's level.
    *
    * @param  level  The customer's level
    *
    ***************************************************/
    public void setLevel(String level) {
        this.level = level ;
    }

    /***************************************************
    *
    * Returns the ID for the <code>Partner</code>
    * that referred this customer.
    *
    * @return  The ID for the <code>Partner</code>
    *          that referred this customer
    *
    ***************************************************/
    public int getReferringPartnerId() {
        return referringPartnerId ;
    }

    /***************************************************
    *
    * Returns the date that the information for this object
    * was entered.
    *
    * @return  The date that the information for this object
    *          was entered
    *
    ***************************************************/
    public java.util.Date getDateEntered() {
        return dateEntered ;
    }
    
    /***************************************************
    *
    * Returns the date that any information for this object
    * was last changed.
    *
    * @return  The date that any information for this object
    *          was last changed
    *
    ***************************************************/
    public java.util.Date getDateLastModified() {
        return dateLastModified ;
    }

}
