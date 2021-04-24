package com.nuevoProyecto.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AceptacionPqr extends IsEntityImpl {

	private Pqr pqr;
	private Date fechaAceptacion;
	private String aceptacionCliente;
	
	public AceptacionPqr () {
		super();
	}

	@OneToOne
	public Pqr getPqr() {
		return pqr;
	}

	public void setPqr(Pqr pqr) {
		this.pqr = pqr;
	}

	public String getAceptacionCliente() {
		return aceptacionCliente;
	}

	public void setAceptacionCliente(String aceptacionCliente) {
		this.aceptacionCliente = aceptacionCliente;
	}

	public Date getFechaAceptacion() {
		return fechaAceptacion;
	}

	public void setFechaAceptacion(Date fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}
	
}
