<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registration</title>
		<style type="text/css">
			.error{color: red; font-size: small;}
		</style>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		
		<form:form id="registerForm" modelAttribute="registerFormObj" 
			action="registerProcess" method="post">
			<p>${message}</p>
			<table>
				<tr>
					<td><form:label path="username"/>Username: </td>
					<td><form:input path="username" name="username" id="username"/></td>
					<td><form:errors path="username" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="email"/>Email: </td>
					<td><form:input path="email" name="email" id="email"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="dateOfBirth"/>Date of Birth: </td>
					<td><form:input type="date" path="dateOfBirth" name="dateOfBirth" id="dateOfBirth" 
							placeholder="Date of Birth"/></td>
					<td><form:errors path="dateOfBirth" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="desc"/>Description: </td>
					<td><form:input path="desc" name="desc" id="desc"/></td>
					<td><form:errors path="desc" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="password"/>Password: </td>
					<td><form:password path="password" name="password" id="password" 
							placeholder="Your Password"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td><label>Repeat Password: </label></td>
					<td><input type="password" name="confPassword" id="confPassword" 
							placeholder="Confirm Password"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button name="register" id="register">Register</form:button></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>