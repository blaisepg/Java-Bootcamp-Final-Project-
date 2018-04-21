<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">

<link rel="stylesheet" href="resources/style.css">
<title>Item Added</title>
</head>
<body>


<h2>Item added to your closet!</h2>
<h4>What would you like to do next?</h4>



<form action="addAnother" class = "blockButton">
<input type = "submit" value = "Add another item" class = "btn btn-block btn-secondary">
</form>

<form action="viewCloset" class = "blockButton">
<input type = "submit" value = "View closet" class = "btn btn-block btn-secondary">
</form>



</body>
</html>