package com.ceiba.induccion.domain;

import java.time.DayOfWeek;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.ports.GetPortRegistration;

@Component
public class RulesParkingImpl {
	public static final char RESTRICCION_DE_LETRA_PLACA = 'A';

	@Resource(name = "moto")
	private RulesParking moto;

	@Resource(name= "carro")
	private RulesParking carro;

	@Autowired
	private VigilantImpl vigilantImpl;
	
	@Autowired
	private GetPortRegistration getPortRegistration;
	
	public boolean validarSiHayEspacio(VehicleType vehicleType) {
		int numeroVehiculos = getPortRegistration.contarVehiculosEstacionados(vehicleType);
		boolean espacio = false;
		if (vehicleType == VehicleType.MOTO) {
			espacio = moto.existeEspacio(numeroVehiculos);
		}else{
			espacio = carro.existeEspacio(numeroVehiculos);
		}

		return espacio;
	}

	public Double ejecutarCalculo(Registry registry) {
		Double costo = null;
		if (registry != null && registry.getVehicleType() == VehicleType.MOTO) {
			costo = moto.calcularPago(registry);
		}else{
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
