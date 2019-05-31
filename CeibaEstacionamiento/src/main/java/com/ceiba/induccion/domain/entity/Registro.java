package com.ceiba.induccion.domain.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Registro {

	private long id;
	private Vehiculo vehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Date fechaRegistro;

	public Registro(long id, Vehiculo vehiculo, Date fechaEntrada, Date fechaSalida, Date fechaRegistro) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.fechaRegistro = fechaRegistro;
	}
}
