package com.gestiongastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestiongastos.models.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

}
	