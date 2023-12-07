<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/gunpla">Gunplas</a></li>
					<li class="breadcrumb-item active" aria-current="page">Search</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col">
			<div class="card bg-light mb-3">
				<div class="card-body">
					<div class="row">
						<p class="text">${found}</p>
						<c:forEach items="${searchlist}" var='gunplas'>
							<div class="col-12 col-md-6 col-lg-4">
								<div class="card"
									style="display: block; text-overflow: ellipsis; width: 200px; overflow: hidden; white-space: nowrap;">
									<div class="card-top">
										<a
											href="<c:url value="/search/details?id=${gunplas.gunplaId}"/>">
											<img class="card-img-top" width="197,5" height="350"
											src="${gunplas.image}" alt="Card image cap" />
										</a>
									</div>
									<div class="card-body">
										<h4 class="card-title">
											<a>${gunplas.gunplaName}</a>
										</h4>
									</div>
									<div class="card-footer">
										<p class="card-text">${gunplas.desc}</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${gunplas.price} VND</p>
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
								href="${pageContext.request.contextPath }/search?keyword=${keyword}&index=${tag-1}">Previous</a></li>
						</c:if>
						<c:forEach begin="1" end="${endP}" var="i">
							<li class='${tag==i?"active":"" }'><a class="page-link"
								href="${pageContext.request.contextPath}/search?keyword=${keyword}&index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${tag<endP}">
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/search?keyword=${keyword}&index=${tag+1}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<%--  					</c:forEach>
 --%>
		</div>
	</div>



</div>