package com.revol.conductor;
import com.revol.vehiculo.Bus;

public class ChoferBus extends Conductor{
	/* Variables */
    private Bus bus;

    /* Constructores */
    public ChoferBus(String nombre, String tipoLicencia, Bus bus){
        super(nombre, tipoLicencia);
        this.bus = bus;
    }

    /* Getters y Setters */
    public Bus getBus(){
        return bus;
    }

    public void setBus(Bus bus){
        this.bus = bus;
    }

    /* Sobrecarda de métodos (Polimorfismo) */
    @Override
    public void mostrarVehiculo(){
        super.mostrarVehiculo();
        System.out.println("Datos del Bus: " + getBus().getMarca() + " " + getBus().getModelo());
    }
}
