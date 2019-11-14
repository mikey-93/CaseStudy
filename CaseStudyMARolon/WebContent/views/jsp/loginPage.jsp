<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<style type="text/css">
			.error{color: red; font-size: small;}
		</style>
		<jsp:include page="bootstrap.jsp"/>
		<jsp:include page="topLabel.jsp"/>
	</head>
	<body>
		<form action='<spring:url value="/loginAction"/>' method="post">
	
			<table>
				<tr>
					<td>Username</td>
					<td> <input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td> <input type="password" name="password"/></td>
				</tr>
				<tr>
					<td> <button type="submit">Log In</button>   </td>
				</tr>
			</table>
	
		</form>
	</body>
</html>