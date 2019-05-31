package com.ceiba.induccion.domain.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pago {

	private long id;
	private Registro registro;
	private long valor;
	private String usuarioRegistro;
	private Date fechaRegistro;

	public Pago(long id, Registro registro, long valor, String usuarioRegistro, Date fechaRegistro) {
		super();
		this.id = id;
		this.registro = registro;
		this.valor = valor;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}

}
