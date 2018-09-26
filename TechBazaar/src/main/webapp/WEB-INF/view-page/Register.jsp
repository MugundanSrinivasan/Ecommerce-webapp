<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="Header.jsp" %>
<script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<title></title>

	<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
	   <script src = "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--===============================================================================================-->

</head>
<body>
	<form:form action="insertuserdetail" modelAttribute="user" method="post" enctype="multipart/form-data">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				
					<span class="login100-form-title p-b-49">
						Sign_Up
					</span>

				
					
					<div class="wrap-input100 validate-input m-b-23">
						
<form:input class="input100" path="username" placeholder="Type your username"/>
											
					</div>
					
					<div class="wrap-input100 validate-input m-b-23">
						<form:input class="input100"  path="emailId"   placeholder="Type your email-id"/>
						</div>
							<div class="wrap-input100 validate-input m-b-23">
						<form:input class="input100"  path="customerName"   placeholder="Type your email-id"/>
						</div>
					<div class="wrap-input100 validate-input m-b-23">
						<form:input class="input100"  path="mobileNo"   placeholder="Type your number"/>
						</div>
						
					    <div class="wrap-input100 validate-input">
					<form:input class="input100" path="password" placeholder="Type your password"/>
						</div>
					<br/>
				

   	<div class="wrap-input100 validate-input m-b-23">
					 <input class="input100" type="text" name="address" path="address"  placeholder="Type your Address"/>
						
					</div>
					<form:hidden path="role" value="ROLE_USER"/> 
					<form:hidden path="enabled" value="TRUE"/> 
					<br/><br/>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Sign_Up
							</button>
						</div>
					</div>

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Or Sign_In Using
						</span>

						<a href="login" class="txt2">
							Log_In
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<!-- <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
	 var mainApp = angular.module("mainApp", []);
         
         mainApp.controller('studentController', function($scope) {
         
         });
		 
</script> -->
</body>
</html>