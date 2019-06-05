package com.ceiba.induccion.microservicios.command.infraestructura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.comun.domain.ActividadesVigilante;
import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.Vehiculo;

@Service
@Transactional
public class RegistrarEntradaVehiculos {
	@Autowired
	ActividadesVigilante procesos;

	public Registro execute(Vehiculo vehiculo) {
		return procesos.registrarEntrada(vehiculo);
	}

}
