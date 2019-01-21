<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>
<div class="navbar">
    <html:link href="${sessionScope.url_home}"><span class="nobr">${sessionScope.navbar.home}</span></html:link>&nbsp;&nbsp;
    <html:link href="${sessionScope.url_authcheck}"><span class="nobr">${sessionScope.navbar.authcheck}</span></html:link>&nbsp;&nbsp;
    <html:link href="${sessionScope.url_profile}"><span class="nobr">${sessionScope.navbar.profile}</span></html:link>&nbsp;&nbsp;
    <html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>&nbsp;&nbsp;
</div>
<div class="photo">
    <html:img src="${requestScope.imgPartner}/leon.gif" border="0" />
    <br/>Your realtor,
    <br/>Leon Shklar
    <br/><html:link href="${sessionScope.url_contact}">[ contact Leon ]</html:link>
</div>
<div class="text">
    <h3>CONTACT US</h3>
    <p>Thank you. Your e-mail has been sent. We will get back to you with more information soon.</p>
    <p>Meanwhile, please continue browsing the
    <html:link href="${sessionScope.url_search}">listings</html:link> on our site.</p>
</div>
</body>
