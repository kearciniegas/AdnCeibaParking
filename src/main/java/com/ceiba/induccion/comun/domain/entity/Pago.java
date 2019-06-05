package com.ceiba.induccion.comun.domain.entity;

import java.util.Date;

public class Pago {

	private long id;
	private Registro registro;
	private double valor;
	private Date fechaRegistro;

	public Pago() {
		super();
	}

	public Pago(long id, double valor, Registro registro, Date fechaRegistro) {
		super();
		this.id = id;
		this.valor = valor;
		this.registro = registro;
		this.fechaRegistro = fechaRegistro;
	}

	public Pago(double valor, Registro registro) {
		this.valor = valor;
		this.registro = registro;
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

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
