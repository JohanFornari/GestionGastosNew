 package com.gestiongastos.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.models.UsuarioCategoriaPK;
import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.CategoriaSubcategoriaPK;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.RequestBodyModel;
import com.gestiongastos.models.Subcategoria;
import com.gestiongastos.repository.UsuarioRepositorio;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepositorio usuarioRepository;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private SubcategoriaService subcategoriaService;

	public Usuario save(Usuario usuario){
		Perfil perfil = new Perfil();
		System.out.println("perfil : " + usuario.getPerfil().getCodperfil());
		perfil = perfilService.obtenerPerfilById(usuario.getPerfil().getCodperfil()).get();
		usuario.setPerfil(perfil);
        return usuarioRepository.save(usuario);
    }

	@Override
	public Usuario getById(UUID id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void asociarCategoriaAUsuario(UUID idUsuario, UUID idCategoria) {
		Usuario 	usuario 	= getById(idUsuario);
		Categoria 	categoria 	= categoriaService.getById(idCategoria);

		UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
		usuarioCatPK.setIdUsuario(idUsuario);
		usuarioCatPK.setIdCategoria(idCategoria);
		UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
		usuarioCategoria.setId(usuarioCatPK);
		usuario.getUsuarioCategoria().add(usuarioCategoria);
        usuarioRepository.save(usuario);
	}

	@Override
	public void asociarSubategoriaAUsuario(@RequestBody RequestBodyModel requestBody) {
		
	}

	@Override 
	public void asociarCategoriaSubcatAUsuario(@RequestBody RequestBodyModel requestBody){//(Long idUsuario, UUID idCategoria, UUID idSubcategoria) {
		UUID idCategoria 	= requestBody.getIdCAtegoria();
        UUID[] idsSubcategorias 		= requestBody.getIdSubcategorias();
        UUID idUsuario 		= requestBody.getIdUsuario(); 
		//Asociar usuario-categoria
		Usuario 		usuario 		= getById(idUsuario);
		Categoria 		categoria 		= categoriaService.getById(idCategoria);
		UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
		usuarioCatPK.setIdUsuario(idUsuario);
		usuarioCatPK.setIdCategoria(idCategoria);
		UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
		usuarioCategoria.setId(usuarioCatPK);
		usuario.getUsuarioCategoria().add(usuarioCategoria);
		usuarioRepository.save(usuario);
		
		//por cada idsubcategoria traer la subcat
		List<CategoriaSubcategoria> listCategSubcat = new LinkedList<>();
		Usuario usr = getById(idUsuario);
		for(int i=0; i<idsSubcategorias.length; i++){
			CategoriaSubcategoria catsubcat = new CategoriaSubcategoria();
			Subcategoria subcategoria 	= subcategoriaService.getById(idsSubcategorias[i]);
			//Crear asociación con subcategoria
			CategoriaSubcategoriaPK catSubcatPK = new CategoriaSubcategoriaPK();
			catSubcatPK.setIdUsuario(idUsuario);
			catSubcatPK.setIdCategoria(idCategoria);
			catSubcatPK.setIdSubcategoria(idsSubcategorias[i]);
			catsubcat.setId(catSubcatPK);
			catsubcat.setUsuarioCategoria(usuarioCategoria);
			catsubcat.setSubcategoria(subcategoria);	
			listCategSubcat.add(catsubcat);		
		}
		usuarioCategoria.setCategoriaSubcategoria(listCategSubcat);
		//update usuarioCategoria
	}

	
	@Override
	public void asociarCategoriasAUsuario(RequestBodyCategoria reqBody) {
		Usuario 	usuario 	= getById(reqBody.getIdUsuario());
		List<UsuarioCategoria> lstUsuarioCategoria = new LinkedList<>();
		UUID[] idCategorias = reqBody.getIdsCAtegorias();
		//Se busca cada categoría
		for(int i=0; i<idCategorias.length;i++){
			Categoria 	categoria 	= categoriaService.getById(idCategorias[i]);
			UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
			usuarioCatPK.setIdUsuario(reqBody.getIdUsuario());
			usuarioCatPK.setIdCategoria(idCategorias[i]);
			UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
			usuarioCategoria.setId(usuarioCatPK);
			lstUsuarioCategoria.add(usuarioCategoria);
		}
		usuario.getUsuarioCategoria().addAll(lstUsuarioCategoria);
        usuarioRepository.save(usuario);
	}
	
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
    // Eliminar Usuario por su ID
	@Override
    public void eliminarUsuarioById(UUID id) {
        usuarioRepository.deleteById(id);
    }

	@Override
	public Usuario verificarUsuario(String correo, String password) {
		List<Usuario> usuarios = listarUsuarios();
		if (!correo.isEmpty() && !password.isEmpty()) {
			for (Usuario u : usuarios) {
				if (u.getEmail().equals(correo)) {
					Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);

					if (argon2.verify(u.getClave(), password)) {
						return u;
					}
				}
			}
		}
		return null;
	}
	
    // Actualizar Usuario
    public Usuario actualizarUsuario(Usuario usuario, @PathVariable UUID id) {
    	Usuario personaExistente = getById(id);

		if (!usuario.getDireccion().equals(personaExistente.getDireccion())) {
			personaExistente.setDireccion(usuario.getDireccion());
		}
		if (!usuario.getTelefono().equals(personaExistente.getTelefono())) {
			personaExistente.setTelefono(usuario.getTelefono());
		}

		save(personaExistente);
		return personaExistente;
    }

	
	
}
