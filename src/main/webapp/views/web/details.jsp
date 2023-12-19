<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

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
			<div class="col">
				<div class="form-group" hidden="hidden">

					<input type="text" name="bookId"
						value="${gunpla.gunplaId}" class="form-control" readonly />

				</div>
				<h1>${gunpla.gunplaName}</h1>
				<h3 class="text" style="color: #0033FF">Price: ${gunpla.price}
					VND</h3>
				<h5 class="text" style="color: #0033FF">Grade: ${gunpla.gradeId}</h5>
				<%--Rate: ${gunpla.rating}/10</h5>--%>
				<p>Description: ${gunpla.desc}</p>
				<!-- 
				<button class="btn btn-primary"
					formaction="<c:url value="/gunpla/add-cart"/>">
					Add <i class="fa fa-plus"></i>
				</button>
				-->
				<input type="submit" class="btn btn-primary" name="addtocart"
					style="width: 150px" value="+ Add to cart">
				<p class="text-danger pd-l">${mess}</p>
			</div>
		</div>
	</form>
</div>