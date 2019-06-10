package com.ceiba.induccion.domain.entity;

import java.util.Date;

public class Registry {
	private long id;
	private Vehicle vehicle;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Date fechaRegistro;

	public Registry() {
	}

	public Registry(long id, Vehicle vehicle, Date fechaEntrada, Date fechaSalida, Date fechaRegistro) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.fechaRegistro = fechaRegistro;
	}

	public Registry(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.fechaEntrada = new Date();
		this.fechaRegistro = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vehicle getVehiculo() {
		return vehicle;
	}

	public void setVehiculo(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
