<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div>
	<a href="${pageContext.request.contextPath}/">Home</a>
	| 
	<a href="${pageContext.request.contextPath}/roster">Roster</a>
	| 
	<a href="${pageContext.request.contextPath}/events">Events</a>
	|| 
	<%-- Adding cases for login and logout --%>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<a href="${pageContext.request.contextPath}/login"><b>Log In</b></a>
		| 
		<a href="${pageContext.request.contextPath}/register"><b>Register</b></a>
	</c:if>
	<%-- Logout --%>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="${pageContext.request.contextPath}/${pageContext.request.userPrincipal.name}"><b>${pageContext.request.userPrincipal.name}</b></a>
		| 
		<a href="${pageContext.request.contextPath}/logout"><b>Log Out</b></a>
	</c:if>
	 
	<br/>
	<a href="https://en.wikipedia.org/w/index.php?curid=59548214" target="_blank">
		<img src="<c:url value='/images/All_Elite_Wrestling_Logo.jpg'/>" 
			alt="https://en.wikipedia.org/w/index.php?curid=59548214"/>
	</a>
	
</div>