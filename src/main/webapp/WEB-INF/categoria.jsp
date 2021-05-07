<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/CSS/login.css"/>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
				<img src="https://img2.freepng.es/20180331/zjw/kisspng-computer-icons-download-product-5ac01757f1b084.28705987152253832799.jpg" id="icon" alt="User Icon" />
			</div>
			<form action="/categoria/insertar" method="POST">
				<input type="text" id="nombre" class="fadeIn second" name=nombre placeholder="Nombre de categoria">
				<input type="submit" class="button" value="Agregar">
				<a href="/producto" class="button">Salir</a>
			</form>
		</div>
	</div>
</body>
</html>