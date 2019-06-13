package com.ceiba.induccion.aplicacion;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.Buider.RegistryBuilder;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.domain.VigilantActivitiesImpl;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.exception.Exceptions;

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
		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.CARRO).build();
		// act
		Registry registro = registryEntry.execute(registry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registro.getPlaca());
		Assert.assertEquals(VehicleType.CARRO, registro.getVehicleType());
	}
	@Test
	public void registrarIngresoMotoSinRestriccionTest() {
		// arrange
		Registry registry = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.MOTO).build();
		// act
		Registry registro = registryEntry.execute(registry);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registro.getPlaca());
		Assert.assertEquals(VehicleType.MOTO, registro.getVehicleType());
	}	
	@Test
	public void noRegistrarConPlacaExistenteTest() {
		// arrange
		Registry vehiculo = RegistryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
						.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

				// act
				try {
					registryEntry.execute(vehiculo);
					registryEntry.execute(vehiculo);
				} catch (Exceptions e) {
					Assert.assertEquals(VigilantActivitiesImpl.SMS_ERROR_YA_ESTACIONADO, e.getMessage());
					return;
				}

				// assert
				fail();
			}
	
}