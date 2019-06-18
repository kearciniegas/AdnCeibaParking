package com.ceiba.induccion.domain;

import java.util.Date;

import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.exception.Exceptions;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.domain.ports.PaymentPort;
import com.ceiba.induccion.infrastructure.mapper.CommandMapperEntry;

public class VigilantActivitiesImpl implements VigilantActivities {

	public static final String SMS_ERROR_NO_PUEDE_INGRESO_ENTRE_SEMANA = "Para el vehiculo esta prohibido ingresar entre semana";
	public static final String SMS_ERROR_NO_ESPACIO = "El parqueadero no cuenta con espacios para guardar el vehiculo";
	public static final String SMS_ERROR_YA_ESTACIONADO = "El vehiculo ya esta parqueado";

	private RulesParkingImpl reglasParking;

	private PaymentPort paymentPort;

	private GetPortRegistration getPortRegistration;

	public VigilantActivitiesImpl(RulesParkingImpl reglasParking, PaymentPort paymentPort,
			GetPortRegistration getPortRegistration) {
		this.reglasParking = reglasParking;
		this.paymentPort = paymentPort;
		this.getPortRegistration = getPortRegistration;
	}

	@Override
	public Registry registrarEntrada(CommandEntry commandEntry) {

		Registry registry = CommandMapperEntry.mapToRegistry(commandEntry);

		if (reglasParking.validarSiExisteRestriccion(registry.getPlaca())) {
			throw new Exceptions(SMS_ERROR_NO_PUEDE_INGRESO_ENTRE_SEMANA);
		}

		if (!reglasParking.validarSiHayEspacio(registry.getVehicleType())) {
			throw new Exceptions(SMS_ERROR_NO_ESPACIO);
		}

		if (getPortRegistration.existeVehiculoEnEstacionamiento(registry.getPlaca())) {
			throw new Exceptions(SMS_ERROR_YA_ESTACIONADO);
		}
		registry.setFechaEntrada(new Date());
		getPortRegistration.save(registry);
		return registry;
	}

	@Override
	public Payment registrarSalida(long idRegistro) {
		Registry registry = getPortRegistration.findById(idRegistro);
		registry.setFechaSalida(new Date());
		getPortRegistration.save(registry);

		Double costoCalculado = reglasParking.ejecutarCalculo(registry);
		Payment payment = new Payment(costoCalculado, registry);
		return paymentPort.save(payment);
	}

}
