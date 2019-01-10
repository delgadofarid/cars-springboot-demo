<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="loggedUser" value="${pageContext.request.userPrincipal.name}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	
	<sec:authorize access="isAuthenticated()">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <sec:csrfInput />
            <button type="submit">Log Out</button>
        </form>

        <h2>Welcome <sec:authentication property="name"/> | <a href="#logout" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
        <sec:authorize access="hasAuthority('ADMIN')">
		    <br>
        	<a href="${contextPath}/admin">Admin</a>
		</sec:authorize>
	</sec:authorize>
    
</body>
</html>