package com.gestiongastos.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfil implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codperfil;
	private String nombreperfil;
	private String privilegio;

	public Perfil(int codPerfil, String nombPerfil, String privilegio) {
		this.codperfil = codPerfil;
		this.nombreperfil = nombPerfil;
		this.privilegio = privilegio;
	}

	public Perfil() {
		super();
	}

	public int getCodperfil() {
		return codperfil;
	}

	public void setCodperfil(int codperfil) {
		this.codperfil = codperfil;
	}

	public String getNombreperfil() {
		return nombreperfil;
	}

	public void setNombreperfil(String nombreperfil) {
		this.nombreperfil = nombreperfil;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	
}
