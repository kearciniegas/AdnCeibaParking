package com.ceiba.induccion.comun.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.comun.application.dto.VehiculoDto;
import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.TipoVehiculo;
import com.ceiba.induccion.comun.domain.entity.Vehiculo;
import com.ceiba.induccion.microservicios.command.infraestructura.RegistrarEntradaVehiculos;

@RestController
@RequestMapping("vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {
	@Autowired
	private RegistrarEntradaVehiculos registrarEntradaCommad;

	@PostMapping
	public Registro registrarIngreso(@RequestBody VehiculoDto vehiculoDto) {
		return registrarEntradaCommad.execute(new Vehiculo(vehiculoDto.getId(), vehiculoDto.getPlaca(),
				TipoVehiculo.valueOf(vehiculoDto.getTipo()), vehiculoDto.getCilindraje(), null));
	}
}
