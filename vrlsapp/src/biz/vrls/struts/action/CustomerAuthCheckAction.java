package biz.vrls.struts.action ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import static biz.vrls.common.ApplicationConstants.*;

/**************************************************
*
* Custom <code>Action</code> that always returns "success".
*
***************************************************/

public class CustomerAuthCheckAction extends VrlsBaseAction {

    /***************************************************
    *
    * Process the specified HTTP request, and forward to
    * another web component that will create an HTTP response.
    * Return an <code>ActionForward</code> instance describing where and how
    * control should be forwarded, or <code>null</code> if the response has
    * already been completed. (For this <code>Action</code>,
    * route to "logout" if customer is logged in, or to "login" if not.)
    *
    * @param  mapping  The <code>ActionMapping</code> used to select this instance
    *
    * @param  form  The optional <code>ActionForm</code> bean for this request (if any)
    *
    * @param  request  The HTTP request we are processing
    *
    * @param  response  The HTTP response we are creating
    *
    * @exception Exception if an error occurs
    *
    ***************************************************/
    public ActionForward performAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession() ;
        if (session.getAttribute(ATTRIBUTE_NAME_CUSTOMER) != null) {
            session.removeAttribute(ATTRIBUTE_NAME_CUSTOMER) ;
            session.removeAttribute(ATTRIBUTE_NAME_SEARCH_RESULTS) ;
            session.removeAttribute(ATTRIBUTE_NAME_LISTING_ID) ;
            return (mapping.findForward(ACTION_FORWARD_LOGOUT)) ;
        }
        else {
            return (mapping.findForward(ACTION_FORWARD_LOGIN)) ;
        }
    }

}
