package com.gestiongastos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.Gasto;

@Repository
public interface GastoRepositorio extends JpaRepository<Gasto, UUID>{

    @Query("SELECT cs FROM CategoriaSubcategoria cs WHERE cs.id.idCategoria = :idCategoria")
    List<CategoriaSubcategoria> findCategoriaSubCategoriasById(UUID idCategoria);
}