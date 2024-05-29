package com.gestiongastos.models;

import java.util.List;

public class CrudModel {
 
    private String entidad;
    private List<Atributo> atributos;
    
	public CrudModel(String entidad, List<Atributo> atributos) {
		this.entidad = entidad;
		this.atributos = atributos;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public List<Atributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
    
 
}
