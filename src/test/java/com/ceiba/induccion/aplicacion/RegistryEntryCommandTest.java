package com.ceiba.induccion.aplicacion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.ceiba.induccion.Buider.CommandEntryBuilder;
import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.domain.VigilantActivities;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.infrastructure.mapper.CommandMapperEntry;
import com.ceiba.induccion.infrastructure.mapper.MapperRegistry;

public class RegistryEntryCommandTest {

	private MapperRegistry mapperRegistry;

	private VigilantActivities vigilantActivities;
	

	@InjectMocks
	private RegisterVehicleEntry registryEntry;

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "GHS1234";
	private static final Integer CILINDRAJE_MOTO = 300;

	@Before
	public void setUp() {
		mapperRegistry = Mockito.mock(MapperRegistry.class);
		vigilantActivities = Mockito.mock(VigilantActivities.class);
	}

	@Test
	public void registrarIngresoCarroSinRestriccionTest() {
		
		// arrange
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.CARRO).build();
		
		Mockito.when(vigilantActivities.registrarEntrada(commandEntry)).thenReturn(CommandMapperEntry.mapToRegistry(commandEntry));
		registryEntry = new RegisterVehicleEntry(new MapperRegistry(), vigilantActivities);

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
		Mockito.when(vigilantActivities.registrarEntrada(commandEntry)).thenReturn(CommandMapperEntry.mapToRegistry(commandEntry));
		registryEntry = new RegisterVehicleEntry(new MapperRegistry(), vigilantActivities);
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
		
		Mockito.when(vigilantActivities.registrarEntrada(commandEntry)).thenReturn(CommandMapperEntry.mapToRegistry(commandEntry));
		registryEntry = new RegisterVehicleEntry(new MapperRegistry(), vigilantActivities);

		// act
		registryEntry.execute(commandEntry);

	}

}