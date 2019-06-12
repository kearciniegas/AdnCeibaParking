package com.ceiba.induccion.domain.entity;

import java.util.Date;

public class Registry {
	private long id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String placa;
	private VehicleType vehicleType;
	private long cilindraje;

	public Registry(long id, Date fechaEntrada, Date fechaSalida, String placa, VehicleType vehicleType,
			long cilindraje) {
		super();
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.placa = placa;
		this.vehicleType = vehicleType;
		this.cilindraje = cilindraje;

	}

	public Registry() {

	}

	public Registry(String placa, VehicleType vehicleType, long cilindraje) {
		this.placa = placa;
		this.vehicleType = vehicleType;
		this.cilindraje = cilindraje;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}

}
