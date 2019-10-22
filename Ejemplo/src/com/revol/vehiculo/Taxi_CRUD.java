package com.revol.vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revol.basededatos.BaseDeDatos;
public class Taxi_CRUD {
	private final int tipo_vehiculo = 1; // 1: Taxi, Tabla: tipo_vehiculo

    public void agregar(Taxi taxi) throws SQLException {
        String query = "";
        BaseDeDatos bd = new BaseDeDatos();
        Statement sentencia = bd.conectar().createStatement();

        query = "INSERT INTO vehiculo(marca, " + "modelo, " + "matricula, " + "anio, "
                + "id_tipo_vehiculo" + ") VALUES ('" + taxi.getMarca() + "', " + "'" + taxi.getModelo()
                + "', " + "'" + taxi.getMatricula() + "', " + taxi.getAnio() + ", " + tipo_vehiculo + ");";

        if (sentencia.executeUpdate(query) > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }

        System.out.println(query);
        sentencia.close();
        bd.conexion.close();
    }
    public void agregar1(Taxi taxi){
        String query = "";
        BaseDeDatos bd = new BaseDeDatos();
        try {
        	Statement sentencia = bd.conectar().createStatement();
            query = "INSERT INTO vehiculo(marca, " + "modelo, " + "matricula, " + "anio, "
                    + "id_tipo_vehiculo" + ") VALUES ('" + taxi.getMarca() + "', " + "'" + taxi.getModelo()
                    + "', " + "'" + taxi.getMatricula() + "', " + taxi.getAnio() + ", " + tipo_vehiculo + ");";
            if (sentencia.executeUpdate(query) > 0) {
                System.out.println("El registro se insertó exitosamente.");
            } else {
                System.out.println("No se pudo insertar el registro.");
            }
            System.out.println(query);
            sentencia.close();
            bd.conexion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}        
    }

    public void editar_modelo(Taxi taxi, String modelo) {
        String query = "";
        BaseDeDatos bd = new BaseDeDatos();
        try {
            query = "UPDATE vehiculo SET modelo = ? WHERE matricula = ?;";
            PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
            sentenciaP.setString(1, modelo);
            sentenciaP.setString(2, taxi.getMatricula());

            sentenciaP.executeUpdate();
            System.out.println("El registro se actualizó exitosamente.");
            sentenciaP.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminar(Taxi taxi) {
        String query = "";
        BaseDeDatos bd = new BaseDeDatos();
        try {
            query = "DELETE FROM vehiculo WHERE matricula = ?;";
            PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
            sentenciaP.setString(1, taxi.getMatricula());

            sentenciaP.execute();
            System.out.println("El registro se eliminó exitosamente.");
            sentenciaP.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void obtener(Taxi taxi) {
        String query = "";
        BaseDeDatos bd = new BaseDeDatos();
        try {
            query = "SELECT * FROM vehiculo WHERE matricula = '" + taxi.getMatricula() + "';";
            Statement sentencia = bd.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                String matricula = resultado.getString("matricula");
                int anio = resultado.getInt("anio");
                int tipoVehiculo = resultado.getInt("id_tipo_vehiculo");

                // Imprimir los resultados.
                System.out.format("%d, %s, %s, %s, %d, %d\n", id, marca, modelo, matricula, anio, tipoVehiculo);
            }

            sentencia.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
