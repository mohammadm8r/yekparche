package biz.vrls.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import biz.vrls.partner.Partner;
import biz.vrls.services.DomainService;
import biz.vrls.util.AppTextLabels;

import static biz.vrls.common.ApplicationConstants.*;

public class VrlsServletFilter implements Filter {

       private FilterConfig filterConfig ;
       
       public void init(FilterConfig filterConfig) 
          throws ServletException {
          this.filterConfig = filterConfig;
       }
       public void destroy() {
          this.filterConfig = null;
       }

    
    /***************************************************
    *
    * Perform the standard request processing for this request, and create
    * the corresponding response. Overrides base <code>ActionServlet</code>
    * version of this method to set the
    *
    * @param  request   The servlet request 
    *
    * @param  response  The servlet response
    *
    * @param  chain     The servlet filter chain
    *
    * @exception IOException if an input/output error occurs
    *
    * @exception ServletException if a servlet exception is thrown
    * 
    ***************************************************/
    public void doFilter(ServletRequest request, 
                         ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request ;
        HttpSession session = httpRequest.getSession() ;
        filterConfig.getServletContext().log("obtained httpRequest and session\n");

        // Only call determine partner if partner is not set
        // or is defined in the query string
        if (session.getAttribute(ATTRIBUTE_NAME_PARTNER) == null ||
            httpRequest.getParameter(REQUEST_PARAM_PARTNER) != null) {
            session.setAttribute(ATTRIBUTE_NAME_PARTNER, determinePartner(httpRequest)) ;
            filterConfig.getServletContext().log("determined partner:" + session.getAttribute(ATTRIBUTE_NAME_PARTNER) + "\n");
        }
        if (session.getAttribute("navbar") == null) {
            AppTextLabels navbar =
            new AppTextLabels(APP_NAVBAR_PREFIX, session) ;
            session.setAttribute("navbar", navbar) ;
        }
        chain.doFilter(request, response);
    }
    
    /***************************************************
    *
    * Establish the <code>Partner</code> associated with this user during this session.
    *
    * The active partner can be set in one of three ways (in order of preference):
    * 1 - To the partner associated with the explicitly provided
    *      "partner" parameter in the query string
    * 2 - To the partner associated with the "prefix" found in the referring URL
    * 3 - To the "default" partner
    *
    ***************************************************/
    protected Partner determinePartner(HttpServletRequest request)
        throws IOException, ServletException {
        Partner selectedPartner = null;
        Partner defaultPartner = null ;
        Collection<Partner> partners = DomainService.getInstance().retrievePartners() ;
        String referer = request.getHeader("Referer") ;
        String partnerCode = request.getParameter(REQUEST_PARAM_PARTNER) ;
        boolean gotPartner = false ;

        if (partnerCode == null) {
            partnerCode = "default" ;
        }
        else {            
            referer = null ; // partner parameter overrides Referer HTTP header
        }
        
        /************************************************
        *
        * Loop through collection of defined partners.
        * When a partner is found whose code matches the
        *    provided query string parameter,
        *    or whose prefix matches the prefix found in
        *    the referring URL, return that partner.
        *  Otherwise, return the default partner.
        *
        *************************************************/

        for (Partner partner : partners) {
            String prefix = partner.getPrefix() ;
            if (partner.getCode().equalsIgnoreCase("default")) {
                defaultPartner = partner;
            }
            // Test for match in query string parameter
            if (partner.getCode().equalsIgnoreCase(partnerCode)) {
                   // Either a match was found, or the default partner was found
                   selectedPartner = partner ;
                break;
            }
            // Test for match in partner prefix
            else if (referer != null && prefix.length() <= referer.length() &&
                     prefix.equalsIgnoreCase(referer.substring(0,prefix.length()))) {
                selectedPartner = partner ;
                break;
            }
        }
        return selectedPartner == null ? defaultPartner : selectedPartner ;
    }
        
}
