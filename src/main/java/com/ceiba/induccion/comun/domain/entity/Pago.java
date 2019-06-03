package com.ceiba.induccion.comun.domain.entity;

import java.util.Date;


public class Pago {

	private long id;
	private Registro registro;
	private long valor;
	private String usuarioRegistro;
	private Date fechaRegistro;

	public Pago() {
		super();
	}

	public Pago(long id, long valor, Registro registro, String usuarioRegistro, Date fechaRegistro) {
		super();
		this.id = id;
		this.valor = valor;
		this.registro = registro;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}

	public Pago(long valor, Registro registro, String usuarioRegistro) {
		this.valor = valor;
		this.registro = registro;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
