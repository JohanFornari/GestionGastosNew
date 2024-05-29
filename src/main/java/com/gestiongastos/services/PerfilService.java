package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.repository.PerfilRepository;

@Service
public class PerfilService {
	
    @Autowired
    private PerfilRepository perfilRepository;

    // Crear Perfil
    public Perfil crearPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Listar Perfil
    public List<Perfil> listarPerfil() {
        return perfilRepository.findAll();
    }

    // Obtener Perfil por su ID
    public Optional<Perfil> obtenerPerfilById(int id) {
        return perfilRepository.findById(id);
    }

    // Actualizar Perfil
    public Perfil actualizarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Eliminar Perfil por su ID
    public void eliminarPerfilById(int id) {
        perfilRepository.deleteById(id);
    }
}