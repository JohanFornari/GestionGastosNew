package com.gestiongastos;

import org.apache.velocity.app.Velocity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "src\\main\\resources\\templates");
        Velocity.init();
        System.out.println("Ruta de búsqueda de Velocity: " + Velocity.getProperty(Velocity.FILE_RESOURCE_LOADER_PATH));
		SpringApplication.run(Application.class, args);
	}
	
	   @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:3000")
	                .allowedMethods("*")
	                .allowedHeaders("*");
	            }
	        };
	    }

}
