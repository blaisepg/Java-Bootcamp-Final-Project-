<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">

<link rel="stylesheet" href="resources/style.css">
<title>Login</title>
</head>
<body>

<h3>Weather Or Not</h3> 
<h6>When you are getting ready always listen to your Mother...</h6>
<h6>...Mother Nature</h6>

${msg}
<div class="container">
<form action="existingUserLogin" class="existingUserLoginForm" method="post"> 
        <input type="email" placeholder="E-mail" name = "email" required class = "input-group input-group-lg"><br>
        <input type="password" placeholder="Password" name="password" required class = "input-group input-group-lg"><br>
        <input type="submit" class = "btn btn-block btn-secondary" value = "Continue" style ="text-align: center; margin: 0 auto;">
</form>
</div>
<br><br>

<h3>New To Weather Or Not?</h3><br>
<div class="container">
<form action="getsignup" method="post">
	<input type="submit" value = "Sign Up" class = "btn btn-block btn-secondary">
</form>
</div>
</body>
</html>