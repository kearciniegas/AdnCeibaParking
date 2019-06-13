package com.ceiba.induccion.domain.unitarias;

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

import com.ceiba.induccion.Buider.RegistryBuilder;
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.VigilantActivitiesImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.infrastructure.repository.RegistryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceVigilantTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "NNL677";
	private static final Integer CILINDRAJE_MOTO = 550;
	private static final int MOTOS_EN_PARQUEADERO = 3;

	@Mock
	private VigilantImpl calendarioVigilante;

	@Mock
	private RulesParkingImpl reglasEstacionamiento;

	@Mock
	private RegistryRepository registryRepository;

	@InjectMocks
	private VigilantActivitiesImpl operacionesDelVigilante;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(ServiceVigilantTest.class);
	}

	/* @Test
	public void registrarMotoConCupoTest() {
		// arrange
		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION).conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		when(registryRepository.contarVehiculosEstacionados(VehicleType.MOTO)).thenReturn(MOTOS_EN_PARQUEADERO);

		when(reglasEstacionamiento.validarSiHayEspacio(VehicleType.MOTO, MOTOS_EN_PARQUEADERO))
				.thenReturn(Boolean.TRUE);
		// act
		Registry registroAlmacenado = operacionesDelVigilante.registrarEntrada(registry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registroAlmacenado.getPlaca());
		Assert.assertEquals(VehicleType.MOTO, registroAlmacenado.getVehicleType());
	}*/

}
