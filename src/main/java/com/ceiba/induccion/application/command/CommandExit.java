package com.ceiba.induccion.application.command;

import java.util.Date;

import com.ceiba.induccion.domain.entity.Registry;

public class CommandExit {
	private long id;
	private Registry registry;
	private double valor;
	private Date fechaRegistro;

	public CommandExit() {
		super();
	}

	public CommandExit(long id, Registry registry, double valor, Date fechaRegistro) {
		super();
		this.id = id;
		this.registry = registry;
		this.valor = valor;
		this.fechaRegistro = fechaRegistro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	

}
