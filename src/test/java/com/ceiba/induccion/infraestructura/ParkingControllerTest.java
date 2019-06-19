package com.ceiba.induccion.infraestructura;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.induccion.AdnCeibaApplication;
import com.ceiba.induccion.ApplicationMock;
import com.ceiba.induccion.Buider.CommandEntryBuilder;
import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.application.command.RegisterVehiclesExit;
import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = AdnCeibaApplication.class)
@AutoConfigureMockMvc
public class ParkingControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RegisterVehicleEntry registerVehicleEntry;

	@Autowired
	private RegisterVehiclesExit registrarSalidaCommand;

	private MockMvc mvc;

	private static final String URL_ENTRADA = "/registros/entrada/";
	private static final String PLACA_CAR = "URG-586";
	private static final String PLACA_MOTORCYCLE = "URG-589";
	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "RLB741";
	private static final Integer CILINDRAJE_MOTO = 300;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void registerEntryCar() throws Exception {
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_CAR)
				.conVehicleType(VehicleType.CARRO).build();

		mvc.perform(post(URL_ENTRADA).content(objectMapper.writeValueAsString(commandEntry))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void registerEntryMoto() throws Exception {
		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_MOTORCYCLE)
				.conVehicleType(VehicleType.MOTO).build();

		mvc.perform(post(URL_ENTRADA).content(objectMapper.writeValueAsString(commandEntry))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void registrarSalidaMotoTest() {

		// arrage

		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conVehicleType(VehicleType.MOTO).build();

		// act
		CommandEntry registry = registerVehicleEntry.execute(commandEntry);

		Payment salidaRegistry = registrarSalidaCommand.execute(registry.getId());

		// assert
		assertNotNull(registry);
		assertNotNull(salidaRegistry);
	}

	@Test
	public void registrarSalidaCarTest() {

		// arrage

		CommandEntry commandEntry = CommandEntryBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conVehicleType(VehicleType.CARRO).build();

		// act
		CommandEntry registry = registerVehicleEntry.execute(commandEntry);

		Payment salidaRegistry = registrarSalidaCommand.execute(registry.getId());

		// assert
		assertNotNull(registry);
		assertNotNull(salidaRegistry);
	}
}
