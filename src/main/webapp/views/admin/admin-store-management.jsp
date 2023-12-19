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
		
			<div class="col-sm-9 text-right">
			    <form action="/GundamStore/xuatExcelStore" style="display: flex; justify-content: flex-start;"> 
			        <button type="submit" class="mb-0 text-center btn btn-primary">Xuất file Excell</button> 		           			
			    </form>    
			</div>		
		
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
