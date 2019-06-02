package com.ceiba.induccion.domain.entity;

import java.util.Date;

public class Vehiculo {

	private static final String SMS_ERROR_PLACA_REQUIRED = "La placa del vehiculo es requerida";
	private static final String SMS_ERROR_TIPO_REQUIRED = "El tipo de vehiculo es requerido";

	private long id;
	private String placa;
	private TipoVehiculo tipoVehiculo;
	private long cilindraje;
	private String usuario;
	private Date fechaRegistro;

	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(long id, String placa, TipoVehiculo tipoVehiculo, long cilindraje, String usuario,
			Date fechaRegistro) throws Exception {

		ValidatorSms.required(placa, SMS_ERROR_PLACA_REQUIRED);
		ValidatorSms.required(tipoVehiculo, SMS_ERROR_TIPO_REQUIRED);
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.usuario = usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
