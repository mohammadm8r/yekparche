package biz.vrls.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import biz.vrls.customer.*;
import biz.vrls.services.*;

import static biz.vrls.common.ApplicationConstants.*;

/**
 * Form bean for the customer login page.  This form has the following fields,
 * with default values in square brackets:
 * <ul>
 * <li><b>password</b> - Entered password value
 * <li><b>username</b> - Entered username value
 * </ul>
 */

public final class CustomerLoginForm extends ValidatorForm {

    private String password = null;
    private String username = null;

    public String getPassword() {
        return (this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return (this.username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

    }

    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation msgs that have been found.  If no msgs are found, return
     * an <code>ActionErrors</code> object with no recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // The super.validate() call returns results of valdation based on valdation.xml
        ActionErrors msgs = super.validate(mapping, request);
        if ((username == null) || (password == null)) {
                // If path session attribute is set, we've been routed here
                // to can sign in so we can look at listing details
                if (request.getSession().getAttribute("path") != null) {
                     msgs = new ActionErrors();
                     msgs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.login.details"));
                }
                // If the ParameterMap is empty, we are displaying the login
                // form for the first time and the error messages are ignored
                else if (request.getParameterMap().isEmpty()) {
                     msgs = null;
                }
        }

        return msgs;
    }
}
