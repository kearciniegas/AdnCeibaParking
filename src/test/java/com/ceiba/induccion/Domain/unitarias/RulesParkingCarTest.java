package com.ceiba.induccion.Domain.unitarias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.induccion.Buider.RegistryBuilder;
import com.ceiba.induccion.domain.RulesParkingCarImpl;
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RulesParkingCarTest {

	@InjectMocks
	private RulesParkingImpl rulesParkingImpl;

	@Spy
	private VigilantImpl vigilantImpl;

	private static final String PLACA_CARRO = "1234";
	private static final String FECHA_INICIO_VEHICULO = "13/06/2019 01:00";
	private static final String FECHA_FIN_VEHICULO = "13/06/2019 10:00";
	private static final double COSTO_VEHICULO = 8_000;

	private static final String FECHA_INICIO_VEHICULO1 = "14/06/2019 00:00";
	private static final String FECHA_FIN_VEHICULO1 = "15/06/2019 01:00";
	private static final double COSTO_VEHICULO1 = 9_000;

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final int CARROS_EN_PARQUEADERO_PARCIAL = 15;
	public static final int MAS_CARROS_DE_LO_PERMITIDO_EN_PARQUEADERO = 21;

	@InjectMocks
	private RulesParkingCarImpl rulesParkingCarImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(RulesParkingCarTest.class);
	}

	@Test
	public void siExisteCupoCarTest() {
		// arrange

		// act
		boolean resultado = rulesParkingCarImpl.existeEspacio(CARROS_EN_PARQUEADERO_PARCIAL);

		// assert
		Assert.assertTrue(resultado);
	}

	@Test
	public void noExisteCupoCarTest() {
		// arrange

		// act
		boolean resultado = rulesParkingCarImpl.existeEspacio(MAS_CARROS_DE_LO_PERMITIDO_EN_PARQUEADERO);

		// assert
		Assert.assertFalse(resultado);
	}

	@Test
	public void costoEstacionamiento9HorasCar() throws ParseException {
		// arrange
		Date fechaEntrada = null;
		Date fechaSalida = null;
		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_CARRO).conVehicleType(VehicleType.CARRO).build();
		// act
		double costo = rulesParkingCarImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO, costo, 0);
	}

	@Test

	public void costoEstacionamiento1Dia1HoraCarTest() throws ParseException {
		// arrange
		Date fechaEntrada = null;
		Date fechaSalida = null;
		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO1);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO1);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_CARRO).conVehicleType(VehicleType.MOTO).build();
		// act
		double costo = rulesParkingCarImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO1, costo, 0);
	}
}