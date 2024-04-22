package com.gestiongastos.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="subcategoria")
public class Subcategoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSubcategoria;
    private String nombSubcategoria;
    private String descripcion;


    public UUID getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(UUID idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public String getNombSubcategoria() {
        return nombSubcategoria;
    }
    public void setNombSubcategoria(String nombSubcategoria) {
        this.nombSubcategoria = nombSubcategoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
