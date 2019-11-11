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
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		<%-- <form:form id="login" modelAttribute="userObj" 
			action="loginProcess" method="post">
			<p>${message}</p>
			<table>
				<tr>
					<td><form:label path="email"/>Email: </td>
					<td><form:input path="email" name="email" id="email"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="password"/>Password: </td>
					<td><form:password path="password" name="password" id="password"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button name="login" id="login">Login</form:button></td>
				</tr>
			</table>
		</form:form> --%>
		
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
					<td> <button type="submit">Login</button>   </td>
				</tr>
			</table>
	
		</form>
	</body>
</html>