package com.gestiongastos.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.TipoIngreso;
import com.gestiongastos.services.TipoIngresoService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tipoingreso")
public class TipoIngresoController {

    @Autowired
	private TipoIngresoService tipoIngresoService;

    @PostMapping("/crearTipoIngreso")
	public TipoIngreso crearTipoIngreso(@RequestBody TipoIngreso tipoIngreso) 
    {
        return tipoIngresoService.crearTipoIngreso(tipoIngreso);
	}
    
    @GetMapping("/listarTipoIngreso")
	public List<TipoIngreso> ListarTipoIngreso() 
    {
        return tipoIngresoService.listarTipoIngreso();
	}
}
