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
						<form id="register-form" class="form" action="" method="post">
							<h3 class="text-center text-info" style=>Register</h3>
							<div class="form-group">
								<label for="fullName" class="text-info">Full Name:</label><br>
								<input type="text" name="fullName" id="fullName"
									class="form-control" required
									data-validation-required-message="Please enter your full name">
							</div>

							<div class="form-group">
								<label for="address" class="text-info">Address:</label><br>
								<input type="text" name="address" id="address"
									class="form-control" required
									data-validation-required-message="Please enter your address">
							</div>
							<div class="form-group">
								<label for="username" class="text-info">Username: </label><br>
								<input type="text" name="username" id="username"
									class="form-control" required
									data-validation-required-message="Please enter your username">
							</div>

							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="password" class="text-info">Password: </label><br>
										<input type="password" name="password" id="password"
											class="form-control" required
											data-validation-required-message="Please enter your password">
									</div>

								</div>
								<div class="col">
									<div class="form-group">
										<label for="confirm-password" class="text-info">Confirm
											Password: </label><br> <input type="password"
											name="confirm-password" id="confirm-password"
											class="form-control" required
											data-validation-required-message="Please re-enter your password">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="dob" class="text-info">Birthday:</label><br>
										<input type="text" name="dob" id="dob" class="form-control"
											required
											data-validation-required-message="Please enter your birthDate">
										<div class="help-block text-danger"></div>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label for="phoneNumber" class="text-info">Phone:</label><br>
										<input type="tel" inputmode="numeric" pattern="[0-9\s]{10}"
											maxlength="10" name="phoneNumber" id="phoneNumber"
											class="form-control" required
											data-validation-required-message="Please enter your phonenumber">
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