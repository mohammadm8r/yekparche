package biz.vrls.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import biz.vrls.customer.CustomerProfile;

/**
 * Form bean for the customer email contact page.  This form has the following fields,
 * with default values in square brackets:
 * <ul>
 * <li><b>email</b> - Pre-filled-in if customer logged on
 * <li><b>subject</b> - Email subject (possibly pre-populated)
 * <li><b>body</b> - Entered text
 * </ul>
 */

public final class CustomerContactForm extends ValidatorForm {

    private String emailAddress ;
    
    private String subject ;
    
    private String body ;
    
    private int listingId ;

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress ;
    }

    public String getSubject() {
        return this.subject ;
    }

    public void setSubject(String subject) {
        this.subject = subject ;
    }

    public String getBody() {
        return this.body ;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getListingId() {
        return this.listingId ;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId ;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        CustomerProfile customer = 
            (CustomerProfile) request.getSession().getAttribute("customer");
        if (customer != null) {
            setEmailAddress(customer.getEmailAddress()) ;
        }
        
        String listingId = (String) request.getSession().getAttribute("listingId") ;
        if (listingId != null && listingId.length() > 0) {
            int lid = -1 ;
            try {
                lid = Integer.parseInt(listingId) ;
            }
            catch (NumberFormatException nfe) {
            }                
            setListingId(lid) ;
            setSubject("Inquiry about listing #" + listingId) ;
        }

        setBody(null);
    }

    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation msgs that have been found.  If no msgs are found, return
     * an <code>ActionErrors</code> object with no recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */

    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors msgs = super.validate(mapping, request);
        
        if (request.getParameterMap().isEmpty()) {
            msgs = null;
        }

        return msgs ;
    }
}
