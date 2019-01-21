<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>
<div class="navbar">
    <html:link href="${sessionScope.url_authcheck}"><span class="nobr">${sessionScope.navbar.authcheck}</span></html:link>&nbsp;&nbsp;
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
	<c:choose>
		<c:when test="${not empty sessionScope.customer}">
			<p>Greetings, ${sessionScope.customer.firstName} ${sessionScope.customer.middleName} ${sessionScope.customer.lastName}!</p>
			<p>Here at <i>Shklar Home Realtors</i>, we provide online listings for a variety of properties all over the tri-continent area.</p>
		</c:when>
		<c:otherwise>
			<p>Welcome to <i>Shklar Home Realtors</i>! We provide online listings for a variety of properties all over the tri-continent area.</p>
			<p>To view details about available properties, <html:link href="${sessionScope.url_profile}">sign up</html:link> as a registered user, or <html:link href="${sessionScope.url_authcheck}">login</html:link> if you've already registered.</p>
		</c:otherwise>
	</c:choose>
</div>
</body>
