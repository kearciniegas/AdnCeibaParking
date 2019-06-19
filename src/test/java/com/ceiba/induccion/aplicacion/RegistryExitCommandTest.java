package com.ceiba.induccion.aplicacion;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.induccion.Buider.CommandEntryBuilder;
import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.application.command.RegisterVehiclesExit;
import com.ceiba.induccion.domain.VigilantActivities;
import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.infrastructure.mapper.CommandMapperEntry;
import com.ceiba.induccion.infrastructure.mapper.MapperRegistry;

public class RegistryExitCommandTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "RLB741";
	private static final Integer CILINDRAJE_MOTO = 300;

	private RegisterVehicleEntry registerVehicleEntry;

	private RegisterVehiclesExit registrarSalidaCommand;

	private MapperRegistry mapperRegistry;

	private VigilantActivities vigilantActivities;

	@Before
	public void setUp() {
		registerVehicleEntry = Mockito.mock(RegisterVehicleEntry.class);
		registrarSalidaCommand = Mockito.mock(RegisterVehiclesExit.class);
		mapperRegistry = Mockito.mock(MapperRegistry.class);
		vigilantActivities = Mockito.mock(VigilantActivities.class);
	}

	@Test
	public void registrarSalidaMotoTest() {

		// arrage
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		Mockito.when(vigilantActivities.registrarEntrada(commandEntry))
				.thenReturn(CommandMapperEntry.mapToRegistry(commandEntry));
		registerVehicleEntry = new RegisterVehicleEntry(new MapperRegistry(), vigilantActivities);

		// act
		CommandEntry registry = registerVehicleEntry.execute(commandEntry);

		Payment salidaRegistry = registrarSalidaCommand.execute(registry.getId());

		// assert
		assertNotNull(registry);
		// assertNotNull(salidaRegistry);
	}

}
