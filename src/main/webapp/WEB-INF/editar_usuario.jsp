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
		<div>
				<form:form action="/persona/modificar" method="post" modelAttribute="usuario">
					<input type="hidden" name="_method" value="put" >
					<form:hidden path="id"/>

					<form:label path="rut">Rut:</form:label>
					<form:input type="text" path="rut" /><br>

					<form:label path="nombre">Nombre:</form:label>
					<form:input type="text" path="nombre" /><br>

					<form:label path="apellido">Apellido:</form:label>
					<form:input type="text" path="apellido" /><br>

					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email" /><br>


					<input type="submit" value="Modificar">
				</form:form>

		</div>
	</body>
</html>