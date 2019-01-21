<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>

<div class="navbar"><html:link href="${sessionScope.url_authcheck}"><span class="nobr">${sessionScope.navbar.authcheck}</span></html:link>
<html:link href="${sessionScope.url_profile}"><span class="nobr">${sessionScope.navbar.profile}</span></html:link>
<html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>
<html:link href="${sessionScope.url_contact}"><span class="nobr">${sessionScope.navbar.contact}</span></html:link>
</div>
<div class="text">
    <c:choose>
		<c:when test="${not empty sessionScope.customer}">
			<p>Hello, ${sessionScope.customer.firstName} ${sessionScope.customer.middleName} ${sessionScope.customer.lastName}!</p>
			<p>Welcome to <i>Virtual Realty Listing Services</i>.</p>
			<p>We provide online listings for many locations.</p>

		</c:when>    
		<c:otherwise>
			<p>Welcome to <i>Virtual Realty Listing Services</i>.</p>
			<p>We provide online listings for many locations.</p>
			<p>To view details about properties, you must be a registered user. Go to our <html:link href="${sessionScope.url_profile}">signup page</html:link> to register, or <html:link href="${sessionScope.url_authcheck}">login</html:link> if you've already signed up.</p>
		</c:otherwise>
    </c:choose>
</div>
</body>
