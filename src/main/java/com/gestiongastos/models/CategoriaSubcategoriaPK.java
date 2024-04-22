package com.gestiongastos.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CategoriaSubcategoriaPK implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_usuario")
    private UUID idUsuario;

    @Column(name = "id_categoria")
    private UUID idCategoria;

    @Column(name = "id_subcategoria")
    private UUID idSubcategoria;

	public UUID getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UUID getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(UUID idCategoria) {
		this.idCategoria = idCategoria;
	}

	public UUID getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(UUID idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}


}
