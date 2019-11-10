<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Events</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		<table>
			<tr>
				<td>Name</td>
				<td>Date</td>
				<td>Location</td>
			</tr>
			<c:forEach var="event" items="${events}">
				<tr>
					<td><a href="events/${event.name}">${event.name}</a></td>
					<td><fmt:formatDate value="${event.date}" pattern="MM-dd-yyyy"/></td>
					<td>${event.city}, ${event.state}</td>
				</tr>
			</c:forEach>
		</table>
		${test}
	</body>
</html>