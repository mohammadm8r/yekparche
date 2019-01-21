package biz.vrls.partner ;

import biz.vrls.common.* ;

/**************************************************
*
* Implementation for <code>Partner</code>s
* representing individual partner information.

*
***************************************************/
public class PartnerImpl implements Partner {

    /*************************************************************
    *
    * Partner id
    *
    *************************************************************/
    private int id ;

    /*************************************************************
    *
    * Partner description
    *
    *************************************************************/
    private String description ;
    
    /*************************************************************
    *
    * Partner name
    *
    *************************************************************/
    private String name ;
    
    /*************************************************************
    *
    * Partner contact name
    *
    *************************************************************/
    private String contactName ;
    
    /*************************************************************
    *
    * Partner address, part 1
    *
    *************************************************************/
    private String address1 ;
    
    /*************************************************************
    *
    * Partner address, part 2
    *
    *************************************************************/
    private String address2 ;
    
    /*************************************************************
    *
    * Partner state/province code
    *
    *************************************************************/
    private String stateProvinceCode ;
    
    /*************************************************************
    *
    * Partner postal code
    *
    *************************************************************/
    private String postalCode ;
    
    /*************************************************************
    *
    * Partner country code
    *
    *************************************************************/
    private String countryCode ;
    
    /*************************************************************
    *
    * Partner email address
    *
    *************************************************************/
    private String emailAddress ;
    
    /*************************************************************
    *
    * Partner phone number
    *
    *************************************************************/
    private String phoneNumber ;
    
    /*************************************************************
    *
    * Partner code used as name of creative folder
    *
    *************************************************************/
    private String code ;
    
    /*************************************************************
    *
    * URL prefix used for identifying partner URLs
    *
    *************************************************************/
    private String prefix ;
    
    /*************************************************************
    *
    * Date partner was entered into system
    *
    *************************************************************/
    private java.util.Date dateEntered ;
    
    /*************************************************************
    *
    * Date partner information was last changed
    *
    *************************************************************/
    private java.util.Date dateLastModified ;
    
    /***************************************************
    *
    * Returns the <code>Partner</code>'s id.
    *
    * @return  The <code>Partner</code>'s id
    *
    ***************************************************/
    public int getId() {
        return this.id ;
    }
    
    /***************************************************
    *
    * Sets the <code>Partner</code>'s id.
    *
    * @param  id  The <code>Partner</code>'s id
    *
    ***************************************************/
    public void setId(int id) {
        this.id = id ;
    }
    
    /***************************************************
    *
    * Returns the <code>Partner</code>'s description.
    *
    * @return  The <code>Partner</code>'s description
    *
    ***************************************************/
    public String getDescription() {
        return this.description ;
    }
    
    /***************************************************
    *
    * Sets the <code>Partner</code>'s description.
    *
    * @param  id  The <code>Partner</code>'s description
    *
    ***************************************************/
    public void setDescription(String description) {
        this.description = description ;
    }
    
    /***************************************************
    *
    * Returns the partner's identifying name.
    *
    * @return  The partner's identifying name
    *
    ***************************************************/
    public String getName() {
        return this.name ;
    }
    
    /***************************************************
    *
    * Sets the partner's identifying name.
    *
    * @param  name  The partner's identifying name.
    *
    ***************************************************/
    public void setName(String name) {
        this.name = name ;
    }

    /***************************************************
    *
    * Returns the partner's contact name.
    *
    * @return  The partner's contact name 
    *
    ***************************************************/
    public String getContactName() {
        return this.contactName ;
    }
    
    /***************************************************
    *
    * Sets the partner's contace name.
    *
    * @param  contactName  The partner's contact name.
    *
    ***************************************************/
    public void setContactName(String contactName) {
        this.contactName = contactName ;
    }

    /***************************************************
    *
    * Returns the partner's primary address information.
    *
    * @return  The partner's primary address information
    *
    ***************************************************/
    public String getAddress1() {
        return this.address1 ;
    }
    
    /***************************************************
    *
    * Sets the partner's primary address information.
    *
    * @param  address1  The partner's primary address information.
    *
    ***************************************************/
    public void setAddress1(String address1) {
        this.address1 = address1 ;
    }

