<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${event.name}</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		<table>
			<tr>
				<td>Name: </td><td>${event.name}</td>
			</tr>
			<tr>
				<td>Date: </td><td><fmt:formatDate value="${event.date}" pattern="MM-dd-yyyy"/></td>
			</tr>
			<tr>
				<td>Location: </td><td>${event.city}, ${event.state}</td>
			</tr>
			<%-- <tr>
				<td><a href="${pageContext.request.contextPath}/edit/${user.email}"><input type="button" value="Edit"/></a></td>
				<td><a href="${pageContext.request.contextPath}/delete/${user.email}"><input type="button" value="Delete"/></a></td>
			</tr> --%>
		</table>
		
		<%-- Event Comments --%>
		<br/><br/><br/>
		<table>
			<tr>
				<td>Date&nbsp;&nbsp;</td>
				<td>Username&nbsp;&nbsp;</td>
				<td>Post</td>
			</tr>
			<c:forEach var="comment" items="${event.comments}">
				<tr>
					<%-- <td>${comment.id}</td> --%>
					<td>${comment.date}&nbsp;&nbsp;</td>
					<td>${comment.user.username}&nbsp;&nbsp;</td>
					<td>${comment.post}</td>
				</tr>
			</c:forEach>
		</table>
		
		<%-- User adds a comment --%>
		
		<a href="${event.name}/addComment"><button type="button">Add New Comment</button></a>
	</body>
</html>