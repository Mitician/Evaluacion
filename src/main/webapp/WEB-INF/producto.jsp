<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/CSS/login.css"/>
<title>Carrito de compras</title>
</head>

<body>
	<form th:action="@{/logout}" method="post">
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		    	<a class="navbar-brand">Carrito</a>
		    </div>
		    <ul class="nav navbar-nav">
		    	<li><a href="/categoria">Categoria</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
	            <li><input type="submit" value="Cerrar Sesion"/></li>
		    </ul>
		  </div>
		</nav>
	</form>
	<div class="form-group">
        <input type="text" class="form-control" placeholder="Ingrese palabra clave">
    </div>
	<div>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Nombre</th>
					<th>Caracteristicas</th>
					<th>Precio</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "producto" items="${productos.content}">
				<tr>
				<td><c:out value="${producto.nombre}"></c:out></td>
				<td><c:out value="${producto.caracteristicas}"></c:out></td>
				<td><c:out value="${producto.precio}"></c:out></td>
				<td><a href="/producto/editar/${producto.id}">Editar</a></td>
				<td><a href="/producto/eliminar/${producto.id}">Eliminar</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form action="/producto/insertar" method="post">
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Agregar</button>
	</form>
	<nav class="text-center">
	<c:forEach begin="1" end="${totalPagina}" var="index">
		<ul class="pagination">
			 <li><a class="page-link" href="/producto/paginacion/${index}">pagina ${index}</a></li>
		</ul>
	</c:forEach>
	</nav>
	<!-- Modal -->
	<form action="/producto/insertar" method="post">
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h3 class="modal-title" id="exampleModalLabel">Agregar producto</h3>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      	<label for="nombre">Nombre Producto: </label>
				<input type="text" name="nombre" id="nombre">
				<br>
				<label for="caracteristicas">Caracteristicas Producto: </label>
				<input type="text" name="caracteristicas" id="desc">
				<br>
				<label for="precio">Precio Producto: </label>
				<input type="text" name="precio" id="precio">
		        <input type="submit" class="btn btn-primary" value="Agregar">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
		      </div>
		    </div>
		  </div>
		</div>
	</form>
    <div class="col">	
        <aside class="col-sm-4">
            <ul id="carrito" class="list-group"></ul>
            <hr>
            <p class="text-right">Total: <span id="total"></span>$</p>
        </aside>
    </div>
</body>
</html>