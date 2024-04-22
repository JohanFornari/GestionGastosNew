 package com.gestiongastos.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.repository.CategoriaRepositorio;
import com.gestiongastos.repository.UsuarioCategoriaRepositorio;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	/*@Autowired
	private UsuarioService usuarioService;*/

	@Autowired
	private CategoriaRepositorio categoriaRepository;
	
	@Autowired
	private UsuarioCategoriaRepositorio usuarioCategoriaRepository;

	@Override
	public Categoria crearCategoria(Categoria categoria){
		
        return categoriaRepository.save(categoria);
    }

	@Override
	public Categoria getById(UUID id) {
		return categoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> listarCategoria() {
		return categoriaRepository.findAll();
	}

	@Override
	public List<Categoria> getListCategoriaxUsuario(UUID id) {
		List<UsuarioCategoria>  categoriaUsuario = usuarioCategoriaRepository.findAll();
		
		List<Categoria> categorias = new ArrayList<>();
		
		for (UsuarioCategoria u : categoriaUsuario) {
			if(u.getUsuario().getIdUsuario().equals(id)) {
			categorias.add(u.getCategoria());
			}
		}
		
		return categorias;
	}
	

	/*public void guardarUsuario(Usuario usuario) {
		UsuarioAdministrador usuario_especifico;
		usuario_especifico = new UsuarioAdministrador(usuario);
		if (usuario_especifico.actualizarUsuario(usuario)) {
			usuarioRepository.save(usuario);
		}

	}

	public List<Usuario> listarUsuarios() {

		List<Usuario> usuarios = usuarioRepository.findAll();
		// UsuarioAdministrador usuario_especifico = new UsuarioAdministrador();

		return usuarios;
	}

	public Usuario obtenerUsuario(Integer id) {

		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public boolean verificarUsuario(String correo, String password) {

		if (UsuarioAbstract.verificarUsuario(listarUsuarios(), correo, password)) {
			return true;
		}

		return false;

	}*/

}
