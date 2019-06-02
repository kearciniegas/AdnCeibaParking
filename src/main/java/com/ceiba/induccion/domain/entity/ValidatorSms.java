package com.ceiba.induccion.domain.entity;


public class ValidatorSms {
	private ValidatorSms() {
	}

	public static void required(Object value, String message) throws Exception {
		if (value == null) {
			throw new Exception(message);
		}
	}
}
