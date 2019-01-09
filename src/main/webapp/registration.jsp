<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create an account</title>
</head>
<body>
	<form:form method="POST" modelAttribute="userForm">
		<h2>Create your account</h2>
		<spring:bind path="username">
			<form:input type="text" path="username"
				placeholder="Username" autofocus="true"></form:input>
			<form:errors path="username"></form:errors>
		</spring:bind>
		<br>
		<spring:bind path="password">
			<form:input type="password" path="password"
				placeholder="Password"></form:input>
			<form:errors path="password"></form:errors>
		</spring:bind>
		<br>
		<spring:bind path="passwordConfirm">
			<form:input type="password" path="passwordConfirm"
				placeholder="Confirm your password"></form:input>
			<form:errors path="passwordConfirm"></form:errors>
		</spring:bind>
		<br>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>