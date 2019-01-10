<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<form method="POST" action="${contextPath}/login">
        <h2>Log in</h2>
        <div>
            <span>${message}</span>
            <br>
            <input name="username" type="text" placeholder="Username" autofocus="true"/>
            <br>
            <input name="password" type="password" placeholder="Password"/>
            <br>
            <span style="color: red;">${error}</span>
            <sec:csrfInput />
			<br>
            <button type="submit">Log In</button>
            <br>
            <h4><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>
</body>
</html>
