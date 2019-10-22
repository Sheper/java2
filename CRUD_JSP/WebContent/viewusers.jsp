<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuario</title>
</head>
<body>

	<%@page
		import="com.javatpoint.dao.UserDao,com.javatpoint.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Listado de Usuario</h1>

	<%
		List<User> list = UserDao.getAllRecords();
		request.setAttribute("list", list);
	%>

	<table border="1" data-width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Sexo</th>
			<th>País</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getSex()}</td>
				<td>${u.getCountry()}</td>
				<td><a href="editform.jsp?id=${u.getId()}">Editar</a></td>
				<td><a href="deleteuser.jsp?id=${u.getId()}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduserform.jsp">Add New User</a>

</body>
</html>