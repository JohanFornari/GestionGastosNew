package com.gestiongastos.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.services.PerfilService;


@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    //Crear Perfil
    @PostMapping("")
    public Perfil crearPerfil(@RequestBody Perfil perfil) {
        return perfilService.crearPerfil(perfil);
    }

    //Listar Perfil
    @GetMapping("")
    public List<Perfil> getAllPerfil() {
        return perfilService.listarPerfil();
    }

    //Obtener Perfil por su ID
    @GetMapping("/{id}")
    public Optional<Perfil> obtenerPerfilById(@PathVariable int id) {
        return perfilService.obtenerPerfilById(id);
    }

    //Actualizar Perfil
    @PutMapping("/{id}")
    public Perfil actualizarPerfil(@PathVariable int id, @RequestBody Perfil perfil) {
    	perfil.setIdPerfil(id);
        return perfilService.actualizarPerfil(perfil);
    }

    //Eliminar Perfil por su ID
    @DeleteMapping("/{id}")
    public void eliminarPerfilById(@PathVariable int id) {
        perfilService.eliminarPerfilById(id);
    }
}
