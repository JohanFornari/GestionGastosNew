 package com.gestiongastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.repository.CategoriaSubcategoriaRepositorio;

@Service
public class CategoriaSubcategoriaServiceImpl implements CategoriaSubcategoriaService{

	/*@Autowired
	private UsuarioService usuarioService;*/

	@Autowired
	private CategoriaSubcategoriaRepositorio categoriaSubcatRepository;

	@Override
	public CategoriaSubcategoria save(CategoriaSubcategoria categoriaSubcat){
		//Perfil perfil = new Perfil();
        return categoriaSubcatRepository.save(categoriaSubcat);
    }

}
