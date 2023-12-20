<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="container">
	<form action="" method="post">
		<div class="row">
			<table class="table" id="table">
				<thead>
					<tr>
						<th scope="col">Order ID</th>
						<th scope="col">Total Price</th>
						<th scope="col">View Detail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listofuserorder}" var="ordl" varStatus="STT">
						<tr>
							<td>${ordl.getOrderId() }</td>
							<td>${ordl.getTotal() }</td>
							<td><form action ="" method="post"><a href="<c:url value='/user-order-detail?userorderid=${ordl.getOrderId()}'/>"class="center">View</a></form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</div>