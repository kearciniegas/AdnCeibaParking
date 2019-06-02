package com.ceiba.induccion.domain.entity;

import java.util.Date;

import lombok.Data;


@Data
public class Registro {

	private long id;
	private Vehiculo vehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Date fechaRegistro;
}
