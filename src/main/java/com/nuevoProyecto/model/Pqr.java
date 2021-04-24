package com.nuevoProyecto.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Pqr extends IsEntityImpl {

	private String tipoDeSolicitud;
	private Date fechaCreacion;
	private String respuestaDeCaso;
	private String descripcionDelCaso;
	private Usuario cliente;
	private AceptacionPqr aceptacion;
	
	public Pqr () {
		super();
	}


	public String getTipoDeSolicitud() {
		return tipoDeSolicitud;
	}

	public void setTipoDeSolicitud(String tipoDeSolicitud) {
		this.tipoDeSolicitud = tipoDeSolicitud;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getRespuestaDeCaso() {
		return respuestaDeCaso;
	}

	public void setRespuestaDeCaso(String respuestaDeCaso) {
		this.respuestaDeCaso = respuestaDeCaso;
	}

	public String getDescripcionDelCaso() {
		return descripcionDelCaso;
	}

	public void setDescripcionDelCaso(String descripcionDelCaso) {
		this.descripcionDelCaso = descripcionDelCaso;
	}

	@OneToMany
	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@OneToOne
	public AceptacionPqr getAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(AceptacionPqr aceptacion) {
		this.aceptacion = aceptacion;
	}
	
}
