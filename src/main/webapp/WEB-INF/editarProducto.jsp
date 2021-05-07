<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Editar Producto::</title>
</head>
<body>
	<div class="container">
		<form:form action="/producto/actualizar/" method="POST" modelAttribute="producto">
			<form:hidden path="id"/>
			<form:label path="nombre">Nombre: </form:label>
			<form:input path="nombre" />
			<form:label path="precio">Precio: </form:label>
			<form:input path="precio" />
			<form:label path="caracteristicas">Caracteristicas: </form:label>
			<form:input path="caracteristicas" />
			<input type="submit" value="Actualizar">
		</form:form>
	</div>
</body>
</html>