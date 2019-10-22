<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%@page import="com.javatpoint.dao.UserDao,com.javatpoint.bean.User"%>

	<%
		String id = request.getParameter("id");
		User u = UserDao.getRecordById(Integer.parseInt(id));
	%>

	<h1>Editar Formulario</h1>
	<form action="edituser.jsp" method="post">
		<input type="hidden" name="id" value="<%=u.getId()%>" />
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=u.getName()%>" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="<%=u.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=u.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td>
					<% 
						String checked = "";
						if (u.getSex() != null)
						{							
							if(u.getSex().equals("male"))							
							{								
								checked = "checked";
							}							
						}						
					%>
					<input type="radio" name="sex" value="male" <%=checked%>/>Masculino
					
					<% 
						checked = "";
						if (u.getSex() != null)
						{
							if(u.getSex().equals("female"))							
							{
								checked = "checked";
							}							
						}	
					%>
					<input type="radio" name="sex" value="female" <%=checked%>/>Femenino					
				</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>
					<select name="country">
						<% 
							String selected = "";
							if (u.getCountry() != null)
							{
								if(u.getCountry().equals("Ecuador"))							
								{
									selected = "selected";
								}							
							}	
						%>
						<option <%=selected %>>Ecuador</option>
						<% 
							selected = "";
							if (u.getCountry() != null)
							{
								if(u.getCountry().equals("Colombia"))							
								{
									selected = "selected";
								}							
							}	
						%>
						<option <%=selected %>>Colombia</option>
						<% 
							selected = "";
							if (u.getCountry() != null)
							{
								if(u.getCountry().equals("Argentina"))							
								{
									selected = "selected";
								}							
							}	
						%>
						<option <%=selected %>>Argentina</option>
						<% 
							selected = "";
							if (u.getCountry() != null)
							{
								if(u.getCountry().equals("Perú"))							
								{
									selected = "selected";
								}							
							}	
						%>
						<option <%=selected %>>Perú</option>
						<% 
							selected = "";
							if (u.getCountry() != null)
							{
								if(u.getCountry().equals("Otro"))							
								{
									selected = "selected";
								}							
							}	
						%>
						<option <%=selected %>>Otro</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit User" /></td>
			</tr>
		</table>
	</form>

</body>
</html>