<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>
<div class="navbar">
    <html:link href="${sessionScope.url_home}"><span class="nobr">${sessionScope.navbar.home}</span></html:link>&nbsp;&nbsp;
    <html:link href="${sessionScope.url_profile}"><span class="nobr">${sessionScope.navbar.profile}</span></html:link>&nbsp;&nbsp;
    <html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>&nbsp;&nbsp;
    <html:link href="${sessionScope.url_contact}"><span class="nobr">${sessionScope.navbar.contact}</span></html:link>
</div>
<div class="photo">
    <html:img src="${requestScope.imgPartner}/leon.gif" border="0" />
    <br/>Your realtor,
    <br/>Leon Shklar
    <br/><html:link href="${sessionScope.url_contact}">[ contact Leon ]</html:link>
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
        <td COLSPAN=2 style="text-align: left; vertical-align: top">
        </td>
    </tr>
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
