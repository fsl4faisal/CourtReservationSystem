<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="welcome.title" text="Welcome"></spring:message> </title>

</head>
<body>
	<h2><spring:message code="welcome.message" text="Welcome to Court Reservation System"></spring:message> </h2>
	Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />
	
	Locale : ${pageContext.response.locale}
</body>
</html>