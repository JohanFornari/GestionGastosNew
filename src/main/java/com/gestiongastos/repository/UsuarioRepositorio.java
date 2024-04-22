package com.gestiongastos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {

}
