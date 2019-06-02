package com.ceiba.induccion.domain.entity;

import java.util.Date;

public class Registro {
	private long id;
	private Vehiculo vehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String usuario;
	private Date fechaRegistro;

	public Registro() {
		super();
	}

	public Registro(long id, Vehiculo vehiculo, Date fechaEntrada, Date fechaSalida, String usuario,
			Date fechaRegistro) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.usuario = usuario;
		this.fechaRegistro = fechaRegistro;
	}

	public Registro(Vehiculo vehiculo, String usuario) {
		this.vehiculo = vehiculo;
		this.usuario = usuario;
		this.fechaEntrada = new Date();
		this.fechaRegistro = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
