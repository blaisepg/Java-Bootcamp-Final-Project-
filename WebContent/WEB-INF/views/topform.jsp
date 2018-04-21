<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">
	<link rel="stylesheet" href="resources/style.css">
<title>Top</title>
</head>

<body>
<h1>Top</h1>

<div class = itemInputDiv>
<p>Upload a photo of the item:</p>
<form action="addItem" method="post" enctype="multipart/form-data">
  
  <input type="file" accept="image" name ="imageURL" class = "btn btn-block btn-secondary"><br><br>
  
  <p>Choose the type of top being added to the closet:</p>
  <input type="radio" name="type" value="tankTop">Tank-top<br>
  <input type="radio" name="type" value="tshirt">T-shirt<br>
  <input type="radio" name="type" value="longSleeve">Long sleeve<br>
  <input type="radio" name="type" value="blouse">Blouse<br>
  <input type="radio" name="type" value="buttonDown">Button-down<br>
  <input type="radio" name="type" value="polo">Polo<br>
  <input type = "hidden" name ="category" value ="TOP">
<br>
  <textarea placeholder="Add a brief items description..." name="description"></textarea>
  <br><br>
<input type = "submit" value = "Add item" class = "btn btn-block btn-secondary">
</form>

</div>
</body>
</html>