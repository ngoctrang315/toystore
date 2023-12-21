<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/commons/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="template/web/css/style.css">

<div class="container">
	<div class="row">
		<div class="col-12 col-sm-2" >
			<div class="card mb-3">
				<ul class="list-group category_block">
				
				    <li class="list-group-item list-item-black-bg">				    
				    	<i class="fa fa-home" style="font-size: 20px; color: rgb(255, 255, 255)"></i>
				        <a class="text-light" href="<c:url value='admin-statistics'/>"> Menu</a></li>
				        				        
				    <li class="list-group-item list-item-black-bg">
				    	<i class="fa fa-bar-chart" style="font-size: 20px; color: rgb(255, 255, 2550)"></i>
				        <a class="text-light" href="<c:url value='admin-statistics'/>"> Statistics</a></li>					

					<li class="list-group-item list-item-black-bg">
				    	<i class="fa fa-users" style="font-size: 20px; color: rgb(255, 255, 255)"></i>					
						<a class="text-light" href="<c:url value='admin-user-management'/>"> User</a></li>
						
					<li class="list-group-item list-item-black-bg">
				    	<i class="fa fa-archive" style="font-size: 20px; color: rgb(255, 255, 2550)"></i>					
						<a class="text-light" href="<c:url value='admin-store-management'/>"> Store</a></li>

					<li class="list-group-item list-item-black-bg">
				    	<i class="fa fa-star" style="font-size: 20px; color: rgb(255, 255, 2550)"></i>					
						<a class="text-light" href="<c:url value='admin-grade-management'/>"> Grade</a></li>
				
						
					<li class="list-group-item list-item-black-bg">
				    	<i class="fa fa-user" style="font-size: 20px; color: rgb(255, 255, 255)"></i>					
						<a class="text-light" href="<c:url value='user'/>"> Admin profile</a>
					</li>
					
					<li class="list-group-item list-item-black-bg">
				    	<i class="fa fa-exclamation" style="font-size: 20px; color: rgb(255, 0, 0)"></i>					
						<a class="text-light" href="${pageContext.request.contextPath}/logout"> Logout</a>
					</li>										
				</ul>
			</div>
		</div>
		
		<div class="col">



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
			
			<div class="col-sm-9 text-right">
			    <form action="/ToyStore/xuatExcelControl" style="display: flex; justify-content: flex-start;"> 
			        <button type="submit" class="mb-0 text-center btn btn-primary">Xuất file Excell</button> 		           			
			    </form>    
			</div>			
			
			<div class="row">
				<label class="form-label" style="height: 15px"></label>
			</div>			
		</div>

	</div>

</div>
