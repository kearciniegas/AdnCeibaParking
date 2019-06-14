package com.ceiba.induccion.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.exception.Exceptions;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.domain.ports.PaymentPort;

@Transactional
@Service
public class VigilantActivitiesImpl implements VigilantActivities {

	public static final String SMS_ERROR_NO_PUEDE_INGRESO_ENTRE_SEMANA = "Para el vehiculo esta prohibido ingresar entre semana";
	public static final String SMS_ERROR_NO_ESPACIO = "El parqueadero no cuenta con espacios para guardar el vehiculo";
	public static final String SMS_ERROR_YA_ESTACIONADO = "El vehiculo ya esta parqueado";

	@Autowired
	private RulesParkingImpl reglasParking;

	@Autowired
	private PaymentPort paymentPort;

	@Autowired
	private GetPortRegistration getPortRegistration;

	@Override
	public Registry registrarEntrada(Registry registry) {
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
