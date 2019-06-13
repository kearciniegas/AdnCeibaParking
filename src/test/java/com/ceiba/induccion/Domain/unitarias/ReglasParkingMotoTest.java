package com.ceiba.induccion.domain.unitarias;

import static org.junit.Assert.fail;

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
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.RulesParkingMotoImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReglasParkingMotoTest {

	@InjectMocks
	private RulesParkingImpl rulesParkingImpl;

	@Spy
	private VigilantImpl vigilantImpl;

	private static final String PLACA_MOTO = "LGH156";
	private static final int CILINDRAJE_MOTO_BAJO = 200;
	private static final String FECHA_INICIO_VEHICULO = "13/06/2019 07:00";
	private static final String FECHA_FIN_VEHICULO = "13/06/2019 16:00";
	private static final String FECHA_INICIO_VEHICULO1 = "11/06/2019 16:00";
	private static final String FECHA_FIN_VEHICULO1 = "12/06/2019 02:00";
	private static final double COSTO_VEHICULO = 4_000;
	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final int MOTOS_EN_PARQUEADERO_PARCIAL = 7;
	public static final int MAS_MOTOS_DE_LO_PERMITIDO_EN_PARQUEADERO = 11;

	private static final int CILINDRAJE_MOTO_ALTO = 500;

	private static final double COSTO_VEHICULO1 = 6_000;

	@InjectMocks
	private RulesParkingMotoImpl rulesParkingMotoImpl;

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

	@Test
	public void costoEstacionamiento9HorasCilindrajeBajoTest() {
		// arrange
		Date fechaEntrada = null;
		Date fechaSalida = null;
		try {
			fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO);
			fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO);
		} catch (ParseException e) {
			fail();
		}
		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO, costo, 0);
	}
	
	@Test
	public void costoEstacionamiento9HorasCilindrajoAltoTest() {
		// arrange
		Date fechaEntrada = null;
		Date fechaSalida = null;
		try {
			fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO);
			fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO);
		} catch (ParseException e) {
			fail();
		}
		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_ALTO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO1, costo, 0);
	}


	@Test
	public void costoEstacionamiento10HorasCilindrajeAltoTest() {
		// arrange
		Date fechaEntrada = null;
		Date fechaSalida = null;
		try {
			fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO1);
			fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO1);
		} catch (ParseException e) {
			fail();
		}
		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_ALTO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO1, costo, 0);
	}
	@Test
	public void costoEstacionamiento10HorasCilindrajeBajoTest() {
		// arrange
		Date fechaEntrada = null;
		Date fechaSalida = null;
		try {
			fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO1);
			fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO1);
		} catch (ParseException e) {
			fail();
		}
		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO, costo, 0);
	}
}
