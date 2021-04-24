package com.nuevoProyecto.model;


import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Usuario extends IsEntityImpl {

	private String nombres;
	private String apellidos;
	private String login;
	private String password;
	private String email;
	private String telefono;
	private Date fechaCreacion;
	private Boolean logueo;
	
	public Usuario(){
		super();
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getLogueo() {
		return logueo;
	}

	public void setLogueo(Boolean logueo) {
		this.logueo = logueo;
	}
	
	
 
}
