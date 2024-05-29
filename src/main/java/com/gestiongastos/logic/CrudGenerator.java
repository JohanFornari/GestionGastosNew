package com.gestiongastos.logic;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.gestiongastos.models.Atributo;
import com.gestiongastos.models.CrudModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class CrudGenerator {

    private static final String PAQUETE_PRINCIPAL = "com.gestiongastos";
    private static final String CARPETA_BASE = "src\\main\\java\\com\\gestiongastos";
    
	
    public void generateModel(CrudModel entity) {
    	// Lista de librerías básicas para el modelo
        List<String> libreriasBasicas = new ArrayList<>();
        libreriasBasicas.add("jakarta.persistence.Entity");
        libreriasBasicas.add("jakarta.persistence.GeneratedValue");
        libreriasBasicas.add("jakarta.persistence.GenerationType");
        libreriasBasicas.add("jakarta.persistence.Id");

        // Nombre del paquete
        String paquete = PAQUETE_PRINCIPAL + ".models";

        // Generación de archivos para la entidad
        generateModel(paquete, entity.getEntidad(), entity.getAtributos(), libreriasBasicas);
        // Otros métodos de generación...
    }
    
    public void generateRepository(String entidad) {

        List<String> libreriasBasicas = new ArrayList<>();
        libreriasBasicas.add("org.springframework.data.jpa.repository.JpaRepository");
        libreriasBasicas.add("org.springframework.stereotype.Repository");
        libreriasBasicas.add(PAQUETE_PRINCIPAL+".models."+entidad);
        
        String paquete = PAQUETE_PRINCIPAL +".repository";
        
        generateRepository(paquete, entidad , libreriasBasicas);
    }
    
    
    public void generateService(String entidad) { 	

        List<String> libreriasBasicas = new ArrayList<>();
        libreriasBasicas.add("java.util.List");
        libreriasBasicas.add("java.util.Optional");
        libreriasBasicas.add("org.springframework.beans.factory.annotation.Autowired");
        libreriasBasicas.add("org.springframework.stereotype.Service");
        libreriasBasicas.add(PAQUETE_PRINCIPAL+".models."+entidad);
        libreriasBasicas.add(PAQUETE_PRINCIPAL+".repository."+entidad+"Repository");
        
        String paquete = PAQUETE_PRINCIPAL +".services";
        
        generateService(paquete, entidad , libreriasBasicas);
        
    }
    
    public void generateController(String entidad) { 	

        List<String> libreriasBasicas = new ArrayList<>();
        libreriasBasicas.add("java.util.List");
        libreriasBasicas.add("java.util.Optional");
        libreriasBasicas.add("org.springframework.beans.factory.annotation.Autowired");
        libreriasBasicas.add("org.springframework.web.bind.annotation.RestController");
        libreriasBasicas.add("org.springframework.web.bind.annotation.RequestMapping");
        libreriasBasicas.add("org.springframework.web.bind.annotation.PostMapping");
        libreriasBasicas.add("org.springframework.web.bind.annotation.RequestBody");
        libreriasBasicas.add("org.springframework.web.bind.annotation.GetMapping");
        libreriasBasicas.add("org.springframework.web.bind.annotation.PathVariable");
        libreriasBasicas.add("org.springframework.web.bind.annotation.PutMapping");
        libreriasBasicas.add("org.springframework.web.bind.annotation.DeleteMapping");
        libreriasBasicas.add(PAQUETE_PRINCIPAL+".models."+entidad);
        libreriasBasicas.add(PAQUETE_PRINCIPAL+".services."+entidad+"Service");
        
        String paquete = PAQUETE_PRINCIPAL +".controllers";
        
        generateController(paquete, entidad , libreriasBasicas);
        
    }

    public void generateModel(String paquete,String entidad, List<Atributo> atributos, List<String> libreriasBasicas) {
        try {

            // Configuración de la plantilla
            VelocityContext contexto = new VelocityContext();
            contexto.put("paquete", paquete);
            contexto.put("entidad", entidad);
            contexto.put("atributos", atributos);
            contexto.put("libreriasBasicas", libreriasBasicas); // Pasamos la lista de librerías

            // Cargar la plantilla
            Template plantilla = Velocity.getTemplate("Model.vm");

            // Procesar la plantilla
            StringWriter escritor = new StringWriter();
            plantilla.merge(contexto, escritor);

            // Escribir el resultado en un archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(CARPETA_BASE + "\\models\\"+entidad + ".java"));
            writer.write(escritor.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void generateRepository(String paquete,String entidad, List<String> libreriasBasicas) {
        try {

            // Configuración de la plantilla
            VelocityContext contexto = new VelocityContext();
            contexto.put("paquete", paquete);
            contexto.put("entidad", entidad);
            contexto.put("libreriasBasicas", libreriasBasicas); 

            // Cargar la plantilla
            Template plantilla = Velocity.getTemplate("Repository.vm");

            // Procesar la plantilla
            StringWriter escritor = new StringWriter();
            plantilla.merge(contexto, escritor);

            // Escribir el resultado en un archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(CARPETA_BASE +"\\repository\\"+entidad + "Repository.java"));
            writer.write(escritor.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void generateService(String paquete,String entidad, List<String> libreriasBasicas) {
        try {

            // Configuración de la plantilla
            VelocityContext contexto = new VelocityContext();
            contexto.put("paquete", paquete);
            contexto.put("entidad", entidad);
            contexto.put("libreriasBasicas", libreriasBasicas); 

            // Cargar la plantilla
            Template plantilla = Velocity.getTemplate("Service.vm");

            // Procesar la plantilla
            StringWriter escritor = new StringWriter();
            plantilla.merge(contexto, escritor);

            // Escribir el resultado en un archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(CARPETA_BASE +"\\services\\"+entidad + "Service.java"));
            writer.write(escritor.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void generateController(String paquete,String entidad, List<String> libreriasBasicas) {
        try {

            // Configuración de la plantilla
            VelocityContext contexto = new VelocityContext();
            contexto.put("paquete", paquete);
            contexto.put("entidad", entidad);
            contexto.put("libreriasBasicas", libreriasBasicas); 

            // Cargar la plantilla
            Template plantilla = Velocity.getTemplate("Controller.vm");

            // Procesar la plantilla
            StringWriter escritor = new StringWriter();
            plantilla.merge(contexto, escritor);

            // Escribir el resultado en un archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(CARPETA_BASE +"\\controllers\\"+entidad + "Controller.java"));
            writer.write(escritor.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}


