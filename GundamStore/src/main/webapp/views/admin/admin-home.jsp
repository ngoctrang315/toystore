<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/commons/taglib.jsp"%>



<div class="container">
	<div class="row">
		<div class="col-12 col-sm-3">
			<div class="card bg-light mb-3">
				<ul class="list-group category_block">
					<li class="list-group-item"><a class="text-dark"
						href="<c:url value='admin-statistics'/>">Statistics</a></li>
					<li class="list-group-item"><a class="text-dark"
						href="<c:url value='admin-user-management'/>">User management</a></li>
					<li class="list-group-item"><a class="text-dark"
						href="<c:url value='admin-store-management'/>">Store management</a></li>
					<li class="list-group-item"><a class="text-dark"
						href="<c:url value='admin-grade-management'/>">Grade management</a></li>
				</ul>
			</div>
		</div>
		<div class="col">
			<div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
				<i class="fa fa-pie-chart" style="font-size: 60px; color: rgb(99, 188, 251)"></i>
				<div class="ms-3">
					<p class="mb-2" style="font-size: 16px">This month</p>
					<p class="mb-2" style="font-size: 16px"><strong>Revenue</strong></p>
					<h6 class="mb-0">${thismonthrevenue} VND</h6>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
				<i class="fa fa-users" style="font-size: 60px; color: rgb(99, 188, 251)"></i>
				<div class="ms-3">
					<p class="mb-2" style="font-size: 16px">This month</p>
					<p class="mb-2" style="font-size: 16px"><strong>Joined Users</strong></p>
					<h6 class="mb-0">${thismonthjoinuser}</h6>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
				<i class="fa fa-archive" style="font-size: 60px; color: rgb(99, 188, 251)"></i>
				<div class="ms-3">
					<p class="mb-2" style="font-size: 16px">This month</p>
					<p class="mb-2" style="font-size: 16px"><strong>Joined Store</strong></p>
					<h6 class="mb-0">${thismonthjoinstore}</h6>
				</div>
			</div>
		</div>

	</div>

</div>

