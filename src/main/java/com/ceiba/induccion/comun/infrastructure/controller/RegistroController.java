package com.ceiba.induccion.comun.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.comun.domain.entity.Pago;
import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.microservicios.command.infraestructura.RegistrarSalidaVehiculos;
import com.ceiba.induccion.microservicios.query.infraestructura.QueryAllVehiculos;

@RestController
@RequestMapping("registros")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroController {
	@Autowired
	private RegistrarSalidaVehiculos registrarSalidaVehiculos;

	@Autowired
	private QueryAllVehiculos allVehiculos;

	@PatchMapping
	public Pago registrarSalida(long idRegistro) {
		return registrarSalidaVehiculos.execute(idRegistro);
	}

	@GetMapping
	public List<Registro> listar() {
		return allVehiculos.execute();
	}

}