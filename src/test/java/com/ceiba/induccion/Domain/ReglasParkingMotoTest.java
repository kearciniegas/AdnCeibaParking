package com.ceiba.induccion.Domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.comun.domain.ReglasParkingMotoImpl;
import com.ceiba.induccion.comun.domain.WatchfulImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReglasParkingMotoTest {

	@InjectMocks
	private ReglasParkingMotoImpl reglasParkingMoto;

	@Spy
	private WatchfulImpl watchfulImpl;

	private static final int MOTOS_EN_PARQUEADERO_PARCIAL = 7;
	public static final int MAX_MOTOS_PARQUEADERO = 10;


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(ReglasParkingMotoTest.class);
	}

	@Test
	public void siExisteCupoTest() {
		// arrange

		// act
		boolean resultado = reglasParkingMoto.existeEspacio(MOTOS_EN_PARQUEADERO_PARCIAL);

		// assert
		Assert.assertTrue(resultado);
	}

	@Test
	public void noExisteCupoTest() {
		// arrange

		// act
		boolean resultado = reglasParkingMoto.existeEspacio(MAX_MOTOS_PARQUEADERO);

		// assert
		Assert.assertFalse(resultado);
	}

}
