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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.util.MessageResources;

import biz.vrls.struts.form.CustomerProfileForm;
import biz.vrls.partner.Partner;
import biz.vrls.customer.CustomerProfile;
import biz.vrls.services.DomainService ;
import static biz.vrls.common.ApplicationConstants.*;

/**
 * Implementation of <strong>Action</strong> that controls customer contact email.
 */

public final class CustomerContactAction extends VrlsBaseAction {
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
    ActionMessages msgs = new ActionMessages() ;
    saveMessages(request, msgs) ;
    
    // If this is the first time through, go straight to entry form
    if (form == null || request.getParameterMap().isEmpty()) {
        return (mapping.getInputForward());
    }

    Partner partner =
        (Partner) request.getSession().getAttribute(ATTRIBUTE_NAME_PARTNER) ;
    String partnerEmail = partner.getEmailAddress() ;
    
    // SEND EMAIL HERE!
        
    // Forward control to the specified success URI
    return (mapping.findForward(ACTION_FORWARD_SUCCESS));
    }
}
