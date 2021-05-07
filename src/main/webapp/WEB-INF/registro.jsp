<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>Registro</title>
	<link rel="stylesheet" type="text/css" href="/CSS/login.css"/>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
				<img src="https://e7.pngegg.com/pngimages/416/62/png-clipart-anonymous-person-login-google-account-computer-icons-user-activity-miscellaneous-computer-thumbnail.png" id="icon" alt="User Icon" />
			</div>
			<form th:action="@{/process_register}" th:object="${user}" method="POST">
				<input type="text" th:field="*{nombre}" class="fadeIn second" placeholder="name" required></input>
				<input type="text" th:field="*{email}" class="fadeIn second" placeholder="email" required></input>
				<input type="password" th:field="*{password}" class="fadeIn third" placeholder="password" required></input>
				<input type="password" th:field="*{passwordConfirm}"class="fadeIn fourth" placeholder="confirm password" required></input>
				<input type="submit" class="button" value="Register">
				<a href="/" class="button">Cancel</a>
			</form>
		</div>
	</div>
</body>
</html>