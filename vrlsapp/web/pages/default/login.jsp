<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>

<div class="navbar"><html:link href="${sessionScope.url_home}"><span class="nobr">${sessionScope.navbar.home}</span></html:link>
<html:link href="${sessionScope.url_profile}"><span class="nobr">${sessionScope.navbar.profile}</span></html:link>
<html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>
<html:link href="${sessionScope.url_contact}"><span class="nobr">${sessionScope.navbar.contact}</span></html:link>
</div>
<div class="text">
    <h3>LOGIN</h3>
    If you are a registered user here at Virtual Realty Listing Services, please
    enter your userid and password below. If you're not a registered user, please
    <html:link href="${sessionScope.url_profile}">sign up</html:link>.
    <html:form action="/login" focus="username">
        <html:errors />
    <table>
    <tr>
        <td colspan="2" valign="top" align="left">
        </td>
    </tr>
    <tr>
        <td class="text" align="right" valign="top">User ID:</td>
        <td align="left" valign="top"><html:text property="username" /></td>
    </tr>
    <tr>
        <td class="text" align="right" valign="top">Password:</td>
        <td align="left" valign="top"><html:password property="password" /></td>
    </tr>
    <tr>
        <td align="center" colspan="2">
        <br/><html:submit value="Login" /> &nbsp; <html:reset value="Clear form" />
        </td>
    </tr> 
    </table>
    </html:form>
</div>
</body>
