package com.ceiba.induccion.Domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.domain.RulesParkingMotoImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReglasParkingMotoTest {

	@InjectMocks
	private RulesParkingMotoImpl rulesParkingMotoImpl;

	private static final int MOTOS_EN_PARQUEADERO_PARCIAL = 7;
	public static final int MAS_MOTOS_DE_LO_PERMITIDO_EN_PARQUEADERO = 11;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(ReglasParkingMotoTest.class);
	}

	@Test
	public void siExisteCupoTest() {
		// arrange

		// act
		boolean resultado = rulesParkingMotoImpl.existeEspacio(MOTOS_EN_PARQUEADERO_PARCIAL);

		// assert
		Assert.assertTrue(resultado);
	}

	@Test
	public void noExisteCupoTest() {
		// arrange

		// act
		boolean resultado = rulesParkingMotoImpl.existeEspacio(MAS_MOTOS_DE_LO_PERMITIDO_EN_PARQUEADERO);

		// assert
		Assert.assertFalse(resultado);
	}

}
