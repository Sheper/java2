package com.revol.conductor;
import com.revol.vehiculo.Taxi;

public class Taxista extends Conductor{
	/* Variables */
    private int id;
    private static int idContador = 1;
    private Taxi taxi;

    /* Constructores */
    public Taxista(String nombre, String tipoLicencia, Taxi taxi){
        super(nombre, tipoLicencia);
        this.taxi = taxi;
        this.id = idContador;
        idContador++;
        // System.out.println(this.id);
    }

    /* Getters y Setters */
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Taxi getTaxi(){
        return taxi;
    }

    public void setTaxi(Taxi taxi){
        this.taxi = taxi;
    }

    /* Sobrecarda de métodos (Polimorfismo) */
    @Override
    public void mostrarVehiculo(){
        super.mostrarVehiculo();
        System.out.println("Datos del Taxi: " + getTaxi().getMarca() + " " + getTaxi().getModelo());
    }
}
