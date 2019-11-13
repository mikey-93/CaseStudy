<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${wrestler.name}</title>
		<jsp:include page="bootstrap.jsp"/>
		<jsp:include page="topLabel.jsp"/>
	</head>
	<body>
		<table>
			<tr>
				<td><b>Name</b>: </td><td>${wrestler.name}</td>
			</tr>
			<tr>
				<td><b>DOB</b>: </td><td><fmt:formatDate value="${wrestler.dateOfBirth}" pattern="MM-dd-yyyy"/></td>
			</tr>
			<tr>
				<td><b>Division</b>: </td><td>${wrestler.division}</td>
			</tr>
			<tr>
				<td><b>Description</b>: </td><td>${wrestler.desc}</td>
			</tr>
			<%-- <tr>
				<td><a href="${pageContext.request.contextPath}/edit/${user.email}"><input type="button" value="Edit"/></a></td>
				<td><a href="${pageContext.request.contextPath}/delete/${user.email}"><input type="button" value="Delete"/></a></td>
			</tr> --%>
		</table>
	</body>
</html>