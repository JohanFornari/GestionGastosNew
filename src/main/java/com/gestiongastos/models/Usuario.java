package com.gestiongastos.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUsuario;
	private Long documento;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String clave;
	private String direccion;

	@ManyToOne
	@JoinColumn(name = "perfil")
	private Perfil perfil;

	private String municipio;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Ingreso> ingresos;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<UsuarioCategoria> usuarioCategoria;

	public Usuario(UUID idUsuario, Long documento, String nombre, String apellido, String telefono, String email,
			String clave, String direccion, Perfil perfil, String municipio, List<Ingreso> ingresos,
			List<UsuarioCategoria> usuarioCategoria) {
		super();
		this.idUsuario = idUsuario;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.clave = clave;
		this.direccion = direccion;
		this.perfil = perfil;
		this.municipio = municipio;
		this.ingresos = ingresos;
		this.usuarioCategoria = usuarioCategoria;

	}

	public Usuario() {
		super();
	}

	public UUID getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public List<UsuarioCategoria> getUsuarioCategoria() {
		return usuarioCategoria;
	}

	public void setUsuarioCategoria(List<UsuarioCategoria> usuarioCategoria) {
		this.usuarioCategoria = usuarioCategoria;
	}

}
