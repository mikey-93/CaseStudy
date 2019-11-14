<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Delete Account Confirmation</title>
		<jsp:include page="bootstrap.jsp"/>
		<jsp:include page="topLabel.jsp"/>
	</head>
	<body>
		<p>Are you sure you want to DELETE your account?</p>
		<form action="${pageContext.request.contextPath}/deleteUserProcess" method="post">
			<button type="submit">Yes</button>
		</form>
		
		<a href="${pageContext.request.contextPath}/${pageContext.request.userPrincipal.name}">
			<button type="button">Cancel</button>
		</a>
	</body>
</html>