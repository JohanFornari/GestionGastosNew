package com.gestiongastos.models;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_categoria")
public class UsuarioCategoria implements Serializable{

	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UsuarioCategoriaPK id;

    public UsuarioCategoria() {
        // Constructor por defecto necesario para que Hibernate pueda instanciar la clase
    }

    public UsuarioCategoria(Usuario usuario, Categoria categoria) {
        this.usuario = usuario;
        this.categoria = categoria;
    }
    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "usuarioCategoria", cascade = CascadeType.ALL)
	private List<CategoriaSubcategoria> categoriaSubcategoria;

    public UsuarioCategoriaPK getId() {
        return id;
    }
    public void setId(UsuarioCategoriaPK id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<CategoriaSubcategoria> getCategoriaSubcategoria() {
        return categoriaSubcategoria;
    }

    public void setCategoriaSubcategoria(List<CategoriaSubcategoria> categoriaSubcategoria) {
        this.categoriaSubcategoria = categoriaSubcategoria;
    }    
}