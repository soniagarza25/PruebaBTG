package com.nuevoProyecto.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Realiza implementación de IsEntity para que otras clases puedan heredar su implementación
 *
 * @author Paulo Cifuentes
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class IsEntityImpl implements IsEntity {

	protected Long id;

	public IsEntityImpl() {
		//
	}

	public IsEntityImpl(Long id) {
		this.id = id;
	}

	@Id @GeneratedValue
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