    /***************************************************
    *
    * Returns the partner's secondary address information.
    *
    * @return  The partner's secondary address information
    *
    ***************************************************/
    public String getAddress2() {
        return this.address2 ;
    }
    
    /***************************************************
    *
    * Sets the partner's secondary address information.
    *
    * @param  address2  The partner's secondary address information.
    *
    ***************************************************/
    public void setAddress2(String address2) {
        this.address2 = address2 ;
    }

    /***************************************************
    *
    * Returns the partner's state/province code.
    *
    * @return  The partner's state/province code
    *
    ***************************************************/
    public String getStateProvinceCode() {
        return this.stateProvinceCode ;
    }
    
    /***************************************************
    *
    * Sets the partner's state/province code.
    *
    * @param  stateProvinceCode  The partner's state/province code
    *
    ***************************************************/
    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode ;
    }

    /***************************************************
    *
    * Returns the partner's postal code.
    *
    * @return  The partner's postal code
    *
    ***************************************************/
    public String getPostalCode() {
        return this.postalCode ;
    }
    
    /***************************************************
    *
    * Sets the partner's postal code.
    *
    * @param  postalCode  The partner's postal code
    *
    ***************************************************/
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode ;
    }

    /***************************************************
    *
    * Returns the partner's country code.
    *
    * @return  The partner's country code
    *
    ***************************************************/
    public String getCountryCode() {
        return this.countryCode ;
    }
    
    /***************************************************
    *
    * Sets the partner's country code.
    *
    * @param  countryCode  The partner's country code
    *
    ***************************************************/
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode ;
    }

    /***************************************************
    *
    * Returns the partner's e-mail address.
    *
    * @return  The partner's e-mail address
    *
    ***************************************************/
    public String getEmailAddress() {
        return this.emailAddress ;
    }
    
    /***************************************************
    *
    * Sets the partner's e-mail address.
    *
    * @param  emailAddress  The partner's e-mail address
    *
    ***************************************************/
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress ;
    }

    /***************************************************
    *
    * Returns the partner's phone number.
    *
    * @return  The partner's phone number
    *
    ***************************************************/
    public String getPhoneNumber() {
        return this.phoneNumber ;
    }
    
    /***************************************************
    *
    * Sets the partner's phone number.
    *
    * @param  phoneNumber  The partner's phone number
    *
    ***************************************************/
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber ;
    }

    /***************************************************
    *
    * Returns the partner code used as the name of the partner's creative media folder.
    *
    * @return  The partner code used as the name of the partner's creative media folder
    *
    ***************************************************/
    public String getCode() {
        return this.code ;
    }
    
    /***************************************************
    *
    * Sets the partner code used as the name of the partner's creative media folder.
    *
    * @param  code  The partner code used as the name of the partner's 
    *                 creative media folder
    *
    ***************************************************/
    public void setCode(String code) {
        this.code = code ;
    }

    /***************************************************
    *
    * Returns the URL prefix used for identifying partner URLs
    *
    * @return  The URL prefix used for identifying partner URLs
    *
    ***************************************************/
    public String getPrefix() {
    return this.prefix;
    }
    
    /***************************************************
    *
    * Sets the URL prefix used for identifying partner URLs
    *
    * @param  prefix  URL prefix used used for identifying partner URLs
    *
    ***************************************************/
    public void setPrefix(String prefix) {
    this.prefix = prefix;
    }

    /***************************************************
    *
    * Returns the date that the information for this <code>Partner</code>
    * was entered.
    *
    * @return  The date that the information for this <code>Partner</code>
    *          was entered
    *
    ***************************************************/
    public java.util.Date getDateEntered() {
        return this.dateEntered ;
    }
    
    /***************************************************
    *
    * Returns the date that any information for this <code>Partner</code>
    * was last changed.
    *
    * @return  The date that any information for this <code>Partner</code>
    *          was last changed
    *
    ***************************************************/
    public java.util.Date getDateLastModified() {
        return this.dateLastModified ;
    }

}
