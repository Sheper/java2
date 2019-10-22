package com.revol.basededatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BaseDeDatos {
	private final String URL = "jdbc:mysql://localhost:3306/"; // Ubicaci�n de la BD.
    private final String BD = "bd_ejemplo"; // Nombre de la BD.
    private final String USER = "pp";
    private final String PASSWORD = "pp";

    public Connection conexion = null;

    @SuppressWarnings("finally")
    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL + BD, USER, PASSWORD);
            if (conexion != null) {
                System.out.println("�Conexi�n Exitosa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conexion;
        }
    }
}
