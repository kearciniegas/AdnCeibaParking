package com.ceiba.induccion.domain.entity;

import java.util.Date;

public class Vehicle {

	private long id;
	private String placa;
	private VehicleType vehicleType;
	private long cilindraje;
	private Date fechaRegistro;

	public Vehicle() {
		super();
	}

	public Vehicle(long id, String placa, VehicleType vehicleType, long cilindraje, Date fechaRegistro) {

		this.id = id;
		this.placa = placa;
		this.vehicleType = vehicleType;
		this.cilindraje = cilindraje;
		this.fechaRegistro = fechaRegistro;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setTipoVehiculo(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
