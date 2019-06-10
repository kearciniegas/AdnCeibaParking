package com.ceiba.induccion.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.application.command.RegisterVehiclesExit;
import com.ceiba.induccion.application.query.QueryAllVehicle;
import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.Registry;



@RestController
@RequestMapping("registros")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistryController {
	@Autowired
	private RegisterVehiclesExit registerVehiclesExit;

	@Autowired
	private QueryAllVehicle allVehicle;

	@PatchMapping
	public Payment registrarSalida(long idRegistro) {
		return registerVehiclesExit.execute(idRegistro);
	}

	@GetMapping
	public List<Registry> listar() {
		return allVehicle.execute();
	}

}