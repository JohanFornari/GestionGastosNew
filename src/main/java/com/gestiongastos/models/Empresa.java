package com.gestiongastos.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codEmpresa;
    private String nombEmpresa;
   
    public UUID getCodEmpresa() {
        return codEmpresa;
    }
    public void setCodEmpresa(UUID codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
    public String getNombEmpresa() {
        return nombEmpresa;
    }
    public void setNombEmpresa(String nombEmpresa) {
        this.nombEmpresa = nombEmpresa;
    }
}
