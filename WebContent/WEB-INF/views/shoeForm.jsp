<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">
	<link rel="stylesheet" href="resources/style.css">
<title>Shoes</title>
</head>

<body>
<h1>Shoes</h1>

<div class = itemInputDiv>
<p>Upload a photo of the item.</p>
<form action="addItem" method="post" enctype="multipart/form-data">
  <input type="file" accept="image" name = "imageURL" class = "btn btn-block btn-secondary">
  <br><br>
  <p>Choose the type of shoes being added to the closet:</p>
  <input type="radio" name="type" value="sneakers">Sneaker<br>
  <input type="radio" name="type" value="boots">Boot<br>
  <input type="radio" name="type" value="waterproofBoots">Waterproof Boot<br>
  <input type="radio" name="type" value="flats">Flat<br>
  <input type="radio" name="type" value="heels">Heel<br>
  <input type="radio" name="type" value="sandals">Sandal<br>
  <input type="radio" name="type" value="dressShoes">Dress Shoe
  <input type = "hidden" name ="category" value = "SHOE">
  <br><br>


  <textarea name="description" placeholder="Add a brief item description..."></textarea>
  <br><br>
<input type = "submit" value = "Add item" class = "btn btn-block btn-secondary">

</form>

</div>
</body>
</html>