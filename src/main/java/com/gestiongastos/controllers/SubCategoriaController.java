package com.gestiongastos.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.CategoriaSubcategoriaPK;
import com.gestiongastos.models.Subcategoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.models.UsuarioCategoriaPK;
import com.gestiongastos.repository.CategoriaSubcategoriaRepositorio;
import com.gestiongastos.services.CategoriaServiceImpl;
import com.gestiongastos.services.CategoriaSubcategoriaServiceImpl;
import com.gestiongastos.services.SubcategoriaServiceImpl;
import com.gestiongastos.services.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/subcategoria")
public class SubCategoriaController {

	@Autowired
	private SubcategoriaServiceImpl subcategoriaService;
	
	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	
	@Autowired 
	private CategoriaSubcategoriaServiceImpl categoriaSubcategoriaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CategoriaSubcategoriaRepositorio cat;
	
	
	
	// Crear Categoria
	@PostMapping("")
	public Subcategoria crearCategoria(@RequestBody Subcategoria categoria) {
		return subcategoriaService.crearCategoria(categoria);
	}

	// Listar Categoria
	@GetMapping("")
	public List<Subcategoria> getAllcategoria() {
		return subcategoriaService.listarCategoria();
	}

	// Obtener Categorias por ID usuario
	
	@GetMapping("/{id}")
	public List<Subcategoria> obtenerCategoriaById(@PathVariable UUID id) {
		
		List<Subcategoria> lista = new ArrayList<>();
		
		List<CategoriaSubcategoria> listaca = cat.findAll();
		
		for (CategoriaSubcategoria u : listaca) {

			if (u.getUsuarioCategoria().getUsuario().getIdUsuario().equals(id)) {
				lista.add(u.getSubcategoria());
			}
			
		}
	
		return lista;
	}
	
	
	
	@PostMapping("/asociarsubcategoria")
	public Subcategoria asociarCategoriaASubcategoria(@RequestBody Subcategoria subcategoria,@RequestParam(name="idUsuario", required=true)UUID idUsuario,@RequestParam(name="idCategoria", required=true)UUID idCategoria) {
		
		Usuario usuario = usuarioService.getById(idUsuario) ;
		Categoria categoria = categoriaService.getById(idCategoria);
		Subcategoria subcategori = subcategoriaService.crearCategoria(subcategoria);

		UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
		usuarioCatPK.setIdUsuario(idUsuario);
		usuarioCatPK.setIdCategoria(idCategoria);
		UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
		usuarioCategoria.setId(usuarioCatPK);
     
		CategoriaSubcategoriaPK categoriaSubcatPk = new CategoriaSubcategoriaPK();
		categoriaSubcatPk.setIdUsuario(idUsuario);
		categoriaSubcatPk.setIdCategoria(idCategoria);
		categoriaSubcatPk.setIdSubcategoria(subcategori.getIdSubcategoria());
		
        CategoriaSubcategoria categoriaSubcategoria = new CategoriaSubcategoria(usuarioCategoria, subcategori);
        categoriaSubcategoria.setId(categoriaSubcatPk);
		
        categoriaSubcategoriaService.save(categoriaSubcategoria);
       
        return subcategori;
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
