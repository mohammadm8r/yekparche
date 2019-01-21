<%@ include file="../include.jsp" %>
<body>
<div style="padding-bottom: 8px"><html:img src="${requestScope.imgPartner}/logo.gif" /></div>

<div class="navbar"><html:link href="${sessionScope.url_home}"><span class="nobr">${sessionScope.navbar.home}</span></html:link>
<html:link href="${sessionScope.url_authcheck}"><span class="nobr">${sessionScope.navbar.authcheck}</span></html:link>
<html:link href="${sessionScope.url_search}"><span class="nobr">${sessionScope.navbar.search}</span></html:link>
<html:link href="${sessionScope.url_contact}"><span class="nobr">${sessionScope.navbar.contact}</span></html:link>
</div>
<div class="text">
    <c:choose>
      <c:when test="${sessionScope.customer == null}">
	    <c:set var="focusFieldName" value="login" scope="page" />
        <h3>SIGNUP</h3>
        If you are not a registered user here at Virtual Realty Listing Services, please fill out the form below to sign up. If you're already a registered user, click <A HREF="/vrls/action/login">here</A> to login.
      </c:when>
      <c:otherwise>
	    <c:set var="focusFieldName" value="password" scope="page" />
        <h3>PROFILE</h3>
        Fill out the form below to modify your user profile.
      </c:otherwise>
    </c:choose>
    <html:form action="/profile" focus="${pageScope.focusFieldName}" onsubmit="javascript:return setHidden(this)">
      <html:errors />
    <table>
    <tr>
    <div class="user-validation success" style="display:none;color:green;">
        username is valid
    </div>
    <div class="user-validation error" style="display:none;color:red;">
        username is duplicate
    </div>
    </tr>
    <tr>
    <c:choose>
    <c:when test="${sessionScope.customer == null}">
        <td class="text" style="text-align: right; vertical-align: top">Desired User ID:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="login" /></td>
    </c:when>
    <c:otherwise>
        <td class="text" colspan="2" style="text-align: center;"><b>Profile for <u>${sessionScope.customer.login}</u></b><br/><br/></td>
    </c:otherwise>
    </c:choose>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Desired Password:</td>
        <td style="text-align: left; vertical-align: top"><input type="password" id="password" name="password" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Confirm Desired Password:</td>
        <td style="text-align: left; vertical-align: top"><input type="password" id="passwordConfirm" name="passwordConfirm" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">First Name:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="firstName" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Middle Name:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="middleName" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Last Name:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="lastName" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Address:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="address1" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Secondary Address:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="address2" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">City:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="city" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">State or Province:</td>
        <td style="text-align: left; vertical-align: top">
            <html:select property="stateProvinceCode">
                <option value=""></option>
                <html:optionsCollection property="stateProvinceOptions"/>
            </html:select>
        </td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Postal Code:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="postalCode" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Country:</td>
        <td style="text-align: left; vertical-align: top">
            <html:select property="countryCode">
                <option value=""></option>
                <html:optionsCollection property="countryOptions"/>
            </html:select>
        </td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Email Address:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="emailAddress" /></td>
    </tr>
    <tr>
        <td class="text" style="text-align: right; vertical-align: top">Phone Number:</td>
        <td style="text-align: left; vertical-align: top"><html:text property="phoneNumber" /></td>
    </tr>
    <c:choose>
    <c:when test="${sessionScope.customer == null}">
        <c:set scope="page" var="submitLabel" value=" Sign up! "/>
    </c:when>
    <c:otherwise>
        <c:set scope="page" var="submitLabel" value=" Update profile "/>
    </c:otherwise>
    </c:choose>
    <tr>var user_input = document.querySelector("[name^=login]");
        user_input.onblur  = function(){
        alert('asdf')
        }
        <td colspan="2" style="text-align: center">
            <br/><html:submit value="${pageScope.submitLabel}"/> &nbsp;
            <html:reset value=" Reset values "/>
        </td>
    </tr>
    <html:hidden property="countryPostal" />
    </table>
    </html:form>
    <script>
        var user_input = document.querySelector("[name^=login]");
        user_input.onblur  = function(){
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'https://reqres.in/api/users?page=2');
            xhr.onload = function() {
                if (xhr.status === 200) {
                    document.querySelector(".user-validation.success").style.display = 'inline-block';
                    document.querySelector(".user-validation.error").style.display = 'none';
                }
                else {
                    document.querySelector(".user-validation.error").style.display = 'inline-block';
                    document.querySelector(".user-validation.success").style.display = 'none';
                }
            };
            xhr.send();
        }
    </script>
</body>