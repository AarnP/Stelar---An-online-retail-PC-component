<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management Page</title>
</head>
<body>
	<h1>Product Management Page</h1>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>category</th>
			<th>stock</th>
			<th>description</th>
			<th>price</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.categoryId}</td>
				<td>${product.stock}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>



	</table>
	
<form action="ProductAdminServlet">
        <input hidden type="text" value="INIT_CREATE_FORM" name="action">
        <input type="submit" value="Add New Product">
    </form>
</body>
</html>