<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new product</title>
</head>
<body>
	<h1>Product Creation Form</h1>
	<form action="ProductAdminServlet">
		Name: <br> Price: <br> Stock: <br> Description: <br>

		<label for="categoryName">Category:</label> <select
			name="categoryName" id="categoryName">
			<c:forEach items="${productList}" var="product">
			<option value="Children Book">${product.category}</option>
			</c:forEach>
		</select> <br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>