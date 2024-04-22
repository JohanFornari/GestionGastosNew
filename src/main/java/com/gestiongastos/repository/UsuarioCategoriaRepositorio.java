package com.gestiongastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.models.UsuarioCategoriaPK;

@Repository
public interface UsuarioCategoriaRepositorio extends JpaRepository<UsuarioCategoria, UsuarioCategoriaPK> {

}
