<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Insert title here</title>
			</head>

			<body>

				<form:form action="/persona/crear" method="post" modelAttribute="usuario">
					<form:label path="rut">rut:</form:label>
					<form:input type="text" path="rut" /><br>

					<form:label path="nombre">nombre:</form:label>
					<form:input type="text" path="nombre" /><br>

					<form:label path="apellido">Apellido:</form:label>
					<form:input type="text" path="apellido" /><br>

					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email" /><br>


					<input type="submit" value="Crear Usuario">
				</form:form>
				<br>
				<h1>Lista Empleados</h1>
				<table>

					<thead>
						<tr>
							<th>#</th>
							<th>Rut</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Email</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${lista}">

							<tr>
								<td>
									<c:out value="${usuario.id}" />
								</td>
								<td>
									<c:out value="${usuario.rut}" />
								</td>
								<td>
									<c:out value="${usuario.nombre}" />
								</td>
								<td>
									<c:out value="${usuario.apellido}" />
								</td>
								<td>
									<c:out value="${usuario.email}" />
								</td>


								<td> <a href="/persona/actualizar/${usuario.id}">Editar</a>								
									<form action="/persona/eliminar/${usuario.id}" method="POST">
										<input type="hidden" name="_method" value="delete" >
										<input type="submit" value="Eliminar">
									</form>	
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</body>
			</html>