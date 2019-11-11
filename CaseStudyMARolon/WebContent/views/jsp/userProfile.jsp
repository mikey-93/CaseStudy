<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${user.username}</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		
		<table>
			<tr>
				<td><b>Username</b>: </td>
				<td>${user.username}</td>
			</tr>
			<tr>
				<td><b>Email</b>: </td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td><b>Date of Birth</b>: </td>
				<td><fmt:formatDate value="${user.dateOfBirth}" pattern="MM-dd-yyyy"/></td>
			</tr>
			<tr>
				<td><b>Description</b>: </td>
				<td>${user.desc}</td>
			</tr>
		</table>
		
		<br/>
		<p><b>Favorite Wrestlers</b></p>
		<table>
			<tr>
				<td><b>Name</b></td>
			</tr>
			<c:forEach var="wrestler" items="${user.wrestlers}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/roster/${wrestler.name}">${wrestler.name}</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>