<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register Confirmation</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		<p>Welcome, ${user.username}! ${message}</p>
		<a href="${pageContext.request.contextPath}/login">Login</a>
	</body>
</html>