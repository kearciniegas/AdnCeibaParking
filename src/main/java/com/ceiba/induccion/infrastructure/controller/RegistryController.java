package com.ceiba.induccion.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.application.command.RegisterVehiclesExit;
import com.ceiba.induccion.application.dto.RegistryDto;
import com.ceiba.induccion.application.query.QueryAllVehicle;
import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

@RestController
@RequestMapping("registros")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistryController {
	@Autowired
	private RegisterVehiclesExit registerVehiclesExit;

	@Autowired
	private QueryAllVehicle allVehicle;

	@Autowired
	private RegisterVehicleEntry registerVehicleEntryCommad;

	@PostMapping(value = "entrada")
	public CommandEntry registrarIngreso(@RequestBody RegistryDto registryDto) {
		CommandEntry commandEntry = new CommandEntry(registryDto.getPlaca(),
													VehicleType.valueOf(registryDto.getVehicleType()), 
													registryDto.getCilindraje());
		return registerVehicleEntryCommad.execute(commandEntry);
	}

	@PatchMapping(value = "salida/{id}")
	public Payment registrarSalida(@PathVariable long id) {
		return registerVehiclesExit.execute(id);
	}

	@GetMapping(value = "lista")
	public List<Registry> listar() {
		return allVehicle.execute();
	}

}