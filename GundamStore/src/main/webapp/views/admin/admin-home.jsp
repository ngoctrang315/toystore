<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/commons/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="template/web/css/admin.css">


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
		<div class="row">		
			<div class="col">
			    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
			        <div class="icon-container bg-warning">
			            <i class="fa fa-dollar" style="font-size: 40px; color: #ffffff"></i>
			        </div>
			        <div class="ms-3">
			            <p class="mb-2" style="font-size: 16px">This month</p>
			            <p class="mb-2" style="font-size: 16px"><strong>Revenue</strong></p>
			            <h6 class="mb-0" >${thismonthrevenue} VND</h6>
			        </div>
			    </div>
			</div>					
			<div class="col">
			    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
			        <div class="icon-container1 bg-sucess">
			            <i class="fa fa-users" style="font-size: 40px; color: #ffffff"></i>
			        </div>
			        <div class="ms-3">
			            <p class="mb-2" style="font-size: 16px">This month</p>
			            <p class="mb-2" style="font-size: 16px"><strong>Joined Users</strong></p>
			            <h6 class="mb-0" >${thismonthjoinuser}</h6>
			        </div>
			    </div>
			</div>								
			<div class="col">
			    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
			        <div class="icon-container2 bg-info">
			            <i class="fa fa-archive" style="font-size: 40px; color: #ffffff"></i>
			        </div>
			        <div class="ms-3">
			            <p class="mb-2" style="font-size: 16px">This month</p>
			            <p class="mb-2" style="font-size: 16px"><strong>Joined Store</strong></p>
			            <h6 class="mb-0" >${thismonthjoinstore}</h6>
			        </div>
			    </div>
			</div>			
		
		</div>	
		
        
        		
		</div>		
	</div>
</div>

