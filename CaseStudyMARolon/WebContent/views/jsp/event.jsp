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
		<style type="text/css">
			.error{color: red; font-size: small;}
		</style>
		<jsp:include page="bootstrap.jsp"/>
		<jsp:include page="topLabel.jsp"/>
	</head>
	<body>
		<br/>
		<a href="https://en.wikipedia.org/wiki/AEW_${event.name}" target="_blank">
			<img src="<c:url value='/images/${event.name}.jpg'/>" 
				alt="https://en.wikipedia.org/AEW_${event.name}"/>
		</a>
		
		<table>
			<tr>
				<td><b>Name</b>: </td><td>${event.name}&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td><b>Date</b>: </td><td>${event.date}&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td><b>Location</b>: </td><td>${event.city}, ${event.state}</td>
			</tr>
		</table>
		
		<%-- Event Comments --%>
		<br/><br/><br/>
		${deleteCon}
		<table>
			<tr>
				<td><b>Date</b>&nbsp;&nbsp;</td>
				<td><b>Username</b>&nbsp;&nbsp;</td>
				<td><b>Post</b></td>
			</tr>
			<c:forEach var="comment" items="${event.comments}">
				<tr>
					<%-- <td>${comment.id}</td> --%>
					<td>${comment.date}&nbsp;&nbsp;</td>
					<td>
						<a href="${pageContext.request.contextPath}/${comment.user.username}">${comment.user.username}</a>
						&nbsp;&nbsp;
					</td>
					<td>${comment.post}&nbsp;&nbsp;</td>
					<td> <%-- Delete comment --%>
						<c:if test="${pageContext.request.userPrincipal.name == comment.user.username}">
							<form action="${pageContext.request.contextPath}/deleteCon" method="post">
						
								<input type="hidden" name="commentId" id="commentId" 
									value="${comment.id}" readonly/>
									
								<button type="submit">Delete</button>
							</form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<%-- User adds a comment --%>
		
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form:form id="addComment" modelAttribute="commentObj" 
				action="${pageContext.request.contextPath}/commentProcess" method="post">
				
				<form:label path="post"/>
				<form:input path="post" name="post" id="post"/>
				<form:errors path="post" cssClass="error"/>
				
				<input type="hidden" name="eventName" id="eventName" 
					value="${event.name}" readonly/>
				<br/>
				<form:button name="postComment" id="postComment">Post Comment</form:button>
			</form:form>
		</c:if>
		
		<br/>
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<p>Log in to add comment</p>
		</c:if>
	</body>
</html>