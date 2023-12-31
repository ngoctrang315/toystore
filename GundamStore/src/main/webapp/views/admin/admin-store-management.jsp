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
			<!--  <a href="<c:url value='/home'/>"><input type=button value='go tu hum'></a>-->
			<!--  <div class="d-flex mb-2">
				<input class="form-control bg-transparent" type="text" placeholder="Enter customer's phone number">
                <button type="button" class="btn btn-primary ms-2" style="width:150px">Find</button>
			</div>-->
			<!--  
			<div class="row">
				First Name:<input type="text" name="fname" id="fname"><br> <br>
			</div>
			<div class="row">
				Last Name:<input type="text" name="lname" id="lname"><br> <br>
			</div>
			<div class="row">
				Age:<input type="text" name="score" id="score"><br> <br>
			</div>
			-->
			<form action="" method="post">
				<!--  <div class="row">
					<dt class="col-sm-4 text-primary">Enter new grade info</dt>
					<label class="form-label" style="height: 30px"></label>
				</div>-->

				<div class="row">
					<dt class="col-sm-4 text-primary">Selected store info</dt>
					<label class="form-label" style="height: 30px"></label>
				</div>

				<div class="row">
					<label class="form-label" style="height: 10px">Store ID</label>
					<div class="col">
						<input type="text" name="selectedstoreid" id="selectedstoreid"><br>
					</div>
					
					<label class="form-label" style="height: 10px">Name</label>
					<div class="col">
						<input type="text" name="selectedstorename" id="selectedstorename"><br>
					</div>
					
					<label class="form-label" style="height: 10px">Status</label>
					<div class="col">
						<input type="text" name="selectedstorestatus" id="selectedstorestatus"><br>
					</div>
				</div>

				<div class="row">
					<label class="form-label" style="height: 16px"></label>
				</div>
				<div class="row">
					<div class="col" align="center">
						<input type="submit" class="btn btn-primary m-2" name="approvestore"
							style="width: 150px" value="Approve Store">
					</div>
					<div class="col" align="center">
						<input type="submit" class="btn btn-danger m-2" name="deactivestore"
							style="width: 150px" value="Deactive Store">
					</div>
				</div>
				
				<div class="row">
					<label class="form-label" style="height: 15px"></label>
				</div>
				<div class="row">
					<table class="table" id="table">
						<thead>
							<tr>
								<th scope="col">Store ID</th>
								<th scope="col">Name</th>
								<th scope="col">Active Status</th>
								<th scope="col">Created Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listofstore}" var="prod" varStatus="STT">
								<tr>
									<td>${prod.getStoreId()}</td>
									<td>${prod.getStoreName()}</td>
									<td>${prod.isActive()}</td>
									<td><fmt:formatDate value="${prod.getCreateDate()}" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- CHOOSE	TABLE -->
					<script>
						var table = document.getElementById('table');
						for (var i = 1; i < table.rows.length; i++) {
							table.rows[i].onclick = function() {
								document.getElementById("selectedstoreid").value = this.cells[0].innerHTML;
								document.getElementById("selectedstorename").value = this.cells[1].innerHTML;
								document.getElementById("selectedstorestatus").value = this.cells[2].innerHTML;
							};
						}
					</script>
				</div>
			</form>
		</div>

	</div>

</div>
