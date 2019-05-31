package com.ceiba.induccion.domain.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehiculo {

	private long id;
	private String placa;
	private TipoVehiculo tipoVehiculo;
	private long cilindraje;
	private String usuario;
	private Date fechaRegistro;
}
