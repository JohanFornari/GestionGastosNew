package com.gestiongastos.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.UsuarioService;
import com.gestiongastos.services.UsuarioServiceImpl;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		usuario.setNombre(usuario.getNombre());
		usuario.setApellido(usuario.getApellido());
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
		String hash = argon2.hash(10, 65536, 1, usuario.getClave());
		//usuario.setDocumento(usuario.getDocumento());
		usuario.setClave(hash);
		usuario.setTelefono(usuario.getTelefono());
		return usuarioService.save(usuario);
	}
	/*@PostMapping("/asociar-categoria")
	public ResponseEntity<Void> AsociarCategoriaAUsuario(@RequestBody RequestBodyCategoria requestBodyCat) {
		Long id = requestBodyCat.getDocumento();
		UUID[] idsCategorias = requestBodyCat.getIdsCAtegorias();
		usuarioService.AsociarCategoriasAUsuario(requestBodyCat);		
		return ResponseEntity.ok().build();
	}*/
	@PostMapping("/asociar-categoria")
	public ResponseEntity<Void> asociarCategoriaAUsuario(@RequestBody Map<String, UUID> requestBody,@RequestParam(name="id_usuario", required=true)UUID idUsuario) {
		UUID id = idUsuario;
        UUID idCategoria = requestBody.get("idCategoria");
		usuarioService.asociarCategoriaAUsuario(id, idCategoria);		
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{idUsuario}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable UUID idUsuario) {
		try {
			Usuario usuario = usuarioService.getById(idUsuario);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/listarusuarios")
	public List<Usuario> getUsuarios() {

		return usuarioService.listarUsuarios();
	}

	
	@DeleteMapping(value = "/{idUsuario}")
	public void borrarUsuario(@PathVariable UUID idUsuario) {
		System.out.println(idUsuario);
		usuarioService.eliminarUsuarioById(idUsuario);
	}
	
    //Actualizar Usuario
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
    	usuario.setIdUsuario(id);
        return usuarioService.actualizarUsuario(usuario, id);
    }
    
    
    @GetMapping(value = "listarsubcategorias/{id}")
	public List<Map<String, Object>> ListarSubcategoriasporUsuario(@PathVariable UUID id) {
		return usuarioService.obtenerSubcategoriasCategoriasPorUsuario(id);
	}
    
    @GetMapping(value = "listargastos/{id}")
	public List<Map<String, Object>> ListarGastosPorUsuario(@PathVariable UUID id) {
		return usuarioService.obtenerGastosPorUsuario(id);
	}
    
    @GetMapping(value = "ingresos/{id}")
	public List<Ingreso> ListarIngresosPorUsuario(@PathVariable UUID id) {
		return usuarioService.obtenerIngresosPorUsuario(id);
	}
    
    @GetMapping(value = "reporte/{id}")
	public List<Object[]> generarInformeMensual(@PathVariable UUID id) {
		return usuarioService.generarInformeMensual(id);
	}

}

