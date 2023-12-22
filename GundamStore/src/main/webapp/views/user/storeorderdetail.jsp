<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="container">
	<div class="row">
		<label class="form-label" style="height: 10px">Order ID : </label>
		<label class="form-label" style="height: 10px; width: 10px"></label>
		<input type="text" name="orderidindetail" id="orderidindetail" value="${listofstoreorderdetail.get(0)[0]}" readonly><br>
	</div>
	<div class="row">
		<label class="form-label" style="height: 10px"></label>
	</div>
	<div class="row">
		<label class="form-label" style="height: 10px">Status : </label>
		<label class="form-label" style="height: 10px; width: 26px"></label>
		<input type="text" name="statusindetail" id="statusindetail" style="width: 400px" value="${listofstoreorderdetail.get(0)[3]}" readonly><br>
	</div>
	<div class="row">
		<label class="form-label" style="height: 10px"></label>
	</div>

	<div class="row">
		<table class="table" id="table">
			<thead>
				<tr>
					<th scope="col">Product</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listofstoreorderdetail}" var="ordDl"
					varStatus="STT">
					<tr>
						<td>${ordDl[1] }</td>
						<td>${ordDl[2] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
<!-- 	<form action="" method="post">
		<input type="submit" class="btn btn-primary m-2" name="confirm-dispatched"
					style="width: 150px" value="Dispatched"> 
	</form> -->
</div>