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
    <h3>CONTACT US</h3>
    <p>Thank you. Your e-mail has been sent. We will get back to you with more information soon.</p>
    <p>Meanwhile, please continue browsing the <html:link href="${sessionScope.url_search}">listings</html:link> on our site.</p>
</div>
</body>
