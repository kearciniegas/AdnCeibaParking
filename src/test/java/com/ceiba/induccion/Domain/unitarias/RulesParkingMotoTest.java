package com.ceiba.induccion.Domain.unitarias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.ceiba.induccion.Buider.RegistryBuilder;
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.RulesParkingMotoImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

public class RulesParkingMotoTest {

	@InjectMocks
	private RulesParkingImpl rulesParkingImpl;

	private VigilantImpl vigilantImpl;

	private static final String PLACA_MOTO = "LGH156";
	private static final int CILINDRAJE_MOTO_BAJO = 200;
	private static final String FECHA_INICIO_VEHICULO = "13/06/2019 07:00";
	private static final String FECHA_FIN_VEHICULO = "13/06/2019 16:00";
	private static final String FECHA_INICIO_VEHICULO1 = "11/06/2019 16:00";
	private static final String FECHA_FIN_VEHICULO1 = "12/06/2019 02:00";
	private static final String FECHA_INICIO_VEHICULO2 = "14/06/2019 01:00";
	private static final String FECHA_FIN_VEHICULO2 = "14/06/2019 01:30";
	private static final String FECHA_INICIO_VEHICULO3 = "01/06/2019 00:00";
	private static final String FECHA_FIN_VEHICULO3 = "02/06/2019 01:00";
	private static final double COSTO_VEHICULO = 4_000;
	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final int MOTOS_EN_PARQUEADERO_PARCIAL = 7;
	public static final int MAS_MOTOS_DE_LO_PERMITIDO_EN_PARQUEADERO = 11;

	private static final int CILINDRAJE_MOTO_ALTO = 500;

	private static final double COSTO_VEHICULO1 = 6_000;
	private static final double COSTO_VEHICULO2 = 500;
	private static final double COSTO_VEHICULO3 = 2_500;
	private static final double COSTO_VEHICULO4 = 4_500;
	
	private RulesParkingMotoImpl rulesParkingMotoImpl;

	@Before
	public void setup() {
		vigilantImpl = Mockito.mock(VigilantImpl.class);
	}

	@Test
	public void siExisteCupoTest() {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		// act
		boolean resultado = rulesParkingMotoImpl.existeEspacio(MOTOS_EN_PARQUEADERO_PARCIAL);

		// assert
		Assert.assertTrue(resultado);
	}

	@Test
	public void noExisteCupoTest() {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		// act
		boolean resultado = rulesParkingMotoImpl.existeEspacio(MAS_MOTOS_DE_LO_PERMITIDO_EN_PARQUEADERO);

		// assert
		Assert.assertFalse(resultado);
	}

	@Test
	public void costoEstacionamiento9HorasCilindrajeBajoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);
		Date fechaEntrada = null;
		Date fechaSalida = null;
		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(9L);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO, costo, 0);
	}

	@Test
	public void costoEstacionamiento9HorasCilindrajoAltoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		Date fechaEntrada = null;
		Date fechaSalida = null;
		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(9L);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_ALTO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO1, costo, 0);
	}

	@Test
	public void costoEstacionamiento10HorasCilindrajeAltoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		Date fechaEntrada = null;
		Date fechaSalida = null;

		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO1);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO1);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(10L);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_ALTO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO1, costo, 0);
	}

	@Test
	public void costoEstacionamiento10HorasCilindrajeBajoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		Date fechaEntrada = null;
		Date fechaSalida = null;

		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO1);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO1);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(10L);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO, costo, 0);
	}

	@Test
	public void costoEstacionamiento30MinutosCilindrajeBajoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		Date fechaEntrada = null;
		Date fechaSalida = null;
		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO2);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO2);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(1L);
		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO2, costo, 0);
	}

	@Test
	public void costoEstacionamiento30MinutosCilindrajeAltoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		Date fechaEntrada = null;
		Date fechaSalida = null;

		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO2);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO2);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(1L);

		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_ALTO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO3, costo, 0);
	}

	@Test
	public void costoEstacionamiento1Dia1HoraCilindrajeBajoTest() throws ParseException {
		// arrange
		rulesParkingMotoImpl = new RulesParkingMotoImpl(vigilantImpl);

		Date fechaEntrada = null;
		Date fechaSalida = null;
		fechaEntrada = formatoFechaHora.parse(FECHA_INICIO_VEHICULO3);
		fechaSalida = formatoFechaHora.parse(FECHA_FIN_VEHICULO3);
		Mockito.when(vigilantImpl.hoursBetweenDate(fechaEntrada, fechaSalida)).thenReturn(25L);


		Registry registry = RegistryBuilder.defaultValues().conFechaEntrada(fechaEntrada).conFechaSalida(fechaSalida)
				.conPlaca(PLACA_MOTO).conVehicleType(VehicleType.MOTO).conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		// act
		double costo = rulesParkingMotoImpl.calcularPago(registry);

		// assert
		Assert.assertEquals(COSTO_VEHICULO4, costo, 0);
	}
}
