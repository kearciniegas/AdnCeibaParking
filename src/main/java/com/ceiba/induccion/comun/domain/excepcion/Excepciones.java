package com.ceiba.induccion.comun.domain.excepcion;

public class Excepciones extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public Excepciones(String message) {
		super(message);
	}
}
