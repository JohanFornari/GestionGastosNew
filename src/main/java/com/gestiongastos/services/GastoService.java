package com.gestiongastos.services;


import java.util.List;
import java.util.UUID;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.GastoDTO;

public interface GastoService {
    public Gasto save(Gasto gasto);
    public List<Categoria> getListCatxUsr(UUID documento);
    public List<CategoriaSubcategoria> findCategoriaSubCategoriasById(UUID idCategoria);
    public Gasto crearGasto(GastoDTO gastoDTO);
	public List<Gasto> listarGasto();
}
