package com.revol.vehiculo;

public class Vehiculo {
    /* Variables */
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private int anio;

    /* Constructores */
    public Vehiculo(String marca, String modelo, String matricula, int anio){
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anio = anio;
    }

    /* Getters y Setters */
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public int getAnio(){
        return anio;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }

}
