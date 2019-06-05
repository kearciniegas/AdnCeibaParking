package com.ceiba.induccion.comun.domain.entity;

import com.ceiba.induccion.comun.domain.excepcion.Excepciones;

public final class ValidatorSms {
	private ValidatorSms() {
	}

	public static void required(Object value, String message) {
		if (value == null) {
			throw new Excepciones(message);
		}
	}
}
