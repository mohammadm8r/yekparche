<%@ include file="include.jsp" %>
<c:url var="jsCommon" scope="request" value="/js/common.js" />
<c:url var="cssCommon" scope="request" value="/css/common.css" />
<c:url var="cssCommon" scope="request" value="/css/common.css" />
<c:url var="cssPartner" scope="request" value="/css/${sessionScope.partner.code}.css" />
<c:set var="imgPartner" scope="request" value="${pageContext.request.contextPath}/pages/${sessionScope.partner.code}/images" /> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>${sessionScope.partner.name} - ${param.name}</title>
<link rel="stylesheet" type="text/css" href="${requestScope.cssCommon}">
<link rel="stylesheet" type="text/css" href="${requestScope.cssPartner}">
<script type="text/javascript" src="${requestScope.jsCommon}"></script>
</head>
<c:import url="${sessionScope.partner.code}/${param.name}.jsp" />
</html>