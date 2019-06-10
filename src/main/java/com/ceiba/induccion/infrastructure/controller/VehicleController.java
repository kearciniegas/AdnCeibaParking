package com.ceiba.induccion.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.application.command.RegisterVehicleEntry;
import com.ceiba.induccion.application.dto.VehicleDto;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.Vehicle;
import com.ceiba.induccion.domain.entity.VehicleType;

@RestController
@RequestMapping("vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {
	@Autowired
	private RegisterVehicleEntry registerVehicleEntryCommad;

	@PostMapping
	public Registry registrarIngreso(@RequestBody VehicleDto vehicleDto) {
		return registerVehicleEntryCommad.execute(new Vehicle(vehicleDto.getId(), vehicleDto.getPlaca(),
				VehicleType.valueOf(vehicleDto.getTipo()), vehicleDto.getCilindraje(), null));
	}
}
