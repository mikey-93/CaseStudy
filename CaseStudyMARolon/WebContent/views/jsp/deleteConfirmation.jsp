<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Delete Confirmation</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		
		<p>${comment.event.name}</p><br/>
		<table>
			<tr>
				<td><b>Date</b></td>
				<td><b>Post</b></td>
			</tr>
			<tr>
				<td>${comment.date}&nbsp;&nbsp;</td>
				<td>${comment.post}&nbsp;&nbsp;</td>
			</tr>
		</table>
		
		<p>Are you sure you want to delete this comment?</p>
		<form action="${pageContext.request.contextPath}/deleteProcess" method="post">
			<input type="hidden" name="commentId" id="commentId" 
				value="${comment.id}" readonly/>
			<button type="submit">Yes</button>
		</form>
		
		<a href="${pageContext.request.contextPath}/events/${comment.event.name}">
			<button type="button">Cancel</button>
		</a>
	</body>
</html>