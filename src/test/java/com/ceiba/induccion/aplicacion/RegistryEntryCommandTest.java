package com.ceiba.induccion.aplicacion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.Buider.CommandEntryBuilder;
import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.domain.entity.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegistryEntryCommandTest {

	@Autowired
	private RegisterVehicleEntry registryEntry;

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "GHS1234";
	private static final Integer CILINDRAJE_MOTO = 300;

	@Test
	public void registrarIngresoCarroSinRestriccionTest() {
		// arrange
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.CARRO).build();
		// act
		CommandEntry commandEntry1 = registryEntry.execute(commandEntry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, commandEntry1.getPlaca());
		Assert.assertEquals(VehicleType.CARRO, commandEntry1.getVehicleType());
	}

	@Test
	public void registrarIngresoMotoSinRestriccionTest() {
		// arrange
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.MOTO).build();
		// act
		CommandEntry commandEntry1 = registryEntry.execute(commandEntry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, commandEntry1.getPlaca());
		Assert.assertEquals(VehicleType.MOTO, commandEntry1.getVehicleType());
	}

	@Test
	public void noRegistrarConPlacaExistenteTest() {
		// arrange
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		// act
		registryEntry.execute(commandEntry);

	}

}