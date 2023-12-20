<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<link rel="stylesheet" type="text/css" href="template/web/css/style.css">

<style>
    .list-inline {
        text-align: center;
        border: 1px solid #ccc; /* Màu và độ rộng của viền */
        padding: 10px; /* Khoảng cách bên trong của danh sách */
    }

    .list-inline-item {
        display: inline-block;
        text-align: center;
        margin: 5px; /* Khoảng cách xung quanh mỗi mục */
    }
</style>

<style>
    .reviews_product {
        border: 1px solid #ccc; /* Màu và độ rộng của viền */
        padding: 10px; /* Khoảng cách bên trong của đánh giá */
        margin-bottom: 10px; /* Khoảng cách dưới cùng */
    }

    .reviews_product i.fa-star {
        color: #ffd700; /* Màu vàng cho các icon sao */
    }
</style>



<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/gunpla">Gunpla</a></li>
					<li class="breadcrumb-item active" aria-current="page">Details</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">

	<form action="#" method="post">
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">				
					<img class="card-img-top img-fluid" src="${gunpla.image}"
						alt="Card image cap"></img>
				</div>
			</div>
			<div class="col-12 col-lg-6 add_to_cart_block">
			<div class="card bg-light mb-3">
            <div class="card-body">
			
				<div class="form-group" hidden="hidden">
					<input type="text" name="bookId"
						value="${gunpla.gunplaId}" class="form-control" readonly />
				</div>
				<h1>${gunpla.gunplaName}</h1>
				<h3 class="text" style="color: #0033FF">Price: ${gunpla.price}
					VND</h3>
				<h5 class="text" style="color: #0033FF">Grade: ${gunpla.gradeId}</h5>
				<%--Rate: ${gunpla.rating}/10</h5>--%>
				
				<!-- 
				<button class="btn btn-primary"
					formaction="<c:url value="/gunpla/add-cart"/>">
					Add <i class="fa fa-plus"></i>
				</button>
				-->
		
				<input type="submit" class="btn btn-success" name="addtocart"
					style="width: 490px" value="+ ADD TO CART">
				<p class="text-danger pd-l">${mess}</p>
				
				<div class="product_rassurance">
				    <ul class="list-inline">
				        <li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br>Fast delivery</li>
				        <li class="list-inline-item"><i class="fa fa-credit-card fa-2x"></i><br>Secure payment</li>
				        <li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br>+000 000 000</li>
				    </ul>
				</div>				
				
					<div class="reviews_product p-3 mb-2">
					    2 reviews
					    <i class="fa fa-star"></i>
					    <i class="fa fa-star"></i>
					    <i class="fa fa-star"></i>
					    <i class="fa fa-star"></i>
					    <i class="fa fa-star"></i>
					    (5/5)
					    <a class="pull-right" href="#reviews">View all reviews</a>
					</div>				
				</div>
				</div>
				
			</div>
		</div>
	</form>
</div>

<div class="col-12">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-align-justify"></i> Description</div>
                <div class="card-body">
                    <p class="card-text">
                    <p>${gunpla.desc}</p>
					 </p>
                </div>
            </div>
        </div>



<div class="col-12" id="reviews">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-comment"></i> Reviews</div>
                <div class="card-body">
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2023

                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        by Paul Smith
                        <p class="blockquote">
                            </p><p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        <p></p>
                        <hr>
                    </div>
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2023

                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        by Paul Smith
                        <p class="blockquote">
                            </p><p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        <p></p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>