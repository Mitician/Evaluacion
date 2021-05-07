<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/CSS/login.css"/>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<% Integer registrado = (Integer) session.getAttribute("registrado"); %>
</head>
<body>
	<form action="/login" method="post">
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
				<img src="https://e7.pngegg.com/pngimages/416/62/png-clipart-anonymous-person-login-google-account-computer-icons-user-activity-miscellaneous-computer-thumbnail.png" id="icon" alt="User Icon" />
			</div>
				<input type="text" id="user" class="fadeIn second" name=login placeholder="user">
				<input type="password" id="password" class="fadeIn third" name="login" placeholder="password">
				<a href="/producto" class="button">Log in</a>
			<div id="formFooter">
				<a class="underlineHover" href="/usuario">¿desea registrarse?</a>
			</div>
			<div id="formFooter">
				<a class="underlineHover" href="#">¿olvidó su contraseña?</a>
			</div>
		</div>
	</div>
	</form>
	
</body>
</html>