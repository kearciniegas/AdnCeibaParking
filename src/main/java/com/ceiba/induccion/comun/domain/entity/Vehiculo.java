package com.ceiba.induccion.comun.domain.entity;

import java.util.Date;

public class Vehiculo {

	private long id;
	private String placa;
	private TipoVehiculo tipoVehiculo;
	private long cilindraje;
	private Date fechaRegistro;

	public Vehiculo() {
		super();
	}

	public Vehiculo(long id, String placa, TipoVehiculo tipoVehiculo, long cilindraje, Date fechaRegistro) {

		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
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

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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
