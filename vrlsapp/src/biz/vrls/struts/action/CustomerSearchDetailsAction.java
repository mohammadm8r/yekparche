package biz.vrls.struts.action;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

import org.apache.struts.action.* ;
import org.apache.struts.util.* ;

import biz.vrls.struts.form.* ;
import biz.vrls.partner.* ;
import biz.vrls.customer.* ;
import biz.vrls.listing.* ;
import biz.vrls.services.* ;
import biz.vrls.util.* ;

import static biz.vrls.common.ApplicationConstants.*;

/**
 * Implementation of <strong>Action</strong> for retrieval of listing details.
 */

public final class CustomerSearchDetailsAction extends VrlsBaseAction {
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
        saveMessages(request,msgs) ;
        
        HttpSession session = request.getSession() ;
        Listing listing = null ;
        String listingId = request.getParameter(ATTRIBUTE_NAME_LISTING_ID) ;

        // If listingId query string param is null/blank,
        // get listingId attribute from session.
        // If THAT'S also null, log error.

        if (listingId == null || listingId.equals("")) {
            listingId = (String) session.getAttribute(ATTRIBUTE_NAME_LISTING_ID) ;
        }

        if (listingId == null || listingId.equals("")) {
            LoggingService.getInstance().info("Listing ID parameter not present.") ;
            msgs.add("notfound", new ActionMessage("error.details.param")) ;
        }
        
        // If listingId query string is NOT null,
        // use it to get listing from domain service
        // and set new session attribute
        
        else {
            try {
                listing =
                    DomainService.getInstance().retrieveListingById(Integer.parseInt(listingId)) ;
                if (listing == null) {
                    LoggingService.getInstance().info("Error retrieving listing " +
                        listingId + ".") ;
                    msgs.add("notfound", new ActionMessage("error.details.notfound", listingId)) ;
                    session.removeAttribute("listingId") ;
                }
                else {
                    session.setAttribute(ATTRIBUTE_NAME_LISTING_ID, listingId) ;
                    request.setAttribute(ATTRIBUTE_NAME_LISTING, listing) ;
                }
            }
            catch (NumberFormatException nfe) {
                LoggingService.getInstance().info("Listing ID parameter not an integer.") ;
                msgs.add("other", new ActionMessage("error.details.param")) ;
            }
        }
        
        if (msgs.isEmpty()) {
            if (session.getAttribute("customer") == null) {
        	    msgs.add("username", new ActionMessage("error.login.details")) ;
        	    session.setAttribute("path", mapping.getPath());
        	    return (mapping.findForward(ACTION_FORWARD_NOT_AUTHORIZED)) ;
            }
        }
        else {
            saveMessages(request, msgs) ;
            return (mapping.getInputForward()) ;
        }
    
        return (mapping.findForward(ACTION_FORWARD_SUCCESS)) ;
    }
}
