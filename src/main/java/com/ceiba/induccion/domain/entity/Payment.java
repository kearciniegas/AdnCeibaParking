package com.ceiba.induccion.domain.entity;

import java.util.Date;


public class Payment {

	private long id;
	private Registry registry;
	private double valor;
	private Date fechaRegistro;

	public Payment() {
		super();
	}

	public Payment(long id, double valor, Registry registry, Date fechaRegistro) {
		super();
		this.id = id;
		this.valor = valor;
		this.registry = registry;
		this.fechaRegistro = fechaRegistro;
	}

	public Payment(double valor, Registry registry) {
		this.valor = valor;
		this.registry = registry;
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

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistro(Registry registry) {
		this.registry = registry;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
