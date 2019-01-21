<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>

<div class="navbar"><html:link href="${sessionScope.url_home}"><span class="nobr">${sessionScope.navbar.home}</span></html:link>
<html:link href="${sessionScope.url_authcheck}"><span class="nobr">${sessionScope.navbar.authcheck}</span></html:link>
<html:link href="${sessionScope.url_profile}"><span class="nobr">${sessionScope.navbar.profile}</span></html:link>
<html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>
<html:link href="${sessionScope.url_contact}"><span class="nobr">${sessionScope.navbar.contact}</span></html:link>
</div>
<div class="text">
    <h3>CONTACT US</h3>
        Enter your e-mail address below and we will get back to you as soon as possible.
        If appropriate, please indicate which listing you are interested in.
    <html:form action="/contact" focus="subject">
        <html:errors />
    <table>
    <tr>
        <td class="text" VALIGN=center style="text-align: right; vertical-align: top">From:</td>
        <td style="text-align: left; vertical-align: top" VALIGN=center><html:text property="emailAddress" size="50" /></td>
    </tr>
    <tr>
        <td class="text" VALIGN=center style="text-align: right; vertical-align: top">Subject:</td>
        <td style="text-align: left; vertical-align: top" VALIGN=center><html:text property="subject" size="50" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">&nbsp;</td>
        <td style="text-align: left; vertical-align: top"><html:textarea property="body" cols="40" rows="10" /></td>
    </tr>
        <td colspan="2" style="text-align: center">
        <br/><html:submit value=" Send " /> &nbsp; <html:reset value=" Reset " />
        </td>
    </tr> 
    </table>
    </html:form>
</div>
</body>
