<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
	.error{
		color : red;
		font-style : italic;
	}
</style>
</head>
<body>
	<h1> login page </h1>
	<form:form action="submituser" method="post" modelAttribute="info">
		<div>
			<form:label path="username">Enter UserName: </form:label>
			<form:input path="username"/>
			<form:errors path="username" cssClass="error"></form:errors>
		</div><br>
		<div>
			<form:label path="password">Enter password: </form:label>
			<form:input path="password"/>
			<form:errors path="password" cssClass="error"></form:errors>
		</div><br><br>
        <center><input type = "submit" value="login"></center>
	</form:form>
</body>
</html>