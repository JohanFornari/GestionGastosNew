package com.gestiongastos.models;

import java.util.UUID;

public class RequestBodyCategoria {
    private UUID idUsuario;
    private UUID[] idsCAtegorias;
    

    public UUID getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}
	public UUID[] getIdsCAtegorias() {
        return idsCAtegorias;
    }
    public void setIdsCAtegorias(UUID[] idsCAtegorias) {
        this.idsCAtegorias = idsCAtegorias;
    }
}
