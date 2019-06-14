package com.ceiba.induccion.domain.unitarias;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.Buider.RegistryBuilder;
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.RulesParkingMotoImpl;
import com.ceiba.induccion.domain.VigilantActivitiesImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.exception.Exceptions;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.infrastructure.repository.RegistryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ServiceVigilantTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "NNL677";
	private static final String PLACA_VEHICULO_CON_RESTRICCION = "ANL677";
	private static final Integer CILINDRAJE_MOTO = 550;

	@Mock
	private VigilantImpl calendarioVigilante;

	@Mock
	private RulesParkingImpl rulesParkingImpl;

	@Mock
	private RegistryRepository registryRepository;

	@Mock
	private GetPortRegistration getPortRegistration;

	@InjectMocks
	private VigilantActivitiesImpl vigilantActivitiesImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(ServiceVigilantTest.class);
	}

	@Test
	public void noPermitirRegistrarMotoSinCupoTest() {
		// arrange
		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		when(registryRepository.contarVehiculosEstacionados(VehicleType.CARRO))
				.thenReturn(RulesParkingMotoImpl.MAX_MOTOS_PARQUEADERO);

		when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO)).thenReturn(Boolean.FALSE);

		// act
		try {
			vigilantActivitiesImpl.registrarEntrada(registry);
			fail();
		} catch (Exceptions e) {
			Assert.assertEquals(VigilantActivitiesImpl.SMS_ERROR_NO_ESPACIO, e.getMessage());
		}
	}

	@Test
	public void noPermitirRegistrarCarroSinCupoTest() {
		// arrange
		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.CARRO).build();

		when(registryRepository.contarVehiculosEstacionados(VehicleType.CARRO))
				.thenReturn(RulesParkingMotoImpl.MAX_MOTOS_PARQUEADERO);

		when(rulesParkingImpl.validarSiHayEspacio(VehicleType.CARRO)).thenReturn(Boolean.FALSE);

		// act
		try {
			vigilantActivitiesImpl.registrarEntrada(registry);
			fail();
		} catch (Exceptions e) {
			Assert.assertEquals(VigilantActivitiesImpl.SMS_ERROR_NO_ESPACIO, e.getMessage());
		}

	}

	@Test(expected = Exceptions.class)
	public void noPermitirRegistrarVehiculoConRestriccionExceptionsTest() {
		// arrange

		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_CON_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO)).thenReturn(false);

		// act
		vigilantActivitiesImpl.registrarEntrada(registry);

	}

	@Test
	public void registrarMotoConCupoTest() {
		// arrange
		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO)).thenReturn(Boolean.TRUE);

		when(registryRepository.save(any())).thenReturn(registry);

		// act
		Registry registroAlmacenado = vigilantActivitiesImpl.registrarEntrada(registry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registroAlmacenado.getPlaca());
		Assert.assertEquals(CILINDRAJE_MOTO, registroAlmacenado.getCilindraje(), 0);
		Assert.assertEquals(VehicleType.MOTO, registroAlmacenado.getVehicleType());
	}

}
