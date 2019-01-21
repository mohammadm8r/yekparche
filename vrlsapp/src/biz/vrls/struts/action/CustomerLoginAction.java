package biz.vrls.struts.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import biz.vrls.customer.CustomerProfile;
import biz.vrls.partner.Partner;
import biz.vrls.services.DomainService;
import biz.vrls.services.LoggingService;
import biz.vrls.struts.form.CustomerLoginForm;

import static biz.vrls.common.ApplicationConstants.*;

/**
 * Implementation of <strong>Action</strong> that validates a customer login.
 */

public final class CustomerLoginAction extends VrlsBaseAction {
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
    public ActionForward performAction(ActionMapping mapping,
                 ActionForm form,
                 HttpServletRequest request,
                 HttpServletResponse response)
    throws IOException, ServletException {

    // Create new empty ActionMessages and save it
    ActionMessages msgs = new ActionMessages();
    
    // If this is the first time through, go straight to entry form
    if (form == null || request.getParameterMap().isEmpty()) {
            return (mapping.getInputForward());
    }
    
    // Validate the request parameters specified by the user
    CustomerLoginForm customerLoginForm = (CustomerLoginForm) form;
    String username = customerLoginForm.getUsername();
    String password = customerLoginForm.getPassword();

    HttpSession session = request.getSession();
    
    CustomerProfile cp =
        DomainService.getInstance().retrieveCustomerProfileByLogin(username);
    
    if (cp == null) {
        LoggingService.getInstance().error("Invalid user: " + username) ;
        msgs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.login.auth")) ;
    }
    
    else if (!password.equals(cp.getPasswordHash())) {
        LoggingService.getInstance().error("Invalid password for " + username + ": '" + password + "' should be '" + cp.getPasswordHash() + "'") ;
        msgs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.login.auth")) ;
    }
    
    // Report any msgs we have discovered back to the original form
    if (!msgs.isEmpty()) {
        saveErrors(request, msgs);
        return (mapping.getInputForward());
    }

    // Save the profile for our logged-in customer in the session
    session.setAttribute(ATTRIBUTE_NAME_CUSTOMER, cp);
    Partner partner = DomainService.getInstance().retrievePartnerById(cp.getReferringPartnerId());
    if (partner != null) {
		session.setAttribute(ATTRIBUTE_NAME_PARTNER, partner);
    }

    // Forward control to the specified success URI
    // return (mapping.findForward("success"));
    return (reroute(request));
    }
}
