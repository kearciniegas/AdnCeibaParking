package com.ceiba.induccion.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculoDto {

	private long id;
	private String placa;
	private String tipo;
	private Integer cilindraje;

	public VehiculoDto() {
		super();
	}
}
