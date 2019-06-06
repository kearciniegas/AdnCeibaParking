package com.ceiba.induccion.comun.domain;

import java.time.DayOfWeek;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.TipoVehiculo;

@Component
public class ReglasParkingImpl {
	public static final char RESTRICCION_DE_LETRA_PLACA = 'A';

	@Resource(name = "moto")
	private ReglasParking moto;

	@Autowired
	private WatchfulImpl watchfulImpl;

	public boolean validarSiHayEspacio(TipoVehiculo tipoVehiculo, int numeroVehiculos) {
		boolean espacio = false;
		if (tipoVehiculo == TipoVehiculo.MOTO) {
			espacio = moto.existeEspacio(numeroVehiculos);
		}
		return espacio;
	}

	public Double ejecutarCalculo(Registro registro) {
		Double costo = null;
		if (registro != null && registro.getVehiculo().getTipoVehiculo() == TipoVehiculo.MOTO) {
			costo = moto.calcularPago(registro);
		}
		return costo;
	}

	public Boolean validarSiExisteRestriccion(String placa) {
		DayOfWeek diaHoy = watchfulImpl.dayOfWeek(new Date());
		return placa.charAt(0) == ReglasParkingImpl.RESTRICCION_DE_LETRA_PLACA
				&& !(diaHoy == DayOfWeek.SUNDAY || diaHoy == DayOfWeek.MONDAY);
	}
}
