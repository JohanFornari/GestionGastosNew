package com.gestiongastos.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingreso")
public class Ingreso implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idIngreso;
    private Date fecha;
    private Double valor;
    private String descripcion;

    @ManyToOne
	@JoinColumn(name = "tipo_ingreso")
    private TipoIngreso tipoIngreso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    
    public Ingreso() {
	}

	public Ingreso(UUID idIngreso, Date fecha, Double valor, String descripcion, TipoIngreso tipoIngreso,
			Usuario usuario) {
		this.idIngreso = idIngreso;
		this.fecha = fecha;
		this.valor = valor;
		this.descripcion = descripcion;
		this.tipoIngreso = tipoIngreso;
		this.usuario = usuario;
	}

	public UUID getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(UUID idGasto) {
        this.idIngreso = idGasto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoIngreso getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(TipoIngreso tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
