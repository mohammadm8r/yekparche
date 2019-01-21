package biz.vrls.struts.form;

import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import biz.vrls.services.* ;
import biz.vrls.customer.* ;

/**
 * Form bean for the customer search form.  This form has the following fields,
 * with default values in square brackets:
 * <ul>
 * <li><b>m_types</b> - Entered property types
 * <li><b>m_offerTypes</b> - Entered usage types
 * <li><b>m_minBedrooms</b> - Entered minimal bedrooms
 * <li><b>m_minBathrooms<b> - Entered minimal bathrooms
 * </ul>
 */

public final class CustomerSearchForm extends ActionForm {

    private String[] m_types ;
    private String[] m_offerTypes ;
    private String m_minBedrooms ;
    private String m_minBathrooms ;

    public String[] getTypes() {
        return m_types ;
    }
    
    public void setTypes(String[] p_types) {
        m_types = p_types ;
    }
    
    public String[] getOfferTypes() {
        return m_offerTypes ;
    }
    
    public void setOfferTypes(String[] p_offerTypes) {
        m_offerTypes = p_offerTypes ;
    }

    public String getMinBedrooms() {
        return m_minBedrooms ;
    }
    
    public void setMinBedrooms(String p_minBedrooms) {
        m_minBedrooms = p_minBedrooms ;
    }
    
    public String getMinBathrooms() {
        return m_minBathrooms ;
    }
    
    public void setMinBathrooms(String p_minBathrooms) {
        m_minBathrooms = p_minBathrooms ;
    }

    public Collection getTypeOptions() throws ServletException {
        return DomainService.getInstance().getListingTypeOptions() ;
    }
    
    public Collection getOfferTypeOptions() throws ServletException {
        return DomainService.getInstance().getListingOfferTypeOptions() ;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

    }

}
