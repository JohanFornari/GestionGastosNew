package com.gestiongastos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.services.CategoriaServiceImpl;
import com.gestiongastos.services.UsuarioService;
import com.gestiongastos.services.UsuarioServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaServiceImpl categoriaService;
	@Autowired
	private UsuarioServiceImpl usuarioService;
	

	// Crear Categoria
	@PostMapping("/{id}")
	public Categoria crearCategoria(@RequestBody Categoria categoria,@PathVariable UUID id) {
		
		Categoria cat = categoriaService.crearCategoria(categoria);
		usuarioService.asociarCategoriaAUsuario(id, cat.getIdCategoria());
		return cat;
	}

	// Listar Categoria
	@GetMapping("")
	public List<Categoria> getAllcategoria() {
		return categoriaService.listarCategoria();
	}

	// Obtener Categoria por ID usuario
	@GetMapping("/{id}")
	public List<Categoria> obtenerCategoriaById(@PathVariable UUID id) {
		
		return categoriaService.getListCategoriaxUsuario(id);
	}
/*
	// Actualizar Categoria
	@PutMapping("/{id}")
	public Categoria actualizarCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
		categoria.setCodCategoria(id);
		return CategoriaService.actualizarCategoria(Categoria);
	}

	// Eliminar Categoria por su ID
	@DeleteMapping("/{id}")
	public void eliminarCategoriaById(@PathVariable int id) {
		CategoriaService.eliminarCategoriaById(id);
	}
	*/

}
