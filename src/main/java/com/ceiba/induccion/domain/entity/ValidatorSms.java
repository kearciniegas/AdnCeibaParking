package com.ceiba.induccion.domain.entity;

import com.ceiba.induccion.domain.exception.Exceptions;

public final class ValidatorSms {
	private ValidatorSms() {
	}

	public static void required(Object value, String message) {
		if (value == null) {
			throw new Exceptions(message);
		}
	}
}
