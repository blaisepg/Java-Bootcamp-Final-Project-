<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">
	<link rel="stylesheet" href="resources/style.css">
<title>Insert title here</title>
</head>
<body>

	<h1>${name}'s Closet</h1>

<div class = "inlineButtonDiv" >
	<form action="home" class = "inlineButton">
		<input type="submit" value="Get my outfit" class = "btn btn-block btn-secondary">
	</form>

	<form action="addToCloset" class = "inlineButton">
		<input type="submit" value="Add item to closet" class = "btn btn-block btn-secondary">
	</form>

	<form action="viewHamp" class = "inlineButton">
		<input type="submit" value="View hamper" class = "btn btn-block btn-secondary">
	</form>

</div>

<div class = "closetAndHamp">
	<c:forEach var="category" items="${clothesMap}">

			<h2>${category.key}</h2>

			<c:choose>
				<c:when test="${category.value.size() > 0}">
					<table border="1">
									<!-- only  options for border are 1 or 0 -->
					<c:forEach var="item" items="${category.value}">
						<!-- var is what gets reassigned every iteration -->
						<tr>
							<td><img alt="" src="${item.imageURL}" height="100px"
								width="100px"></td>
							<%-- <td>${ item.cat}</td>
							<td>${ item.type}</td> --%>
							<td>${ item.description}</td>
							<td><a href="deleteItem?id=${item.itemId}">Delete</a></td>
							<!-- THIS IS URL ENCODING -->
							<td><a href="putInHamp?id=${item.itemId}">Put In Hamper</a></td>
							<!-- can use ampersand (maybe two?) to add more params to pass in -->
						</tr>
					</c:forEach> 

					</table>

				</c:when>

				<c:when test="${category.value.size() == 0 }">

					<p>None in the closet</p>

				</c:when>

			</c:choose>

		</c:forEach>
</div>
	
</body>
</html>