package com.gestiongastos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.UsuarioServiceImpl;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@PostMapping(value = "login")
	public Usuario verificarUsuario(@RequestBody Usuario user) {
		return usuarioService.verificarUsuario(user.getEmail(), user.getClave());

	}

}
