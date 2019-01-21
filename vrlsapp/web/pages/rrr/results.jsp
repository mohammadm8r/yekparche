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
    <h3>SEARCH RESULTS</h3>
    <c:forEach var="listing" items="${sessionScope.searchResults}">
        <c:url value="/action/details" var="detailURL" scope="page">
            <c:param name="listingId" value="${listing.id}" />
        </c:url>
        <span class="listingTitle">
            <html:link href="${pageScope.detailURL}">${listing.title}</html:link>
        </span>
        <br>Property Type: ${listing.typeAsString}
        <br>Offer Type: ${listing.offerTypeAsString}
        <br>Region: ${listing.region}
        <hr>
    </c:forEach>
</div>
</body>
