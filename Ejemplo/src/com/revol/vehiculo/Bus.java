package com.revol.vehiculo;
import java.util.ArrayList;

public class Bus extends Vehiculo{
	 /* Variables */
    private ArrayList estaciones;

    /* Constructores */
    public Bus(String marca, String modelo, String matricula, int anio){
        super(marca, modelo, matricula, anio);
    }

    /* Getters y Setters */
    public ArrayList getEstaciones(){
        return estaciones;
    }
 
    public void setEstaciones(ArrayList estaciones){
        this.estaciones = estaciones;
    }

}
