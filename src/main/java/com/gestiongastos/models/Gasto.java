package com.gestiongastos.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gasto")
public class Gasto implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idGasto;
    private Date fecha;
    private Double monto;
    private String descripcion;

    @ManyToOne
	@JoinColumn(name = "id_usuario")
    @JoinColumn(name = "id_categoria")
    @JoinColumn(name = "id_subcategoria")
    @JsonIgnore
    private CategoriaSubcategoria categoriaSubcategoria;

    public UUID getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(UUID idGasto) {
        this.idGasto = idGasto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaSubcategoria getCategoriaSubcategoria() {
        return categoriaSubcategoria;
    }

    public void setCategoriaSubcategoria(CategoriaSubcategoria categoriaSubcategoria) {
        this.categoriaSubcategoria = categoriaSubcategoria;
    }
}
