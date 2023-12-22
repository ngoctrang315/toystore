<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="page-content-wrapper">

	<div class="page-content">

		<div class="row" style="margin: 10px;">

			<div class="col-md-12">

				<div class="portlet-title">

					<div class="tools">

						<a href="javascript:;" class="collapse"> </a> <a
							href="#portlet-config" data-toggle="modal" class="config"> </a> <a
							href="javascript:;" class="reload"> </a> <a href="javascript:;"
							class="remove"> </a>

					</div>

				</div>



				<%@include file="/commons/info.jsp"%>
				<!-- row2 -->
				<form action="#" method="post">
					<br />
					<!-- col1 -->
					<div class="row">
						<div class="col">
							<div class="form-group" hidden="hidden">

								<label for="">GunplaID:</label> <input type="text"
									name="gunplaId" value="${gunpla.gunplaId}" class="form-control"
									readonly />
								<p>${test}</p>
							</div>

							<div class="form-group">

								<label for="">Name:</label> <input type="text"
									class="form-control" name="gunplaName"
									value="${gunpla.gunplaName }" required
									data-validation-required-message="Please enter gunpla name." />

							</div>

							<div class="form-group">

								<label for="">Description:</label> <input type="text"
									class="form-control" name="desc" value="${gunpla.desc}"
									required
									data-validation-required-message="Please enter description." />

							</div>
							<div class="form-group">

								<label for="">Grade:</label> <input type="text"
									class="form-control" name="gradeId" value="${gunpla.gradeId} "
									required data-validation-required-message="Please enter grade." />

							</div>

						</div>
						<!-- end col1 -->
						<div class="col">

							<div class="form-group">

								<label for="">Price:</label> <input type="text"
									class="form-control" name="price" value="${gunpla.price}"
									required data-validation-required-message="Please enter price." />

							</div>
							<div class="form-group">

								<label for="">Stock:</label> <input type="number"
									class="form-control" name="stock" value="${gunpla.stock}"
									required
									data-validation-required-message="Please enter author." />

							</div>
<!-- 							<div class="form-group"> -->

<!-- 								<label for="">Add Stock:</label> <input type="number" -->
<%-- 									class="form-control" name="addstock" value="${addstock}" --%>
<!-- 									required -->
<!-- 									data-validation-required-message="Please enter rating." /> -->

<!-- 							</div> -->



						</div>
						<!-- 						endcol2 -->
						<div class="col">
							<div class="form-group">

								<label>Images:</label> <input type="text" class="form-control"
									name="image" value="${gunpla.image}" />

							</div>


							<div class="form-group">

								<button class="btn btn-primary"
									formaction="<c:url value="/managergunpla/create"/>">

									Create <i class="fa fa-plus"></i>

								</button>

								<button class="btn btn-warning"
									formaction="<c:url value="/managergunpla/update"/>">

									Update <i class="fa fa-edit"></i>

								</button>

								<button class="btn btn-success"
									formaction="${pageContext.request.contextPath }/managergunpla/reset">

									Reset <i class="fa fa-undo"></i>

								</button>

							</div>

						</div>
						<!-- endcol -->
					</div>
				</form>

				<!-- end row1 -->

				<!-- row2 -->
				<div class="row mt-4" style="padding-right: 25px">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>STT</th>
								<th>Name</th>
								<th>Grade</th>
								<th>Images</th>
								<th>Description</th>
								<th>Stock</th>
								<th>Price</th>
								<th>Create Date</th>
								<th>Lasted Update</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstgunpla}" var="gunpla" varStatus="STT">
								<tr class="odd gradeX">
									<td>${STT.index+1 }</td>
									<td>${gunpla.gunplaName}</td>
									<td>${gunpla.gradeId}</td>
									<td><img height="150" width="200" src=" ${gunpla.image}" /></td>
									<td>${gunpla.desc}</td>
									<td>${gunpla.stock }</td>
									<td>${gunpla.price}VNĐ</td>
									<td>${gunpla.createDate }</td>
									<td>${gunpla.upadateDate}</td>
									<td>
										<a href="<c:url value='/managergunpla/edit?id=${gunpla.gunplaId}'/>">
										    <button class="btn btn-sm btn-warning" fdprocessedid="9emhwc">
										        <i class="fa fa-pencil"></i> Sửa
										    </button>
										</a>									
										
										<a href="<c:url value='/managergunpla/delete?id=${gunpla.gunplaId}'/>">
										    <button class="btn btn-sm btn-danger" fdprocessedid="9emhwc">
										        <i class="fa fa-trash"></i> Xóa
										    </button>
										</a>

								</tr>
							</c:forEach>
						</tbody>

					</table>
					<!-- CHOOSE    TABLE -->
					<script>
						var table = document.getElementById('table');
						for (var i = 1; i < table.rows.length; i++) {
							table.rows[i].onclick = function() {
								document.getElementById("gunpla").value = this.cells[0].innerHTML;
								document.getElementById("acronymforgrade").value = this.cells[1].innerHTML;
							};
						}
					</script>
				</div>
				<!-- 				<div class="row"> -->
				<!-- 					<nav aria-label="..."> -->
				<!-- 						<ul class="pagination"> -->
				<%-- 							<c:if test="${tag>1 }"> --%>
				<!-- 								<li class="page-item "><a class="page-link" -->
				<%-- 									href="gunpla?index=${tag-1}">Previous</a></li> --%>
				<%-- 							</c:if> --%>
				<%-- 							<c:forEach begin="1" end="${endP}" var="i"> --%>
				<%-- 								<li class="page-item ${tag==i ? "active":""}" ><a --%>
				<%-- 									class="page-link" href="gunpla?index=${i}">${i}</a></li> --%>
				<%-- 							</c:forEach> --%>
				<%-- 							<c:if test="${tag<endP}"> --%>
				<!-- 								<li class="page-item"><a class="page-link" -->
				<%-- 									href="gunpla?index=${tag+1}">Next</a></li> --%>
				<%-- 							</c:if> --%>
				<!-- 						</ul> -->
				<!-- 					</nav> -->
				<!-- 				</div> -->
				<!-- end row2 -->
			</div>
		</div>
	</div>

</div>



