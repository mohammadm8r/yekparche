<%@ include file="../include.jsp" %>
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
    <h3>WELCOME</h3>
	<c:choose>
		<c:when test="${not empty sessionScope.customer}">
			<p>Greetings, ${sessionScope.customer.firstName} ${sessionScope.customer.middleName} ${sessionScope.customer.lastName}!</p>
			<p>You are visiting <i>Rich Rosen Realty</i>, where your online dream home is just a click away!</p>
		</c:when>
		<c:otherwise>
			<p>Welcome to <i>Rich Rosen Realty</i>, the world's leading online realtor since the dawn of civilization as we know it.</p>
			<p>On this website, we offer you online listings for a variety of properties all over the tri-state area.</p>
			<p>To view details about available properties, you must be a registered user, so <html:link href="${sessionScope.url_profile}">sign up</html:link> here, or <html:link href="${sessionScope.url_authcheck}">login</html:link> if you've already done so.</p>
		</c:otherwise>
	</c:choose>
</div>
</body>
