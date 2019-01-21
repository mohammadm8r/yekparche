package biz.vrls.struts.action ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**************************************************
*
* Abstract base <code>Action</code> class that extends
* <code>Action</code> and places a <code>Partner</code>
* object in the session.
*
***************************************************/
public abstract class VrlsBaseAction extends Action {
    
    /***************************************************
    *
    * Process the specified HTTP request, and forward to
    * another web component that will create an HTTP response.
    * Return an <code>ActionForward</code> instance describing
    * where and how control should be forwarded, or <code>null</code>
    * if the response has already been completed.
    * In <code>VrlsBaseAction</code>, this method performs
    * initializations before calling <code>process()</code>.
    * Subclasses of this abstract class should override
    * <code>process()</code>, not this method.
    *
    * @param  mapping  The <code>ActionMapping</code> used to
    *                    select this instance
    *
    * @param  form  The optional <code>ActionForm</code> bean 
    *                 for this request (if any)
    *
    * @param  request  The HTTP request we are processing
    *
    * @param  response  The HTTP response we are creating
    *
    * @return  <code>ActionForward</code> to be routed to 
    *
    * @exception Exception if an error occurs
    *
    ***************************************************/
    public final ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        return(performAction(mapping, form, request, response));
    }
    
    /***************************************************
    *
    * Perform the standard request processing for this request, and create
    * the corresponding response. Subclasses of this class should override
    * this method, not <code>execute()</code>.
    *
    * @param  request   The servlet request we are processing
    *
    * @param  response  The servlet response we are creating
    *
    * @return  <code>ActionForward</code> to be routed to 
    *
    * @exception IOException if an input/output error occurs
    *
    * @exception ServletException if a servlet exception is thrown
    * 
    *
    ***************************************************/
    protected abstract ActionForward performAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException ;
    
    /***************************************************
    *
    * After successful authentication, reroute processing
    * to action originally attempted. It does this by retrieving
    * the session attribute "path" and using it to build the URL
    * to reroute to.
    *
    * @return an <code>ActionForward</code> directing to the appropriate URL
    *
    * @throws IOException, ServletException 
    *
    ***************************************************/
    protected ActionForward reroute(HttpServletRequest request)
        throws IOException, ServletException {
            String path = "/home";
            HttpSession session = request.getSession();
            if (session.getAttribute("path") != null) {
            	path = (String) session.getAttribute("path") ;
            	session.removeAttribute("path") ;
            }
            return new ActionForward("/action" + path) ;
    }
        
}
