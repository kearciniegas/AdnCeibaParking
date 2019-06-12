package com.ceiba.induccion.application.dto;

import java.util.Date;

public class RegistryDto {

	private String placa;
	private String tipo;
	private long cilindraje;
	
	

	public RegistryDto() {
		super();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}


}
