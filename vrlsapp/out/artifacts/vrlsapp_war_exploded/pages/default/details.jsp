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
    <c:set var="listing" value="${requestScope.listing}" />
    <c:url var="imageUrl" value="${listing.mainImageUrl}" />
    <html:img border="0" src="${imageUrl}" />
    <br/>
    <span class="listingTitle">${listing.title}</span>
    <br/><b>Property Type:</b> ${listing.typeAsString}
    <br/><b>Offer Type:</b> ${listing.offerTypeAsString}
    <br/><b>Region:</b> ${listing.region}
    <br/><b># of Bedrooms:</b> <fmt:formatNumber value="${listing.numBedrooms}" pattern="##0" />
    <br/><b># of Bathrooms:</b> <fmt:formatNumber value="${listing.numBathrooms}" pattern="##0" />
    <br/><b>Monthly Payment:</b> <fmt:formatNumber value="${listing.monthlyPayment}" type="currency" />
    <br/><b>Purchase Price:</b> <fmt:formatNumber value="${listing.purchasePrice}" type="currency" />
    <br/><br/>${listing.description}
    <br/><br/>
    <c:if test="${! empty sessionScope.searchResults}">
        <html:link href="${sessionScope.url_results}">Back to results</html:link><br/>
    </c:if>
    <html:link href="${sessionScope.url_search}">Back to search</html:link><br/>
    <html:link href="${sessionScope.url_contact}">Contact us about this listing</html:link>
</div>
</body>
