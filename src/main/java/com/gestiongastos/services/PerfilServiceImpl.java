package com.gestiongastos.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestiongastos.models.Perfil;
import com.gestiongastos.repository.PerfilRepositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
    private PerfilRepositorio perfilRepository;

    // Crear Perfil
    public Perfil crearPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Listar Perfil
    public List<Perfil> listarPerfil() {
        return perfilRepository.findAll();
    }

    // Actualizar Perfil
    public Perfil actualizarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Eliminar Perfil por su ID
    public void eliminarPerfilById(int id) {
        perfilRepository.deleteById(id);
    }

	@Override
	public Optional<Perfil> obtenerPerfilById(Integer id) {
		return perfilRepository.findById(id);
	}
}
