package biz.vrls.struts.action;

import biz.vrls.customer.CustomerProfile;
import biz.vrls.partner.Partner;
import biz.vrls.services.DomainService;
import biz.vrls.services.LoggingService;
import biz.vrls.struts.form.CustomerLoginForm;
import org.apache.struts.action.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static biz.vrls.common.ApplicationConstants.ATTRIBUTE_NAME_CUSTOMER;
import static biz.vrls.common.ApplicationConstants.ATTRIBUTE_NAME_PARTNER;

/**
 * Implementation of <strong>Action</strong> that validates a customer login.
 */

public final class CustomerDuplicateCheckAction extends VrlsBaseAction {
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

    String username = request.getParameter("username");


    int cp =
        DomainService.getInstance().usernameExistence(username);
    
    if (cp == 0) {
        response.getWriter().write("OK");
        response.getWriter().flush();
        response.getWriter().close();
    }

    response.getWriter().write("NOTOK");
    response.getWriter().flush();
    response.getWriter().close();


    // Forward control to the specified success URI
    // return (mapping.findForward("success"));
    return (reroute(request));
    }
}
