package com.gestiongastos.services;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.gestiongastos.models.Ingreso;

public interface IngresoService {
    public Ingreso crearIngreso(UUID idUsuario,int idTipoIngreso, Double valor, Date fecha, String descripcion);
    
    public List<Ingreso> listarIngresos();
}
