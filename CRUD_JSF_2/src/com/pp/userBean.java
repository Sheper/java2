package com.pp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userBean")
@RequestScoped
public class userBean implements Serializable {
	private static final long serialVersionUID = 6081417964063918994L;
	public List<User> usersLists;
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	Connection connection;
	private User user;

	public userBean() {
		user = new User();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	// Used to establish connection
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_db", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	// Used to fetch all records
	public ArrayList<User> usersList() {
		try {
			usersLists = new ArrayList<User>();
			connection = getConnection();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setNombre(rs.getString("nombre"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setSexo(rs.getString("sexo"));
				user.setPais(rs.getString("pais"));
				usersLists.add(user);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return (ArrayList<User>) usersLists;
	}

	// Used to save user record
	public String save() {
		System.out.println("entra User=>"+user);
		int result = 0;
		try {
			connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("insert into usuario(nombre,email,password,sexo,pais) values(?,?,?,?,?)");
//			User user = new User();
//            user.setNombre(nombre);

			String nombrepais = getPaisName(user.getPais());
			String tiposexo = getTipoSexo(user.getSexo());
			stmt.setString(1, user.getNombre());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, tiposexo);
			stmt.setString(5, nombrepais);
			result = stmt.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (result != 0)
			return "index.xhtml?faces-redirect=true";
		else
			return "create.xhtml?faces-redirect=true";
	}

	// Used to fetch record to update
	public String edit(int id) {
		System.out.println("EDITAR");
		User user = null;
		try {
			connection = getConnection();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario where id = " + (id));
			rs.next();
			String nombrepais = getPaisName2(rs.getString("pais"));
			String tiposexo = getTipoSexo2(rs.getString("sexo"));
			user = new User();
			user.setId(rs.getInt("id"));
			user.setNombre(rs.getString("nombre"));
			user.setEmail(rs.getString("email"));
			user.setSexo(tiposexo);
			user.setPais(nombrepais);
			user.setPassword(rs.getString("password"));
			sessionMap.put("editUser", user);
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/edit.xhtml?faces-redirect=true";
	}

	// Used to update user record
	public String update(User u) {
		// int result = 0;
		try {
			connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("update usuario set nombre=?,email=?,password=?,sexo=?,pais=? where id=?");
			String nombrepais = getPaisName(u.getPais());
			String tiposexo = getTipoSexo(u.getSexo());
			stmt.setString(1, u.getNombre());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			stmt.setString(4, tiposexo);
			stmt.setString(5, nombrepais);
			stmt.setInt(6, u.getId());
			stmt.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/index.xhtml?faces-redirect=true";
	}

	// Used to delete user record
	public void delete(int id) {
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement("delete from usuario where id = " + id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Used to set user gender
	public String getTipoSexo(String sexo) {
		if (sexo.equals("M")) {
			return "Masculino";
		} else
			return "Femenino";
	}

	public String getTipoSexo2(String sexo) {
		if (sexo.equals("Masculino")) {
			return "M";
		} else
			return "F";
	}

	public String getPaisName(String pais) {
		if (pais.equals("E")) {
			return "Ecuador";
		}
		if (pais.equals("C")) {
			return "Colombia";
		}
		if (pais.equals("P")) {
			return "Per�";
		}
		if (pais.equals("B")) {
			return "Bolivia";
		}
		if (pais.equals("Br")) {
			return "Brasil";
		}
		return "Argentina";
	}

	public String getPaisName2(String pais) {
		if (pais.equals("Ecuador")) {
			return "E";
		}
		if (pais.equals("Colombia")) {
			return "C";
		}
		if (pais.equals("Per�")) {
			return "P";
		}
		if (pais.equals("Bolivia")) {
			return "B";
		}
		if (pais.equals("Brasil")) {
			return "Br";
		}
		if (pais.equals("Argentina")) {
			return "A";
		}
		return "";
	}
}
