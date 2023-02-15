<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/styles.css">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<script src="JS/javascript.js"></script>
</head>

<body>
	<header class="header1">
		<a href="HomeServlet?action=goHome"> <img src="lighning-name.png"
			alt="logo" class="logo">
		</a>
		<!--<div class="company-name">COMPUTER<span style="color:#FFC93C">VERSE</span></div>-->
		<div class="login-cart">

			<c:if test="${empty sessionScope.user}">
				<a href="logIn.jsp">Log In</a>
				<a href="#">Register</a>
			</c:if>
			<c:if test="${not empty sessionScope.user}">
						Hello, ${sessionScope.user.username}
						<a href="LogInServlet?action=logout">Logout</a>
				<a href="CartServlet?action=VIEW_CART">Cart(${sessionScope.cart.totalItem})</a>
			</c:if>
		</div>
	</header>
	<header class="header2">

		<div class="menu-container">

			<a href="#">PC Builder</a> <a href="#">Build Guides</a> <a href="#">Completed
				Builds</a>
			<div class="dropdown">
				<button class="dropbtn">
					Browse Product <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="#">CPU</a> <a href="#">Motherboard</a> <a href="#">Video
						Card </a>
				</div>
			</div>

		</div>

	</header>
	<!--<img src="wallpaper_3.webp" alt="wallpaper" class="wallpaper">-->

	<h2 class="categoryTitle">CATEGORIES</h2>
	<c:forEach var="category" items="${sessionScope.categoryList}">
		<a href="HomeServlet?categoryId=${category.id}">${category.name}</a>
		<br>
	</c:forEach>
	
	<h2 class="productTitle">PRODUCT</h2>

	<c:forEach var="product" items="${sessionScope.productList}">
	<div class="product-list">
		<div class="listing-section">
			<div class="product">
				<div class="image-box">
					<div class="images" id="image-1"><img src="${pageContext.request.contextPath}/img/${product.img}"
			alt="img"></div>
				</div>
				<div class="text-box">
					<h2 class="item"><a href="ProductServlet?id=${product.id}">${product.name}</a></h2>
					<h3 class="price">$${product.price}</h3>
					<p class="description">${product.description}</p>
					<label for="item-1-quantity">Quantity:</label> <input type="text"
						name="item-1-quantity" id="item-1-quantity" value="1">
					<button type="button" name="item-1-button" id="item-1-button">Add
						to Cart</button>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
	
		<%-- <img src="${pageContext.request.contextPath}/img/${product.img}"
			alt="img">
		<a href="ProductServlet?id=${product.id}">${product.name}</a>
		<br> --%>
	

	<script src="JS/javascript.js"></script>
</body>
</html>