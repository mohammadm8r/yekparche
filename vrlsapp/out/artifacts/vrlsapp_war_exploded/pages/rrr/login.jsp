<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.jpg" /></div>

<div class="navbar"><html:link href="${sessionScope.url_home}"><span class="nobr">${sessionScope.navbar.home}</span></html:link>
<html:link href="${sessionScope.url_authcheck}"><span class="nobr">${sessionScope.navbar.authcheck}</span></html:link>
<html:link href="${sessionScope.url_profile}"><span class="nobr">${sessionScope.navbar.profile}</span></html:link>
<html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>
<br/><html:img src="${requestScope.imgPartner}/rich.jpg" border="0" />
    <div style="text-align: center; margin-top: 0px; padding-top: 0px;">
    <span class="nobr">Your realtor,</span>
    <span class="nobr">Rich Rosen</span>
    <html:link href="${sessionScope.url_contact}"><span class="nobr">[ contact Rich ]</span></html:link>
    </div>
</div>
<div class="text">
    <h3>LOGIN</h3>
    <p>If you are a registered user here at Rich Rosen Realty, please
    enter your userid and password below. If you're not a registered user, please
    <html:link href="${sessionScope.url_profile}">sign up</html:link>.</p>
    <html:form action="/login" focus="username">
        <html:errors />
    <table>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">User ID:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="username" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Password:</td>
        <td style="text-align: left; vertical-align: top"><html:password property="password" /></td>
    </tr>
        <td colspan="2" style="text-align: center">
        <br/><html:submit value=" Login " /> &nbsp; <html:reset value=" Clear form " />
        </td>
    </tr>
    </table>
    </html:form>
</div>
</body>
