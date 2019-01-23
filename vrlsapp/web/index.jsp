<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<c:url var="home" value="/action/home" />
<html>
<head>
<title>Virtual Realty Demo Application (from Web Application Architecture book)</title>
<style type="text/css">
a {
    color: #db5d00;
    text-decoration: none;
}
a:hover {
    background-color: #ffffaa;
    color: #d00000;
    text-decoration: underline
}

body, li, p, a, td {
    font-family: arial;
    font-size: 10pt;
}

body {
    background-color: #ffffff
}

code, tt {
    font-family: courier new, courier, monospace;
    font-size: 11pt
}

#tableDiv {
    width: 80%;
    text-align: center;
    margin: 0 auto;
    border-right: #666633 3px solid;
    border-top: #999966 1px solid;
    border-left: #999966 1px solid;
    border-bottom: #666633 3px solid;
    padding: 15px;
}

#banner {
    text-align: left;
    background-color: #999999;
    vertical-align: middle;
    padding: 10px;
}

#bannerSubtitle {
    padding: 8px;
    font-size: 9 pt;
    font-style: italic;
    color: #ffffee
}

#bodyText {
    text-align: left;
    padding: 20px;
    background-color: #dddddd;
}
</style>
<base target="_blank">
</head>
<body>
    <div id="tableDiv">
        <div id="banner">
            <img style="vertical-align: middle; padding: 3px;" src="pages/default/images/logo.gif" vspace="3" hspace="3" />
            <span id="bannerSubtitle">Virtual real estate for virtual people</span>
        </div>
        <div id="bodyText">
            <p>Welcome to the <b>Virtual Realty</b> application website.
            Virtual Realty is a <i>fictitious</i> company that sponsors an online "multiple listing service"
            for real estate brokers.
            </p>
            <ul>
            <li>Brokers can add listings for available properties to a common online database shared by many brokers.
            The application allows Web site visitors to browse all of these listings,
            no matter which broker's Web site they happened to be visiting.</li>
            <li>The page layout seen by visitors is co-branded according to which broker referred them to the site.</li>
            <li>If visitors want to see additional details about available listings,
            they can sign-up with the service as registered users.
            They can establish customer profiles specifying their individual preferences
            (e.g., rentals vs. purchases, houses vs. apartments, number of bedrooms/bathrooms desired, location).</li>
            </ul>
            <p>This demo application employs the <u>Model-View-Controller</u> (<a href="http://en.wikipedia.org/wiki/Model-view-controller">MVC</a>)
            design pattern using the popular <a href="http://struts.apache.org/1.2.9/index.html">Struts</a> framework.
            </p>
            <ul>
            <li>The <b>Model</b> is a small set of JavaBeans persisted in a relational database: <code>CustomerProfile</code>s,
            <code>Listing</code>s, and <code>Partner</code>s (brokers).</li>
            <li>The <b>View</b> makes use of <I>codeless</I> Java Server Pages that use only
            the core <u>Java Standard Tag Library</u>
            (<a href="http://java.sun.com/products/jsp/jstl/">JSTL</a>) tags
            and the version of the Struts HTML taglib (<a href="http://struts.apache.org/1.2.x/userGuide/struts-html.html"><code>struts-html</code></a>) that supports the use of
            <a href="http://java.sun.com/j2ee/1.4/docs/tutorial/doc/JSPIntro7.html">JSP EL</a> expressions.</li>
            <li>The <b>Controller</b> is the <code>ActionServlet</code> class distributed with the Struts framework.
            The <code>struts-config.xml</code> configuration file provides the <u>action mappings</u>
            to direct requests to appropriate "actions" for processing. (This architecture employs two of Sun's
            <a href="http://java.sun.com/blueprints/corej2eepatterns/">Core J2EE Patterns</a>:
            <u>Front Controller</u>
            and
            <u>Service-To-Worker</u>.)</li>
            </ul>
            <p>
            <div><b>Try the app:</b> &nbsp;&nbsp;
            [<html:link href="${pageScope.home}?partner=default">&nbsp;using default layout&nbsp;</html:link>]
            &nbsp;&nbsp;&nbsp;
            [<html:link href="${pageScope.home}?partner=leon">&nbsp;using Shklar Homes co-branding&nbsp;</html:link>]
            &nbsp;&nbsp;&nbsp;
            [<html:link href="${pageScope.home}?partner=rrr">&nbsp;using Rosen Realty co-branding&nbsp;</html:link>]</div>
            &nbsp;&nbsp;&nbsp;
            [<html:link href="action/agency?partner=default">&nbsp;Agency&nbsp;</html:link>]</div>
            <br/>
            <div style="text-align: center">[<a href="mailto:yazdimeister@gmail.com">&nbsp;ask for more info by e-mail&nbsp;</a>]
            &nbsp;&nbsp;&nbsp;
            </div>
            
            
        </div>
    </div>
</body>
</html>
