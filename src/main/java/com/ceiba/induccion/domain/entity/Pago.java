package com.ceiba.induccion.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Pago {

	private long id;
	private Registro registro;
	private long valor;
	private String usuarioRegistro;
	private Date fechaRegistro;
}
