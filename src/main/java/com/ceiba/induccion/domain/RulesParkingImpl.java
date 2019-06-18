package com.ceiba.induccion.domain;

import java.time.DayOfWeek;
import java.util.Date;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.ports.GetPortRegistration;

public class RulesParkingImpl {
	public static final char RESTRICCION_DE_LETRA_PLACA = 'A';

	private RulesParking moto;

	private RulesParking carro;

	private VigilantImpl vigilantImpl;

	private GetPortRegistration getPortRegistration;

	public RulesParkingImpl(RulesParking moto, RulesParking carro, VigilantImpl vigilantImpl,
			GetPortRegistration getPortRegistration) {
		super();
		this.moto = moto;
		this.carro = carro;
		this.vigilantImpl = vigilantImpl;
		this.getPortRegistration = getPortRegistration;
	}

	public boolean validarSiHayEspacio(VehicleType vehicleType) {
		int numeroVehiculos = getPortRegistration.contarVehiculosEstacionados(vehicleType);
		boolean espacio = false;
		if (vehicleType == VehicleType.MOTO) {
			espacio = moto.existeEspacio(numeroVehiculos);
		} else {
			espacio = carro.existeEspacio(numeroVehiculos);
		}

		return espacio;
	}

	public Double ejecutarCalculo(Registry registry) {
		Double costo = null;
		if (registry != null && registry.getVehicleType() == VehicleType.MOTO) {
			costo = moto.calcularPago(registry);
		} else {
			costo = carro.calcularPago(registry);
		}
		return costo;
	}

	public Boolean validarSiExisteRestriccion(String placa) {
		DayOfWeek diaHoy = vigilantImpl.dayOfWeek(new Date());
		return placa.charAt(0) == RulesParkingImpl.RESTRICCION_DE_LETRA_PLACA
				&& !(diaHoy == DayOfWeek.SUNDAY || diaHoy == DayOfWeek.MONDAY);
	}
}
