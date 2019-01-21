package biz.vrls.struts.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import biz.vrls.listing.Listing;
import biz.vrls.listing.ListingImpl;
import biz.vrls.services.DomainService;
import biz.vrls.services.LoggingService;
import biz.vrls.struts.form.CustomerSearchForm;
import static biz.vrls.common.ApplicationConstants.*;

/**
 * Implementation of <strong>Action</strong> that controls listing search.
 */

public final class CustomerSearchAction extends VrlsBaseAction {
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

        // New search - so, remove listingId and search attributes from session
        HttpSession session = request.getSession() ;
        session.removeAttribute(ATTRIBUTE_NAME_LISTING_ID) ;
        session.removeAttribute(ATTRIBUTE_NAME_SEARCH_RESULTS) ;

        // Create new empty ActionMessages and save it
        ActionMessages msgs = new ActionMessages();
        saveMessages(request, msgs) ;
        
        // If this is the first time through, go straight to entry form
        if (form == null || request.getParameterMap().isEmpty()) {
            return (mapping.getInputForward());
        }
        
        CustomerSearchForm customerSearchForm = (CustomerSearchForm) form ;
        ResultSet rs = null ;
    
        try {
            // Call DomainService method to retrieve search results
            rs = DomainService.getInstance().retrieveSearchResults(
            customerSearchForm.getTypes(),
            customerSearchForm.getOfferTypes(),
            customerSearchForm.getMinBedrooms(),
            customerSearchForm.getMinBathrooms()) ;
    
            // If no rows in ResultSet, indicate this with error.search.none
            if (! rs.next()) {
                msgs.add("none", new ActionMessage("error.search.none")) ;
                saveMessages(request, msgs);
                return (mapping.getInputForward());
            }
        }
        catch (SQLException sqle) {
            LoggingService.getInstance().error("Error occurred while retrieving search results: " + sqle) ;
            msgs.add("other", new ActionMessage("error.search.other")) ;
        }
        
        // If no msgs, convert ResultSet to a List of Listings,
        // then store this into session as "searchresults"
        List<Listing> searchResults = new ArrayList<Listing>() ;
        Listing listing = null ;
        try {
            rs.beforeFirst() ;
            while (rs.next()) {
                listing = new ListingImpl(rs.getInt("referring_partner_id")) ;
                listing.setId(rs.getInt("listing_id")) ;
                listing.setTitle(rs.getString("listing_title")) ;
                listing.setDescription(rs.getString("listing_desc")) ;
                listing.setType(rs.getInt("listing_type_code")) ;
                listing.setOfferType(rs.getInt("listing_offer_type_code")) ;
                listing.setRegion(rs.getString("listing_region")) ;
                listing.setNumBedrooms(rs.getInt("listing_num_bedrooms")) ;
                listing.setNumBathrooms(rs.getInt("listing_num_bathrooms")) ;
                listing.setMonthlyPayment(rs.getFloat("listing_monthly_payment")) ;
                listing.setPurchasePrice(rs.getFloat("listing_purchase_price")) ;
                listing.setStatus(rs.getInt("listing_status_code")) ;
                listing.setDateEntered(rs.getDate("date_entered")) ;
                listing.setDateLastModified(rs.getDate("date_last_modified")) ;
                searchResults.add(listing) ;
            }
        }
        catch (SQLException sqle) {
            LoggingService.getInstance().error("Error occurred while populating search results: " + sqle) ;
            msgs.add("other", new ActionMessage("error.search.other")) ;
        }
        
        if (searchResults.size() == 0) {
            // searchResults should never have been created if the size was zero,
            // so if it comes back with zero size, this must be an error
            LoggingService.getInstance().error("Error occurred while populating search results: should not have been empty.") ;
            msgs.add("other", new ActionMessage("error.search.other")) ;
        }
    
        // Report any msgs we have discovered back to the original form
        if (!msgs.isEmpty()) {
            saveMessages(request, msgs);
            return (mapping.getInputForward());
        }
    
        session.setAttribute(ATTRIBUTE_NAME_SEARCH_RESULTS, searchResults) ;
        
        // If size of resultMapList is 1, forward to "one",
        // otherwise forward to "many"
        if (searchResults.size() == 1) {
            session.setAttribute(ATTRIBUTE_NAME_LISTING_ID,
                Integer.toString(listing.getId())) ;
            return (mapping.findForward(ACTION_FORWARD_ONE)) ;
        }
        else {
            return (mapping.findForward(ACTION_FORWARD_MANY));
        }
    }
}
