package com.pp.jpa.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    @Column(name="nombre")
    private String nombre;
 
    @Column(name="password")
    private String password;
 
    @Column(name="email")
    private String email;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="pais")
    private String pais;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email + ", sexo="
				+ sexo + ", pais=" + pais + "]";
	}    
}