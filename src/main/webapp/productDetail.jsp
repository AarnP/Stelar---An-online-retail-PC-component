<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Detail</title>
<link rel="stylesheet" href="CSS/styles.css">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<script src="JS/javascript.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>


	<!------ Include the above in your HEAD tag ---------->

	<link
		href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap"
		rel="stylesheet">
	<link rel="stylesheet" type="text/css"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
	<div class="pd-wrap">
		<div class="container">
			<div class="heading-section">
				<h2>Product Details</h2>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div id="slider" class="owl-carousel product-slider">
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/${product.img}"
								alt="img">
						</div>
					</div>
					<div id="thumb" class="owl-carousel product-thumb">
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/${product.img}"
								alt="img">
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>

					</div>
				</div>
				<div class="col-md-6">
					<div class="product-dtl">
						<div class="product-info">
							<div class="product-name"><h2>${product.name}</h2></div>
							<div class="reviews-counter">
								<div class="rate">
									<input type="radio" id="star5" name="rate" value="5" checked />
									<label for="star5" title="text">5 stars</label> <input
										type="radio" id="star4" name="rate" value="4" checked /> <label
										for="star4" title="text">4 stars</label> <input type="radio"
										id="star3" name="rate" value="3" checked /> <label
										for="star3" title="text">3 stars</label> <input type="radio"
										id="star2" name="rate" value="2" /> <label for="star2"
										title="text">2 stars</label> <input type="radio" id="star1"
										name="rate" value="1" /> <label for="star1" title="text">1
										star</label>
								</div>
								<span>3 Reviews</span>
							</div>
							<div class="product-price-discount">
								<span>$${product.price}</span>
								<!-- <span class="line-through">$29.00 -->
								</span>
							</div>
						</div>
						<p>${product.description}</p>
						<div class="row">
							<div class="col-md-6">
								<label for="size">Quantity</label> <select id="size" name="size"
									class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
							<div class="col-md-6">
								<label for="color">LED Colour</label> <select id="color"
									name="color" class="form-control">
									<option>Original</option>
									<option>Theme</option>
									<option>Custom</option>
								</select>
							</div>
						</div>
						<div class="product-count">
							<label for="size">Quantity</label>
							<form action="#" class="display-flex">
								<div class="qtyminus">-</div>
								<input type="text" name="quantity" value="1" class="qty">
								<div class="qtyplus">+</div>
							</form>
							<form action="CartServlet" class="round-black-btn">
								<input hidden type="text" value="${product.id}" name="productId">
								<input hidden type="text" value="ADD_TO_CART" name="action">
								<input type="submit" value="Add To Cart">
							</form>

						</div>
					</div>
				</div>
			</div>
			<div class="product-info-tabs">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active"
						id="description-tab" data-toggle="tab" href="#description"
						role="tab" aria-controls="description" aria-selected="true">Description</a>
					</li>
					<li class="nav-item"><a class="nav-link" id="review-tab"
						data-toggle="tab" href="#review" role="tab" aria-controls="review"
						aria-selected="false">Reviews (0)</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="description"
						role="tabpanel" aria-labelledby="description-tab">${product.description}</div>
					<div class="tab-pane fade" id="review" role="tabpanel"
						aria-labelledby="review-tab">
						<div class="review-heading">REVIEWS</div>
						<p class="mb-20">There are no reviews yet.</p>
						<form class="review-form">
							<div class="form-group">
								<label>Your rating</label>
								<div class="reviews-counter">
									<div class="rate">
										<input type="radio" id="star5" name="rate" value="5" /> <label
											for="star5" title="text">5 stars</label> <input type="radio"
											id="star4" name="rate" value="4" /> <label for="star4"
											title="text">4 stars</label> <input type="radio" id="star3"
											name="rate" value="3" /> <label for="star3" title="text">3
											stars</label> <input type="radio" id="star2" name="rate" value="2" />
										<label for="star2" title="text">2 stars</label> <input
											type="radio" id="star1" name="rate" value="1" /> <label
											for="star1" title="text">1 star</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label>Your message</label>
								<textarea class="form-control" rows="10"></textarea>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" name="" class="form-control"
											placeholder="Name*">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" name="" class="form-control"
											placeholder="Email Id*">
									</div>
								</div>
							</div>
							<button class="round-black-btn">Submit Review</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="	sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>