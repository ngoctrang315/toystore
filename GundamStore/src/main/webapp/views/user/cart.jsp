<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<div class="page-content-wrapper">

	<div class="page-content">

		<div class="row" style="margin: 10px;">

			<div class="col-md-12">

				<div class="portlet-title">

					<div class="caption text-info">

						<!-- end row1 -->

						<!-- row2 -->
						<div class="row mt-4" style="padding-right: 25px">

							<table class="table table-hover">
								<thead>
									<tr>
										<th>No</th>
										<th>Gunpla</th>
										<th>Grade</th>
										<th>Price</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listofcart}" var="cl" varStatus="STT">
										<tr class="odd gradeX">
											<td>${STT.index+1 }- ${detaillist.size()}</td>
											<td>${cl[0]}</td>
											<td>${cl[1]}</td>
											<td>${cl[2]}</td>
											<td>
											    <form action="" method="post">
											        <a href="<c:url value='/cart-delete?id=${cl[3]}'/>" class="btn btn-sm btn-danger">
											            <i class="fa fa-trash"></i> Remove
											        </a>
											    </form>
											</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
							
							<div class="row">
								<label class="form-labal" style="width: 50px"></label>
								<label class="form-label" style="height: 10px">Total Price</label>
								<div class="col">
									<input type="text" name="totalprice" id="totalprice" readonly value=${order.total }><br>
								</div>
								<label class="form-labal" style="width: 100px"></label>
							</div>
							
							<div class="row">
								<div class="col">
									<form method="post">
										<a href="<c:url value='/cart-checkout'/>" class="btn btn-success">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i> Purchase</a>
									</form>
								</div>
							</div>
							<label class="form-labal" style="width: 100px"></label>
							
							<!-- 
							<div class="row">
								<%@include file="/commons/info.jsp"%>
							</div>
							 -->
						</div>
						<!-- end row2 -->
					</div>
				</div>
			</div>

		</div>

	</div>
</div>