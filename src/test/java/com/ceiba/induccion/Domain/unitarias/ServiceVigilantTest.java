package com.ceiba.induccion.Domain.unitarias;

import static org.mockito.Matchers.any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.ceiba.induccion.Buider.CommandEntryBuilder;
import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.RulesParkingMotoImpl;
import com.ceiba.induccion.domain.VigilantActivitiesImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.exception.Exceptions;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.domain.ports.PaymentPort;
import com.ceiba.induccion.infrastructure.repository.RegistryRepository;

public class ServiceVigilantTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "NNL677";
	private static final String PLACA_VEHICULO_CON_RESTRICCION = "ANL677";
	private static final Integer CILINDRAJE_MOTO = 550;

	private VigilantImpl calendarioVigilante;

	private RulesParkingImpl rulesParkingImpl;

	private RegistryRepository registryRepository;

	private GetPortRegistration getPortRegistration;

	private PaymentPort paymentPort;

	@InjectMocks
	private VigilantActivitiesImpl vigilantActivitiesImpl;

	@Before
	public void setUp() {
		calendarioVigilante = Mockito.mock(VigilantImpl.class);
		rulesParkingImpl = Mockito.mock(RulesParkingImpl.class);
		registryRepository = Mockito.mock(RegistryRepository.class);
		getPortRegistration = Mockito.mock(GetPortRegistration.class);
		paymentPort = Mockito.mock(PaymentPort.class);
	}

	@Test(expected = Exceptions.class)
	public void noPermitirRegistrarMotoSinCupoTest() {
		// arrange
		vigilantActivitiesImpl = new VigilantActivitiesImpl(rulesParkingImpl, paymentPort, getPortRegistration);

		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		Mockito.when(registryRepository.contarVehiculosEstacionados(VehicleType.CARRO))
				.thenReturn(RulesParkingMotoImpl.MAX_MOTOS_PARQUEADERO);

		Mockito.when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO)).thenReturn(Boolean.FALSE);

		// act
		vigilantActivitiesImpl.registrarEntrada(commandEntry);

	}

	@Test(expected = Exceptions.class)
	public void noPermitirRegistrarCarroSinCupoTest() {
		vigilantActivitiesImpl = new VigilantActivitiesImpl(rulesParkingImpl, paymentPort, getPortRegistration);

		// arrange
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.CARRO).build();

		Mockito.when(registryRepository.contarVehiculosEstacionados(VehicleType.CARRO))
				.thenReturn(RulesParkingMotoImpl.MAX_MOTOS_PARQUEADERO);

		Mockito.when(rulesParkingImpl.validarSiHayEspacio(VehicleType.CARRO)).thenReturn(Boolean.FALSE);

		// act
		vigilantActivitiesImpl.registrarEntrada(commandEntry);

	}

	@Test(expected = Exceptions.class)
	public void noPermitirRegistrarVehiculoConRestriccionExceptionsTest() {
		vigilantActivitiesImpl = new VigilantActivitiesImpl(rulesParkingImpl, paymentPort, getPortRegistration);

		// arrange

		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_CON_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		Mockito.when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO)).thenReturn(false);

		// act
		vigilantActivitiesImpl.registrarEntrada(commandEntry);

	}

	@Test
	public void registrarMotoConCupoTest() {
		vigilantActivitiesImpl = new VigilantActivitiesImpl(rulesParkingImpl, paymentPort, getPortRegistration);

		// arrange
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		Mockito.when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO)).thenReturn(Boolean.TRUE);

		Mockito.when(registryRepository.save(any())).thenReturn(commandEntry);

		// act
		Registry registroAlmacenado = vigilantActivitiesImpl.registrarEntrada(commandEntry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registroAlmacenado.getPlaca());
		Assert.assertEquals(CILINDRAJE_MOTO, registroAlmacenado.getCilindraje(), 0);
		Assert.assertEquals(VehicleType.MOTO, registroAlmacenado.getVehicleType());
	}

}
