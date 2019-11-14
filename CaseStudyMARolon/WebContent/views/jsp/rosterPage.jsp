<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>AEW Roster</title>
		<jsp:include page="bootstrap.jsp"/>
		<jsp:include page="topLabel.jsp"/>
	</head>
	<body>
		<table>
			<tr>
				<td><b>Name</b>&nbsp;&nbsp;</td>
				<td><b>Division</b></td>
			</tr>
			<c:forEach var="wrestler" items="${wrestlers}">
				<tr>
					<td><a href="roster/${wrestler.name}">${wrestler.name}</a>&nbsp;&nbsp;</td>
					<td>${wrestler.division}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>