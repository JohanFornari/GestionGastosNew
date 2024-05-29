package com.gestiongastos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPerfil;
	private String nombre;
	private int privilegio;
	
	public Perfil(int idPerfil,String nombre,int privilegio){
	    this.idPerfil = idPerfil;
	    this.nombre = nombre;
	    this.privilegio = privilegio;
	}
	
	public Perfil() {
        super();
    }
    
    public int getIdPerfil() {
        return this.idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrivilegio() {
        return this.privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
}
