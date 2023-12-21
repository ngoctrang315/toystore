<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-sm" style="background-color: #000080;">
	<a class="navbar-brand text-white" href="#">TOY SHOP</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="row" style="width: 100%">
		<div class="column" style="width: 30%">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<c:choose>
						<c:when test="${sessionScope.checkuser == null}">
							<li class="nav-item  "><a class="nav-link "
								href="${pageContext.request.contextPath}/home">Trang chủ <span
									class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item  "><a class="nav-link "
								href="${pageContext.request.contextPath}/gunpla">Sản Phẩm <span
									class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/login">Đăng nhập </a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/register">Đăng ký</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${sessionScope.checkuser == 1}">
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/admin-statistics">Statistics
								</a></li>
								<li><a class="nav-link"
									href="${pageContext.request.contextPath}/admin-user-management">User</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/admin-store-management">Store</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/admin-grade-management">Grade</a></li>
							</c:if>
							<c:if test="${sessionScope.checkuser == 2}">
								<li class="nav-item  "><a class="nav-link " href="home">Trang Chủ
										<span class="sr-only">(current)</span>
								</a></li>

<%-- 								<li class="nav-item  "><a class="nav-link "
									href="<c:url value='managergunpla'/>">Toy Management <span
										class="sr-only">(current)</span>
								</a></li> --%>

								<li class="nav-item  "><a class="nav-link "
									href="<c:url value='storeinfo'/>">My Store <span
										class="sr-only">(current)</span>
									</a>
								</li>



								<li class="nav-item  "><a class="nav-link " href="gunpla">Sản Phẩm
										<span class="sr-only">(current)</span>
								</a></li>
								<!-- 								<div class="colum my-2 my-sm-0" style="width: 3%"> -->
								<!-- 									<form action="cart" class="form-inline my-2 my-lg-0"> -->
								<!-- 										<button class="btn btn-info my-2 my-sm-0" type="submit" -->
								<%-- 											formaction="${pageContext.request.contextPath}/cart"> --%>
								<!-- 											<i class="fa fa-shopping-cart"></i> -->
								<!-- 										</button> -->
								<!-- 									</form> -->
								<!-- 								</div> -->
							</c:if>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/logout">Đăng Xuất </a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		<c:if test="${sessionScope.checkuser != 1}">
			<div class="column" style="width: 40%">
				<form action="search" method="post" class="form-inline my-2 my-lg-0">
					<input type="text" name="txtsearch" value="${txt}"
						class="form-control mr-sm-2" style="width: 80%"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-light my-2 my-sm-0" type="submit"
						formaction="<c:url value="/search"/>">Search</button>
				</form>
			</div>
		</c:if>
		<c:if test="${sessionScope.checkuser ==null}">
			<div class="colum mr-sm-2" style="width: 7%">
				<form action="addcart" class="form-inline my-2 my-lg-0">
					<button class="btn btn-success my-2 my-sm-0" type="submit"
						formaction="<c:url value="/login"/>">
						<i class="fa fa-shopping-cart"></i>
						Cart
						<span class="badge badge-light">0</span>
					</button>
				</form>
			</div>

			<div class="col" style="width: 7%">
				<form action="user" class="form-inline my-2 my-lg-0">
					<button class="btn btn-info my-2 my-sm-0" type="submit"
						formaction="<c:url value="/login"/>">
						<i class="fa fa-user"></i>
					</button>
				</form>
			</div>
		</c:if>
		<c:if test="${sessionScope.checkuser == 2}">
			<div class="colum mr-sm-2" style="width: 7%">
				<form action="addcart" class="form-inline my-2 my-lg-0">
					<button class="btn btn-success my-2 my-sm-0" type="submit"
						formaction="<c:url value="/cart"/>">
						<i class="fa fa-shopping-cart"></i>
						Cart
						<span class="badge badge-light">0</span>				
						${sessionScope.detaillist.size()}
					</button>

				</form>
			</div>
		</c:if>
		<c:if test="${sessionScope.checkuser == 2}">
			<div class="col" style="width: 7%; ">
				<form action="user" class="form-inline my-2 my-lg-0">
					<button class="btn btn-info my-2 my-sm-0" type="submit"
						formaction="<c:url value="/user"/>">
						<i class="fa fa-user"></i> ${sessionScope.user.userName}
					</button>
				</form>
			</div>
		</c:if>
		<c:if test="${sessionScope.checkuser == 1}">
			<div class="col" style="width: 5%;"></div>
			<div class="col" style="width: 5%;"></div>
			<div class="col" style="width: 5%;"></div>
			<div class="col" style="width: 5%; ">
				<form action="user" class="form-inline my-2 my-lg-0">
					<button class="btn btn-info my-2 my-sm-0" type="submit"
						formaction="<c:url value="/user"/>">
						<i class="fa fa-user"></i> ${sessionScope.user.userName}
					</button>
				</form>
			</div>
		</c:if>
	</div>
</nav>


<section class="jumbotron text-center">
     <div class="container">
         <h1 class="jumbotron-heading">TOY STORE</h1>
         <p class="lead text-muted mb-0">Khám phá sức hút phi thường của trò chơi tại cửa hàng đồ chơi của chúng tôi - nơi niềm vui không có ranh giới!</p>
     </div>
</section>


</html>