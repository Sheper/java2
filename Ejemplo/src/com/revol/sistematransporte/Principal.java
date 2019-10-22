package com.revol.sistematransporte;
import java.sql.SQLException;
import com.revol.vehiculo.Taxi;
import com.revol.vehiculo.Taxi_CRUD;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Taxi tx = new Taxi("Chevrolet", "Spark", "TQR876", 2016);
        Taxi_CRUD tx_crud = new Taxi_CRUD();
        tx_crud.agregar1(tx);
        tx_crud.eliminar(tx);
        //tx_crud.agregar(tx);
        tx_crud.editar_modelo(tx, "Aveo");
        tx_crud.obtener(tx);
	}

}
