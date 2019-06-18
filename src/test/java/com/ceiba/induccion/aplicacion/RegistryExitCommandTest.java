package com.ceiba.induccion.aplicacion;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.induccion.Buider.CommandEntryBuilder;
import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.application.command.RegisterVehiclesExit;
import com.ceiba.induccion.domain.RulesParkingMotoImpl;
import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegistryExitCommandTest {
	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "RLB741";
	private static final Integer CILINDRAJE_MOTO = 300;

	@Autowired
	private RegisterVehicleEntry registerVehicleEntry;

	@Autowired
	private RegisterVehiclesExit registrarSalidaCommand;

	@Test
	public void registrarSalidaMotoTest() {

		// arrage
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		// act
		commandEntry = registerVehicleEntry.execute(commandEntry);

		Payment commandEntry2 = registrarSalidaCommand.execute(commandEntry.getId());

		// assert
		Assert.assertEquals(RulesParkingMotoImpl.PRECIO_MOTO_HORA, commandEntry2.getValor(), 0);
	}

}
