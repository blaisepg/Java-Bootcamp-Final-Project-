<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">
	
<link rel="stylesheet" href="resources/style.css">
<title>Sweater</title>
</head>

<body>
<h1>Sweater</h1>

<div class = itemInputDiv>
<p>Upload a photo of the item:</p>
<form action="addItem" method="post" enctype="multipart/form-data">

  <input type="file" name="imageURL" accept="image" class = "btn btn-block btn-secondary">
  <br><br>
  <p>Choose the type of sweater being added to the closet:</p>
  <input type="radio" name="type" value="hoody"> Hoody<br>
  <input type="radio" name="type" value="crewneck"> Crewneck<br>
  <input type="radio" name="type" value="zipUp"> Zip-Up<br>
  <input type="radio" name="type" value="cardigan"> Cardigan<br>
  <input type = "hidden" name ="category" value = "SWEATER">
  <br>
 
  <textarea name="description" placeholder="Add a brief item description..."></textarea>
  <br><br>
  
 <input type = "submit" value = "Add item" class = "btn btn-block btn-secondary">
</form>

</div>
</body>
</html>