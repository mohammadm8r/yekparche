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
<H3>SEARCH</H3>
    <html:form action="/search">
       <html:errors />
    <table>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Property Type:</td>
        <td style="text-align: left; vertical-align: top">
            <html:select property="types" multiple="true">
                <html:optionsCollection property="typeOptions"/>
            </html:select>
        </td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Rent/Buy?</td>
        <td style="text-align: left; vertical-align: top">
            <html:select property="offerTypes" multiple="true">
                <html:optionsCollection property="offerTypeOptions"/>
            </html:select>
        </td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Minimum Number of Bedrooms:</td>
        <td style="text-align: left; vertical-align: top">
            <html:select property="minBedrooms">
                <html:option value="1">1</html:option>
                <html:option value="2">2</html:option>
                <html:option value="3">3</html:option>
                <html:option value="4">4</html:option>
                <html:option value="5">5</html:option>
            </html:select>
        </td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Minimum Number of Bathrooms:</td>
        <td style="text-align: left; vertical-align: top">
            <html:select property="minBathrooms">
                <html:option value="1">1</html:option>
                <html:option value="2">2</html:option>
                <html:option value="3">3</html:option>
                <html:option value="4">4</html:option>
                <html:option value="5">5</html:option>
            </html:select>
        </td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center">
            <br/><html:submit value=" Begin search "/> &nbsp;
            <html:reset value=" Reset values "/>
        </td>
    </tr>
    </table>
    </html:form>
</div>
</body>
