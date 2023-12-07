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
				<div class="row">
					<dt class="col-sm-4 text-primary" >Enter new grade info</dt>
					<label class="form-label" style="height: 30px"></label>
				</div>

				<div class="row">
					<label class="form-label" style="height: 10px">Grade</label>
					<div class="col">
						<input type="text" name="grade" id="grade"><br>
					</div>

					<label class="form-label" style="height: 10px">Acronym for grade</label>
					<div class="col">
						<input type="text" name="acronymforgrade" id="acronymforgrade"><br>
					</div>
				</div>

				<div class="row">
					<label class="form-label" style="height: 16px"></label>
				</div>
				
				<input type="submit" class="btn btn-primary m-2" name="addnewgrade"
					style="width: 150px" value="Add new grade"> 
					
				<label class="form-label" style="width: 80px"></label> 
				<input type="submit" class="btn btn-success m-2" name="updategrade"
					style="width: 150px" value="Update grade">
					
				<label class="form-label" style="width: 80px"></label> 
				<input type="submit" class="btn btn-danger m-2" name="removegrade"
					style="width: 150px" value="Remove grade">

				<div class="row">
					<label class="form-label" style="height: 15px"></label>
				</div>
				<div class="row">
					<table class="table" id="table">
						<thead>
							<tr>
								<th scope="col">Acronym for grade</th>
								<th scope="col">Grade</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listofgrade}" var="prod" varStatus="STT">
								<tr>
									<td>${prod.getGrade()}</td>
									<td>${prod.getGradeName()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- CHOOSE	TABLE -->
					<script>
						var table = document.getElementById('table');
						for (var i = 1; i < table.rows.length; i++) {
							table.rows[i].onclick = function() {
								document.getElementById("acronymforgrade").value = this.cells[0].innerHTML;
								document.getElementById("grade").value = this.cells[1].innerHTML;
							};
						}
					</script>
				</div>
			</form>
		</div>

	</div>

</div>
