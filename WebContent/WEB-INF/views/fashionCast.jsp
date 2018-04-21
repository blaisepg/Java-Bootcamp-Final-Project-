<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class = "weatherInfo">
<h4>Current weather conditions in</h4>
<h4 style ="text-decoration: underline">${cityState}</h4>
<h4>${temp} °F & ${weather}</h4>
<h4>Precipitation: ${precip} %</h4>
<h4>Humidity: ${humidity}</h2>

</div>

<div class = "weatherImg">
<img alt="pic of current weather" src="${icon_url}">
<img alt="pic of current weather" src="${icon_url}">
<img alt="pic of current weather" src="${icon_url}">
<img alt="pic of current weather" src="${icon_url}">
<img alt="pic of current weather" src="${icon_url}">

</div>
<br>
<h1>${name}, wear this:</h1>
	<table border="1">
		<!-- only options for border are 1 or 0 -->
		<c:forEach var="myVar" items="${outfitItems}">
			<!-- var is what gets reassigned every iteration -->


			<tr>
				<td><img alt="" src="${myVar.imageURL}" height="170px"
					width="150px"></td>
				<td>${ myVar.description}</td>
			</tr>


		</c:forEach>

	</table>
	
<br><br>

<div class = "buttonDiv">
	<form action="home" class="blockButton">
		<input type="submit" value="Get a different outfit" class = "btn btn-block btn-secondary">
	</form>

	<form action="viewCloset"class="blockButton">
		<input type="submit" value="View closet" class = "btn btn-block btn-secondary">
	</form>

	<form action="viewHamp" class="blockButton">
		<input type="submit" value="View hamper" class = "btn btn-block btn-secondary">
	</form>
</div>
<br><br>
<p>Please note: Weather Or Not's suggestion is restricted to only the clothes currently in your closet. For a truly weather-appropriate outfit, please fill your closet with a range of attire.</p>

</body>
</html>