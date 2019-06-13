package com.ceiba.induccion.domain.unitarias;

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
import com.ceiba.induccion.domain.VigilantActivitiesImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.infrastructure.repository.RegistryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ServiceVigilantTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "NNL677";
	private static final Integer CILINDRAJE_MOTO = 550;
	private static final int MOTOS_EN_PARQUEADERO = 1;

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

	/*
	 * @Test public void registrarMotoConCupoTest() { // arrange Registry registry =
	 * RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
	 * .conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();
	 * 
	 * when(registryRepository.contarVehiculosEstacionados(VehicleType.MOTO)).
	 * thenReturn(MOTOS_EN_PARQUEADERO);
	 * 
	 * when(rulesParkingImpl.validarSiHayEspacio(VehicleType.MOTO,
	 * MOTOS_EN_PARQUEADERO)).thenReturn(Boolean.TRUE);
	 * 
	 * when(registryRepository.save(any())).thenReturn(registry);
	 * 
	 * // act Registry registryA =
	 * vigilantActivitiesImpl.registrarEntrada(registry);
	 * 
	 * // assert Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION,
	 * registryA.getPlaca()); Assert.assertEquals(CILINDRAJE_MOTO,
	 * registryA.getCilindraje(),0); Assert.assertEquals(VehicleType.MOTO,
	 * registryA.getVehicleType()); }
	 */

}
