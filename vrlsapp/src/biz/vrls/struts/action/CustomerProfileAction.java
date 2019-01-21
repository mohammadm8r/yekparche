package biz.vrls.struts.action;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.util.MessageResources;

import biz.vrls.struts.form.CustomerProfileForm;
import biz.vrls.partner.Partner;
import biz.vrls.customer.CustomerProfile;
import biz.vrls.customer.CustomerProfileImpl;
import biz.vrls.services.DomainService;
import static biz.vrls.common.ApplicationConstants.*;

/**
 * Implementation of <strong>Action</strong> that controls user registration.
 */

public final class CustomerProfileAction extends VrlsBaseAction {
    /**
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
    public ActionForward performAction(ActionMapping mapping, ActionForm form,
           HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Create new empty ActionMessages and save it
        ActionMessages msgs = new ActionMessages();
        saveMessages(request, msgs) ;
    
        boolean newCustomer = false ;
        HttpSession session = request.getSession();
        CustomerProfileForm customerProfileForm = (CustomerProfileForm) form ;
        CustomerProfile customer =
            (CustomerProfile) request.getSession().getAttribute(ATTRIBUTE_NAME_CUSTOMER) ;

        // If this is the first time through, populate form from existing profile (if present) and go straight to entry form
        if (request.getParameterMap().isEmpty()) {
            if (customer != null) {
                customerProfileForm.setLogin(customer.getLogin());
                customerProfileForm.setFirstName(customer.getFirstName());
                customerProfileForm.setMiddleName(customer.getMiddleName());
                customerProfileForm.setLastName(customer.getLastName());
                customerProfileForm.setAddress1(customer.getAddress1());
                customerProfileForm.setAddress2(customer.getAddress2());
                customerProfileForm.setCity(customer.getCity());
                customerProfileForm.setStateProvinceCode(customer.getStateProvinceCode());
                customerProfileForm.setPostalCode(customer.getPostalCode());
                customerProfileForm.setCountryCode(customer.getCountryCode());
                customerProfileForm.setEmailAddress(customer.getEmailAddress());
                customerProfileForm.setPhoneNumber(customer.getPhoneNumber());
            }
            return (mapping.getInputForward());
        }
        
        // If not logged in, create new CustomerProfile    
        if (customer == null) {
            newCustomer = true ;
            Partner partner = (Partner) session.getAttribute(ATTRIBUTE_NAME_PARTNER) ;
            customer = new CustomerProfileImpl(partner.getId());
            customer.setId(-1) ;
            // Set user name and password for initial save of new customer
            customer.setLogin(customerProfileForm.getLogin());
            customer.setPasswordHash(customerProfileForm.getPassword());
        }

        // Only set password for existing customer if it's been changed.
        if (customerProfileForm.getPassword().length() > 0) {
            customer.setPasswordHash(customerProfileForm.getPassword());
        }
        customer.setFirstName(customerProfileForm.getFirstName());
        customer.setMiddleName(customerProfileForm.getMiddleName());
        customer.setLastName(customerProfileForm.getLastName());
        customer.setAddress1(customerProfileForm.getAddress1());
        customer.setAddress2(customerProfileForm.getAddress2());
        customer.setCity(customerProfileForm.getCity());
        customer.setStateProvinceCode(customerProfileForm.getStateProvinceCode());
        customer.setPostalCode(customerProfileForm.getPostalCode());
        customer.setCountryCode(customerProfileForm.getCountryCode());
        customer.setEmailAddress(customerProfileForm.getEmailAddress());
        customer.setPhoneNumber(customerProfileForm.getPhoneNumber());
    
        // If this is a new customer, check for duplicate login name
        if (newCustomer) {
            CustomerProfile dupe =
                DomainService.getInstance().retrieveCustomerProfileByLogin(customer.getLogin()) ;
            if (dupe != null) {
                msgs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.profile.duplicate")) ;
            }
        }

        // Report any msgs we have discovered back to the original form
        if (!msgs.isEmpty()) {
            saveErrors(request, msgs);
            return (mapping.getInputForward());
        }

        // å CustomerProfile
        DomainService.getInstance().persistCustomerProfile(customer) ;    
    
        // If this is a new customer, retrieve from database and store CustomerProfile object into session
        if (newCustomer) {
            customer = DomainService.getInstance().retrieveCustomerProfileByLogin(customer.getLogin()) ;
            session.setAttribute(ATTRIBUTE_NAME_CUSTOMER, customer) ;
        }
    
        // Forward control to the specified success URI
        return (mapping.findForward("success"));
    }
}
