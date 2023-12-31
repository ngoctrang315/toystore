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
					<dt class="col-sm-4 text-primary">Selected user info</dt>
					<label class="form-label" style="height: 30px"></label>
				</div>

				<div class="row">
					<label class="form-label" style="height: 10px">User ID</label>
					<div class="col">
						<input type="text" name="selecteduserid" id="selecteduserid"><br>
					</div>
					
					<label class="form-label" style="height: 10px">Username</label>
					<div class="col">
						<input type="text" name="selectedusername" id="selectedusername"><br>
					</div>
					
					<label class="form-label" style="height: 10px">Full Name</label>
					<div class="col">
						<input type="text" name="selecteduserfullname" id="selecteduserfullname"><br>
					</div>
				</div>

				<div class="row">
					<label class="form-label" style="height: 16px"></label>
				</div>
				<div class="row">
					<input type="submit" class="btn btn-warning m-2" name="settoadmin"
						style="width: 150px" value="Promote">
				</div>
				
				<div class="row">
					<label class="form-label" style="height: 15px"></label>
				</div>
				<div class="row">
					<table class="table" id="table">
						<thead>
							<tr>
								<th scope="col">User ID</th>
								<th scope="col">Username</th>
								<th scope="col">Full Name</th>
								<th scope="col">DOB</th>
								<th scope="col">Join Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listofuser}" var="prod" varStatus="STT">
								<tr>
									<td>${prod.getUserId()}</td>
									<td>${prod.getUserName()}</td>
									<td>${prod.getFullName()}</td>
									<td><fmt:formatDate value="${prod.getDob()}" pattern="yyyy-MM-dd" /></td>
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
								document.getElementById("selecteduserid").value = this.cells[0].innerHTML;
								document.getElementById("selectedusername").value = this.cells[1].innerHTML;
								document.getElementById("selecteduserfullname").value = this.cells[2].innerHTML;
							};
						}
					</script>
				</div>
			</form>
		</div>

	</div>

</div>
