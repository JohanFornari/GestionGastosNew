package com.gestiongastos.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_ingreso")
public class TipoIngreso implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipoIngreso;
    private String nombTipoIngreso;

    public int getIdTipoIngreso() {
        return idTipoIngreso;
    }
    public void setIdTipoIngreso(int idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }
    public String getNombTipoIngreso() {
        return nombTipoIngreso;
    }
    public void setNombTipoIngreso(String nombTipoIngreso) {
        this.nombTipoIngreso = nombTipoIngreso;
    }    
}
