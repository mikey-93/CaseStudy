<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Comment</title>
		<style type="text/css">
			.error{color: red; font-size: small;}
		</style>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		
		<form:form id="addComment" modelAttribute="commentObj" 
			action="${pageContext.request.contextPath}/commentProcess" method="post">
			<form:label path="post"/>
			<form:input path="post" name="post" id="post"/>
			<form:errors path="post" cssClass="error"/>
			
			<input type="hidden" name="eventName" id="eventName" 
				value="${eventName}" readonly/>
			<br/>
			<form:button name="postComment" id="postComment">Post Comment</form:button>
		</form:form>
		<a href="${pageContext.request.contextPath}/events/${eventName}"><button type="button">Cancel</button></a>
	</body>
</html>