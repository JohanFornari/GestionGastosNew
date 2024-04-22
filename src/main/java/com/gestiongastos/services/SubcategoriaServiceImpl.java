 package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.Subcategoria;
import com.gestiongastos.repository.CategoriaRepositorio;
import com.gestiongastos.repository.SubcategoriaRepositorio;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService{

	@Autowired
	private SubcategoriaRepositorio subcategoriaRepository;


	@Override
	public Subcategoria crearCategoria(Subcategoria categoria){
        return subcategoriaRepository.save(categoria);
    }

	@Override
	public Subcategoria getById(UUID id) {
		return subcategoriaRepository.findById(id).get();
	}

	@Override
	public List<Subcategoria> listarCategoria() {
		return subcategoriaRepository.findAll();
	}

}
