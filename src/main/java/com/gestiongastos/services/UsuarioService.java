package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.RequestBodyModel;
import com.gestiongastos.models.Usuario;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    
	public Usuario getById(UUID id);

    public List<Usuario> listarUsuarios();

    public void asociarCategoriasAUsuario(RequestBodyCategoria reqBody);

    public void asociarCategoriaSubcatAUsuario(RequestBodyModel requestBody);

    public void asociarCategoriaAUsuario(UUID idUsuario, UUID idCategoria);

    public void asociarSubategoriaAUsuario(RequestBodyModel request);
    
    public void eliminarUsuarioById(UUID id);
    
    public Usuario verificarUsuario(String correo, String password);
    
    public Usuario actualizarUsuario(Usuario usuario,@PathVariable UUID id);

}
