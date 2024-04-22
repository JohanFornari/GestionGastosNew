package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.Subcategoria;

public interface SubcategoriaService {

	public Subcategoria crearCategoria(Subcategoria categoria);
	public Subcategoria getById(UUID id);
	public List<Subcategoria> listarCategoria();

}
