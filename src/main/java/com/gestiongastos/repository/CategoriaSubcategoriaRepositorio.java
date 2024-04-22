package com.gestiongastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.CategoriaSubcategoriaPK;

@Repository
public interface CategoriaSubcategoriaRepositorio extends JpaRepository<CategoriaSubcategoria, CategoriaSubcategoriaPK> {
   // List<Categoria> findByUserDocument(Long userDocument);
}
