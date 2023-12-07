<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet"
	href="<c:url value="template/web/css/register.css"/>">
<title>Bootstrap 4 Register Form</title>
</head>
<body>
	<div id="register">
		<div class="container">
			<div id="register-row"
				class="row justify-content-center align-items-center">
				<div id="register-column" class="col-md-6">
					<div id="register-box" class="col-md-12">
						<form class="form" action="" method="post">
							<h3 class="text-center text-info" style=>Create Store</h3>
							<div class="form-group">
								<label for="storeName" class="text-info">Store Name:</label><br>
								<input type="text" name="storeName" id="storeName"
									class="form-control" required
									data-validation-required-message="Please enter your Store name">
							</div>

							<div class="form-group">
								<label for="bioStore" class="text-info">BioStore:</label><br>
								<input type="text" name="bioStore" id="bioStore"
									class="form-control" required
									data-validation-required-message="Please enter your Bio">
							</div>
							<div class="form-group">
								<label for="createDate" class="text-info">Create Date: </label><br>
								<input type="date" name="createDate" id="createDate" value="${createDate}"
									class="form-control" readonly>
							</div>

							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="isActive" class="text-info">Active Status: </label><br>
										<input type="text" name="isActive" id="isActive" value="Not Activated"
											class="form-control" readonly>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col">
									<input type="submit" name="submit"
										class="text-white btn btn-info btn-md" value="Submit">
								</div>
								<div class="col">
									<p class="text-danger pd-l">${mess}</p>
								</div>


							</div>
						</form>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>
</html>