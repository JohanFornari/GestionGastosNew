package com.gestiongastos.models;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria_subcategoria")
public class CategoriaSubcategoria implements Serializable{

	private static final long serialVersionUID = 1L;

    public CategoriaSubcategoria(){

    }
    
    @EmbeddedId
    @JsonIgnore
    private CategoriaSubcategoriaPK id;

    @ManyToOne
    @JoinColumn(name = "id_subcategoria", insertable = false, updatable = false)
    private Subcategoria subcategoria;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_usuario",  referencedColumnName = "id_usuario",insertable = false, updatable = false),
        @JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria", insertable = false, updatable = false)
    })
    private UsuarioCategoria usuarioCategoria;

    
    public CategoriaSubcategoria(UsuarioCategoria usuario_categoria, Subcategoria subcategoria) {
        this.usuarioCategoria = usuario_categoria;
        this.subcategoria = subcategoria;
    }

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public CategoriaSubcategoriaPK getId() {
        return id;
    }

    public void setId(CategoriaSubcategoriaPK id) {
        this.id = id;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public UsuarioCategoria getUsuarioCategoria() {
        return usuarioCategoria;
    }

    public void setUsuarioCategoria(UsuarioCategoria usuarioCategoria) {
        this.usuarioCategoria = usuarioCategoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}