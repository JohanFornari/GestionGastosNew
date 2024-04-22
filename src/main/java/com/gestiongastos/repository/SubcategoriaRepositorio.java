package com.gestiongastos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.Subcategoria;

@Repository
public interface SubcategoriaRepositorio extends JpaRepository<Subcategoria, UUID> {
   // List<Categoria> findByUserDocument(Long userDocument);
}
