<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>AEW Roster</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		<table>
			<tr>
				<td><b>Name</b></td>
				<td><b>DOB</b></td>
				<td><b>Division</b></td>
				<td><b>Description</b></td>
			</tr>
			<c:forEach var="wrestler" items="${wrestlers}">
				<tr>
					<td><a href="roster/${wrestler.name}">${wrestler.name}</a></td>
					<td><fmt:formatDate value="${wrestler.dateOfBirth}" pattern="MM-dd-yyyy"/></td>
					<td>${wrestler.division}</td>
					<td>${wrestler.desc}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>