<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<link href="<c:url value="/templates/css/common.css"/>" rel="stylesheet"
	type="text/css">
<div class="container">
	<div class="row">
		<div class="col">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100 h-100"
							src="https://th.bing.com/th/id/R.ae21de0a7ae53e59867d666f246c5650?rik=CVkw7rGYDsBz8g&riu=http%3a%2f%2fwallpapercave.com%2fwp%2f3AFfJYa.jpg&ehk=VJzHDaH8536udvYeLYiIcvE%2f%2bBWv2PftL4N07IB1RmE%3d&risl=&pid=ImgRaw&r=0"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://th.bing.com/th/id/R.1d3e458f0daadb2a35a7e99d534caf73?rik=uIyCMQn%2bLW4r%2fQ&pid=ImgRaw&r=0"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://wallpaperaccess.com/full/1079356.png"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="col-12 col-md-3">
			<div class="card">
				<div class="card-header bg-success text-white text-uppercase">
					<i class="fa fa-heart"></i> Sản phẩm Nổi Bật
				</div>
					<div class="col-sm">
						<div class="card nowrap">
							<div class="card-top">
								<a href="<c:url value="/gunpla/details?id=${top.gunplaId}"/>"> <img
									class="card-img-top" src="${top.image}" alt="Card image cap" />
								</a>
								<div class="card-body">
									<h4 class="card-title text-center">
										<a class="text-st" href="<c:url value="/gunpla/details?id=${top.gunplaId}"/>"
											title="View Product">${top.gunplaName}</a>
									</h4>
									<p class="nowrap card-text">${top.desc}</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${top.price}</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
		<div class="container mt-3">
			<div class="row">
				<div class="col-sm">
					<div class="card">
						<div class="card-header bg-primary text-white text-uppercase">
							<i class="fa fa-star"></i> sản phẩm mới nhất
						</div>
						<div class="card-body">
							<div class="row">

								<c:forEach items="${listNewest}" var="gunpla">
									<div class="col-sm pt-3">
										<div class="card "
											style="display: block; 
											       text-overflow: ellipsis; 
											       width: 250px; 
											       overflow: hidden; 
											       white-space: nowrap;">
											<div class="card-top">

												<a href="<c:url value="/gunpla/details?bookId=${gunpla.gunplaId}"/>">
													<img class="card-img-top" src="${gunpla.image}"
													alt="Card image cap" />
												</a>

											</div>
											<div class="card-body">
												<h4 class="card-title">
													<a class="nowrap"href="<c:url value="/gunpla/details?id=${gunpla.gunplaId}"/>"
														title="View Product">${gunpla.gunplaName}</a>
												</h4>
												<p class="nowrap card-text">${gunpla.desc}</p>
												<div class="row">
													<div class="col">
														<p class="btn btn-info btn-block">${gunpla.price} VND</p>
													</div>
												</div>
											</div>
										</div>
									</div>

								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="container mt-3 mb-4">
			<div class="row">
				<div class="col-sm">
					<div class="card">
						<div class="card-header bg-primary text-white text-uppercase">
							<i class="fa fa-trophy"></i> sản phẩm phổ thông
						</div>
						<div class="card-body">
							<div class="row">

								<c:forEach items="${cheapestList}" var="gunplac">
									<div class="col-sm">
										<div class="card"
											style="display: block; text-overflow: ellipsis; width: 250px; overflow: hidden; white-space: nowrap;">
											<div class="card-top">

												<a href="<c:url value="/gunpla/details?id=${gunplac.gunplaId}"/>">
													<img class="card-img-top" src="${gunplac.image}"
													alt="Card image cap" />
												</a>

											</div>
											<div class="card-body">
												<h4 class="card-title">
													<a class="nowrap" href="<c:url value="/gunpla/details?id=${gunplac.gunplaId}"/>"
														title="View Product">${gunplac.gunplaName}</a>
												</h4>
												<p class="nowrap card-text">${gunplac.desc}</p>
												<div class="row">
													<div class="col">
														<p class="btn btn-info btn-block">${gunplac.price} VND</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>