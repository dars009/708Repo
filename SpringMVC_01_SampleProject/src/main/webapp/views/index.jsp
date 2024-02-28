<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	Welcome To SpringMVC Application !
	<h4>${errorMessage}</h4>
	<form action="login" method="post">
		User Name:<input type="email" name="email" >
		<br>
		Password :<input type="password" name="password" >
		<br>
		<input type="submit" value="login">
	</form>
	
</body>
</html>