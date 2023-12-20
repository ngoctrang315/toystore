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

<link rel="stylesheet" href="<c:url value="template/web/css/login.css"/>">
<title>Bootstrap 4 Login/Register Form</title>
</head>
<body>
	<div id="login">
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="" method="post">
							<h3 class="text-center text-info">Login</h3>
							<div class="form-group">
								<label for="username" class="text-info">Username:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col">
										<label for="remember-me" class="text-info">Manager
										 <input
											type="radio"
											name="accType" ${accType?'checked':''} value="manager">
										</label>
										
									</div>
									<div class="col">
										<label for="remember-me" class="text-info">Member
										 <input
											 type="radio"
											name="accType" ${accType?'checked':''} value="member">
										</label>
										
									</div>
									<div class="col">
										<a href="register" class="text-info">Register here</a>
									</div>
								</div>
							</div>
							<div class="row">
								<input type="submit" name="submit"
									class="text-white btn btn-info btn-md" value="Login">
								<p class="text-danger pd-l">${mess}</p>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>