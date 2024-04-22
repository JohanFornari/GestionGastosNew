package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gestiongastos.models.TipoIngreso;

public interface TipoIngresoService {
    public Optional<TipoIngreso> getById(int id);
    public TipoIngreso crearTipoIngreso(TipoIngreso tipoIngreso);
    public List<TipoIngreso> listarTipoIngreso();
}
