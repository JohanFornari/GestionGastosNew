package com.gestiongastos.services;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.TipoIngreso;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.repository.IngresoRepositorio;

@Service
public class IngresoServiceImpl implements IngresoService{
	
    @Autowired
	private IngresoRepositorio ingresoRepository;

    @Autowired
	private UsuarioService usuarioService;

    @Autowired
	private TipoIngresoService tipoIngresoService;

    @Override
    public Ingreso crearIngreso(UUID idUsuario, int idTipoIngreso, Double valor,Date fecha,String descripcion) {
        Usuario 	usuario 	    = usuarioService.getById(idUsuario);
		TipoIngreso	tipoIngreso 	= tipoIngresoService.getById(idTipoIngreso).get();
		Ingreso ingreso = new Ingreso();
        ingreso.setFecha(fecha);
        ingreso.setUsuario(usuario);
		ingreso.setTipoIngreso(tipoIngreso);
        ingreso.setValor(valor);
        ingreso.setDescripcion(descripcion);
        return ingresoRepository.save(ingreso);
    }

	@Override
	public List<Ingreso> listarIngresos() {
		
		return ingresoRepository.findAll();
	}
    
    
    

}
