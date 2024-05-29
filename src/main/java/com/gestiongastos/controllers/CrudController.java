package com.gestiongastos.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.logic.CrudGenerator;
import com.gestiongastos.models.CrudModel;


@RestController
@RequestMapping("/api/crudgenerator")
public class CrudController {

    @PostMapping
    public CrudModel generate(@RequestBody CrudModel entidad) {
       
    	CrudGenerator gcrud = new CrudGenerator();
    	gcrud.generateModel(entidad);
    	gcrud.generateRepository(entidad.getEntidad());
    	gcrud.generateService(entidad.getEntidad());
    	gcrud.generateController(entidad.getEntidad());
		
    	return entidad;
    }
}	
	
	

