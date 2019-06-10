package com.ceiba.induccion.domain;

import java.time.DayOfWeek;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

@Component
public class RulesParkingImpl {
	public static final char RESTRICCION_DE_LETRA_PLACA = 'A';

	@Resource(name = "moto")
	private RulesParking moto;

	@Autowired
	private VigilantImpl vigilantImpl;

	public boolean validarSiHayEspacio(VehicleType vehicleType, int numeroVehiculos) {
		boolean espacio = false;
		if (vehicleType == VehicleType.MOTO) {
			espacio = moto.existeEspacio(numeroVehiculos);
		}

		return espacio;
	}

	public Double ejecutarCalculo(Registry registry) {
		Double costo = null;
		if (registry != null && registry.getVehiculo().getVehicleType() == VehicleType.MOTO) {
			costo = moto.calcularPago(registry);
		}
		return costo;
	}

	public Boolean validarSiExisteRestriccion(String placa) {
		DayOfWeek diaHoy = vigilantImpl.dayOfWeek(new Date());
		return placa.charAt(0) == RulesParkingImpl.RESTRICCION_DE_LETRA_PLACA
				&& !(diaHoy == DayOfWeek.SUNDAY || diaHoy == DayOfWeek.MONDAY);
	}
}
