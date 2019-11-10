<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${wrestler.name}</title>
	</head>
	<body>
		<jsp:include page="topLabel.jsp"/><br/>
		<table>
			<tr>
				<td>Name: </td><td>${wrestler.name}</td>
			</tr>
			<tr>
				<td>DOB: </td><td><fmt:formatDate value="${wrestler.dateOfBirth}" pattern="MM-dd-yyyy"/></td>
			</tr>
			<tr>
				<td>Division: </td><td>${wrestler.division}</td>
			</tr>
			<tr>
				<td>Description: </td><td>${wrestler.desc}</td>
			</tr>
			<%-- <tr>
				<td><a href="${pageContext.request.contextPath}/edit/${user.email}"><input type="button" value="Edit"/></a></td>
				<td><a href="${pageContext.request.contextPath}/delete/${user.email}"><input type="button" value="Delete"/></a></td>
			</tr> --%>
		</table>
	</body>
</html>