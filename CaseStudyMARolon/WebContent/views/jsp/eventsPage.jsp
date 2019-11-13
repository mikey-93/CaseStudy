<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Events</title>
		<jsp:include page="bootstrap.jsp"/>
		<jsp:include page="topLabel.jsp"/>
	</head>
	<body>
		<br/><br/>
		<table>
			<tr>
				<td>Name&nbsp;&nbsp;</td>
				<td>Date&nbsp;&nbsp;</td>
				<td>Location&nbsp;&nbsp;</td>
			</tr>
			<c:forEach var="event" items="${events}">
				<tr>
					<td><a href="events/${event.name}">${event.name}</a>&nbsp;&nbsp;</td>
					<td><fmt:formatDate value="${event.date}" pattern="MM-dd-yyyy"/>&nbsp;&nbsp;</td>
					<td>${event.city}, ${event.state}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>