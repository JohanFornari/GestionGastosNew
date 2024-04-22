package com.gestiongastos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.Ingreso;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, UUID>{

}