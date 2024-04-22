package com.gestiongastos.services;

import java.util.Optional;

import com.gestiongastos.models.Perfil;

public interface PerfilService {
    public Optional<Perfil> obtenerPerfilById(Integer id);
    public Perfil crearPerfil(Perfil perfil);
}
