package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.gestiongastos.models.Categoria;

public interface CategoriaService {
    public Categoria crearCategoria(Categoria categoria);
	public Categoria getById(UUID id);
	public List<Categoria> listarCategoria();
	public List<Categoria> getListCategoriaxUsuario(UUID id);

}
