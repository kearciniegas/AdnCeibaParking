package com.ceiba.induccion.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Registry;

@Component("moto")
public class RulesParkingMotoImpl implements RulesParking {

	public static final int MAX_MOTOS_PARQUEADERO = 10;
	public static final double PRECIO_MOTO_HORA = 500;
	public static final double PRECIO_MOTO_DIA = 4_000;
	private static final double PRECIO_ADICIONAL_CILINDRAJE = 2_000;
	private static final long MIN_HORAS_COBRO = 1;
	private static final long HORAS_MIN_PARQUEADERO_DIA = 8;
	private static final long HORAS_MAX_DIA_MOTO = 24;
	private static final long CILINDRAJE_MAX_MOTO = 500;

	@Autowired
	private VigilantImpl vigilantImpl;

	@Override
	public double calcularPago(Registry registry) {
		double costo = 0;
		long totalHoras = vigilantImpl.hoursBetweenDate(registry.getFechaEntrada(), registry.getFechaSalida());
		double diasParqueo = (double) totalHoras / HORAS_MAX_DIA_MOTO;
		double horasParqueo = totalHoras % HORAS_MAX_DIA_MOTO;
		costo = diasParqueo * PRECIO_MOTO_DIA;

		if (horasParqueo < MIN_HORAS_COBRO) {
			costo = PRECIO_MOTO_HORA;
		} else if (horasParqueo <= HORAS_MIN_PARQUEADERO_DIA) {
			costo += horasParqueo * PRECIO_MOTO_HORA;
		} else {
			costo += PRECIO_MOTO_DIA;
		}

		if (registry.getCilindraje() >= CILINDRAJE_MAX_MOTO) {
			costo += PRECIO_ADICIONAL_CILINDRAJE;
		}

		return costo;
	}

	@Override
	public boolean existeEspacio(int numero) {
		return numero < MAX_MOTOS_PARQUEADERO;
	}

}
