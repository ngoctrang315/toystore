<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>


<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/gunpla">Sản Phẩm</a></li>
					<li class="breadcrumb-item active" aria-current="page">${currentGrade}</li>
				</ol>
			</nav>
		</div>
	</div>
	<p>${messadd}</p>
</div>

<form action="" method="post">
	<div class="row">
		<div class="col-12 col-sm-3">
			<div class="card bg-light mb-3">
			<div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Danh Mục Đồ chơi</div>
				<ul class="list-group category_block">
				
					<li class="list-group-item"><a class="text-dark"
						href="<c:url value='/gunpla?index=1&gid=all'/>">Tất cả</a></li>
					<c:forEach items="${listGrade}" var='grade'>
						<li class="list-group-item"><a class="text-dark"
							href="<c:url value='/gunpla?index=1&gid=${grade.grade}'/>">${grade.gradeName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="col">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card bg-light mb-3">
							<div class="card-body">
								<div class="row">
									<c:forEach items="${listAllGunpla}" var='gunpla'>
										<div class="col-sm mt-3 text-info">
											<div class="card" style="width: 240px">

												<a
													href="<c:url value="/gunpla/details?id=${gunpla.gunplaId}"/>">
													<img class="card-img-top" width="197,5" height="350"
													src="${gunpla.image}" alt="Card image cap" />
												</a>

												<div class="card-body">
													<h4 class="card-title ">
														<a class="text-st text-info">${gunpla.gunplaName}</a>
													</h4>
												</div>
												<div class="card-footer">
													<p class="card-text text-st">${gunpla.desc}</p>
													<div class="row">
														<div class="col">
															<p class="btn btn-danger btn-block">${gunpla.price} VND</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="col-12">
							<nav aria-label="...">
								<ul class="pagination">
									<c:if test="${tag>1 }">
										<li class="page-item "><a class="page-link"
											href="${pageContext.request.contextPath }/gunpla?index=${tag-1}&gid=${currentGrade}">Previous</a></li>
									</c:if>
									<c:forEach begin="1" end="${endP}" var="i">
										<li class='${tag==i?"active":"" }'><a class="page-link"
											href="${pageContext.request.contextPath}/gunpla?index=${i}&gid=${currentGrade}">${i}</a></li>
									</c:forEach>
									<c:if test="${tag<endP}">
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/gunpla?index=${tag+1}&gid=${currentGrade}">Next</a></li>
									</c:if>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>