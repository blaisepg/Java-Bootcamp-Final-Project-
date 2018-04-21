<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">
<link rel="stylesheet" href="resources/style.css">
<title>Weather Or Not</title>
</head>
<body>
<h2>Welcome back ${msg}!</h2>
<br>


<h3>${cityState} : ${temp}°F</h3> 
<img alt="pic of current weather" src="${icon_url}" class = "weatherImg">

<div class = "blockButtonDiv">

<form action = "home" class = "blockButton">
<input type="submit" value="Get my outfit" class = "btn btn-block btn-secondary">
</form>

<form action = "addToCloset" class = "blockButton">
<input type="submit" value="Add item to closet" class = "btn btn-block btn-secondary">
</form>

<form action = "viewCloset" class = "blockButton">
<input type="submit" value="View closet" class = "btn btn-block btn-secondary">
</form>

<form action = "viewHamp" class = "blockButton">
<input type="submit" value="View hamper" class = "btn btn-block btn-secondary">
</form>

</div>


</body>
</html>