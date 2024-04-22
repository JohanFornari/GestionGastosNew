package com.gestiongastos.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiongastos.models.TipoIngreso;

@Repository
public interface TipoIngresoRepositorio extends JpaRepository<TipoIngreso, Integer>{
    
}
