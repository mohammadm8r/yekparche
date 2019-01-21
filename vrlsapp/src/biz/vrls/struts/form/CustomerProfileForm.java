package biz.vrls.struts.form;

import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.action.ActionMapping;

import biz.vrls.services.* ;
import biz.vrls.customer.* ;
import static biz.vrls.common.ApplicationConstants.*;

/**
 * Form bean for the customer sign-up page.  This form has the following fields,
 * with default values in square brackets:
 * <ul>
 * <li><b>login</b> - Entered login user name value
 * <li><b>password</b> - Entered password value
 * <li><b>firstName</b> - Entered first name
 * <li><b>middleName<b> - Entered middle name
 * <li><b>lastName<b> - Entered last name
 * <li><b>address1<b> - Entered primary address
 * <li><b>address2<b> - Entered secondary address
 * <li><b>stateProvinceCode<b> - Entered US state or Canadian province
 * <li><b>postalCode<b> - Entered zip code
 * <li><b>countryCode<b> - Entered country
 * <li><b>emailAddress<b> - Entered email address
 * <li><b>phoneNumber<b> - Entered phone number
 * <li><b>level<b> - Requested subscription level
 * </ul>
 */

public final class CustomerProfileForm extends ValidatorForm {

    private String password = null;
    private String passwordConfirm = null;
    private String login = null;
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String address1 = null;
    private String address2 = null;
    private String city = null;
    private String stateProvinceCode = null;
    private String postalCode = null;
    private String countryCode = null;
    private String countryPostal = null;
    private String emailAddress = null;
    private String phoneNumber = null;
    private String level = null;

    public String getPassword() {
        return (this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return (this.passwordConfirm);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getLogin() {
        return (this.login);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return (this.firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName ;
    }

    public String getMiddleName() {
        return (this.middleName) ;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName ;
    }

    public String getLastName() {
        return (this.lastName) ;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName ;
    }

    public String getAddress1() {
        return (this.address1) ;
    }

    public void setAddress1(String address1) {
        this.address1 = address1 ;
    }

    public String getAddress2() {
        return (this.address2) ;
    }

    public void setAddress2(String address1) {
        this.address2 = address1 ;
    }

    public String getCity() {
        return (this.city) ;
    }

    public void setCity(String city) {
        this.city = city ;
    }
    
    public String getStateProvinceCode() {
        return (this.stateProvinceCode) ;
    }

    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode ;
    }

    public Collection getStateProvinceOptions() throws ServletException {
        return DomainService.getInstance().getStateProvinceOptions() ;
        // return DomainService.STATE_PROVINCE_OPTIONS ;
    }
    
    public Collection getCountryOptions() throws ServletException {
        return DomainService.getInstance().getCountryOptions() ;
        // return DomainService.COUNTRY_OPTIONS ;
    }
    
    public String getPostalCode() {
        return (this.postalCode) ;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode ;
    }

    public String getCountryCode() {
        return (this.countryCode) ;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode ;
    }

    public String getCountryPostal() {
        return (this.countryPostal) ;
    }

    public void setCountryPostal(String countryPostal) {
        this.countryPostal = countryPostal ;
    }

    public String getEmailAddress() {
        return (this.emailAddress) ;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress ;
    }

    public String getPhoneNumber() {
        return (this.phoneNumber) ;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber ;
    }

    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation msgs that have been found.  If no msgs are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     * @return null if no validation errors, otherwise an ActionErrors object containing the errors
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors msgs = super.validate(mapping, request);
        // On initial input, field verification should be suspended
        if (request.getParameterMap().isEmpty()) {
            msgs = null;
        }
        // if new customer (no customer in session) and both password fields are blank,
        //    return an error (if only one is blank we will have the field mismatch anyway)
        else if (request.getSession().getAttribute(ATTRIBUTE_NAME_CUSTOMER) == null) {
            if (msgs == null) {
                msgs = new ActionErrors();
            }
            // if login field is blank, return an error
            if (login.equals("")) {
                msgs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.profile.login"));
            }
            // if both password fields are blank, return an error
            //    (if only one is blank we will have the field mismatch)
            if (password.equals("") && passwordConfirm.equals("")) {          
                msgs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.profile.passwordNewUser"));
            }
        }
 
        return msgs;
    }
}
