<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Store
						Info: ${store.storeName}</li>
				</ol>
			</nav>
		</div>
	</div>
	<%@include file="/commons/info.jsp"%>
	<div class="container">
		<div class="row">
			<div id="info-box" class="col-md-12">
				<form class="form" action="" method="post">
					<div class="form-group">
						<div class="row">
							<input hidden=true type="text" class="form-control"
								value="${store.storeId}" name="storeId">

							<div class="col">
								<label class="text-info">Store Name:</label><br> <input
									class="form-control" type="text" value="${store.storeName}"
									name="storeName" required
									data-validation-required-message="Please enter your store name.">
								<div class="help-block text-danger"></div>
							</div>

							<div class="col">
								<div class="form-group">
									<label for="" class="text-info">Create Date: </label><br>
									<input type="date" class="form-control"
										value="${store.createDate}" readonly>
									<div class="help-block text-danger"></div>
								</div>

							</div>

						</div>

						<div class="row">
							<div class="col">
								<label class="text-info">BioStore:</label><br> <input
									class="form-control" type="text" name="bioStore"
									value="${store.bioStore}" required
									data-validation-required-message="Please enter your description.">
								<div class="help-block text-danger"></div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="" class="text-info">Active status : </label><br>
									<c:if test="${store.isActive() == true}">
										<input type="text" class="form-control" value="Activated"
											readonly>
										<div class="help-block text-danger"></div>
									</c:if>
									<c:if test="${store.isActive() != true}">
										<input type="text" class="form-control" value="Not Activated"
											readonly>
										<div class="help-block text-danger"></div>
									</c:if>
								</div>
							</div>
							<div class="col">
								<label for="" class="text-info">Store Wallet: </label><br>
								<button class="btn btn-primary btn-lg fa fa-money"
									style="float: left; font-weight: 400;" disabled>Wallet:
									${store.wallet} VNĐ</button>
							</div>
						</div>

						<div class="row">
							<div class="col"></div>

							<div class="col">
								<c:if test="${store.isActive() == true}">
									<button class="btn btn-warning"
										formaction="<c:url value="/store/update?id=${store.storeId}"/>">

										Update <i class="fa fa-edit"></i>

									</button>

									<button class="btn btn-danger"
										formaction="<c:url value="/store/deactive?id=${store.storeId}"/>">

										Deactive <i class="fa fa-trash-o"></i>

									</button>
								</c:if>
								<c:if test="${store.isActive() != true}">
									<button class="btn btn-warning"
										formaction="<c:url value="/store/update?id=${store.storeId}"/>"
										disabled>

										Update <i class="fa fa-edit"></i>

									</button>

									<button class="btn btn-danger"
										formaction="<c:url value="/store/deactive?id=${store.storeId}"/>"
										disabled>

										Deactive <i class="fa fa-trash-o"></i>

									</button>
								</c:if>
							</div>
						</div>

					</div>
				</form>
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<c:if test="${store.isActive() == true}">
							<form action="managergunpla">
								<button class="btn btn-success fa fa-inbox btn-lg"
									formaction="<c:url value="managergunpla"/>">
									My Gunpla <span class="sr-only">(current)</span>
								</button>
								<button class="btn btn-success fa fa-inbox btn-lg"
									formaction="<c:url value="/store-orders"/>">
									Store Orders <span class="sr-only">(current)</span>
								</button>
							</form>
						</c:if>
						<c:if test="${store.isActive() != true}">
							<form action="managergunpla">
								<button class="btn btn-success fa fa-inbox btn-lg"
									formaction="<c:url value="managergunpla"/>" disabled>
									My Gunpla <span class="sr-only">(current)</span>
								</button>
								<button class="btn btn-success fa fa-inbox btn-lg"
									formaction="<c:url value="/store-orders"/>" disabled>
									Store Orders <span class="sr-only">(current)</span>
								</button>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>