package com.gestiongastos.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.IngresoDTO;
import com.gestiongastos.repository.IngresoRepositorio;
import com.gestiongastos.services.IngresoService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
	private IngresoService ingresoService;
    
    @Autowired
    private IngresoRepositorio servicioIngreso;

    @PostMapping("")
	public ResponseEntity<Ingreso> crearIngreso(@RequestBody IngresoDTO ingresoDTO) 
    {
        UUID id = ingresoDTO.getIdUsuario();
        int idTipoIngreso = ingresoDTO.getIdTipoIngreso();
        Double valor = ingresoDTO.getValor();
		ingresoService.crearIngreso(id,idTipoIngreso, valor,ingresoDTO.getFecha(),ingresoDTO.getDescripcion());
        return ResponseEntity.ok().build();
	}
    
    
	@GetMapping(value = "/{id}")
	public List<Ingreso> ObtenerIngresos(@PathVariable UUID id) {

		List<Ingreso> ingresos= servicioIngreso.findAll();
		List<Ingreso> ingresos_usuario = new ArrayList<Ingreso>();
		for (Ingreso ingreso : ingresos) {
			System.out.println( ingreso.getUsuario().getIdUsuario() + ":" + id );
			if (ingreso.getUsuario().getIdUsuario().toString().equals(id.toString())) {
				ingresos_usuario.add(ingreso);
			}
		}
		return ingresos_usuario;
	}
		
		
	@DeleteMapping(value = "/{id}")
	public void borrarIngreso(@PathVariable UUID id) {
		servicioIngreso.deleteById(id);
	}
}
