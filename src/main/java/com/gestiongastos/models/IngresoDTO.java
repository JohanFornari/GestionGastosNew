package com.gestiongastos.models;

import java.sql.Date;
import java.util.UUID;

public class IngresoDTO {
    private UUID idUsuario;
    private int idTipoIngreso;
    private Double valor;
    private Date fecha;
    private String descripcion;
    
    public IngresoDTO() {
    }


    public UUID getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdTipoIngreso() {
        return idTipoIngreso;
    }

    public void setIdTipoIngreso(int idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
