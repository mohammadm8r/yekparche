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
    <c:forEach var="listing" items="${sessionScope.searchResults}">
        <c:url value="/action/details" var="detailURL" scope="page">
            <c:param name="listingId" value="${listing.id}" />
        </c:url>
        <span class="listingTitle">
            <html:link href="${pageScope.detailURL}">${listing.title}</html:link>
        </span>
        <br/>Property Type: ${listing.typeAsString}
        <br/>Offer Type: ${listing.offerTypeAsString}
        <br/>Region: ${listing.region}
        <hr>
    </c:forEach>
</div>
</body>
