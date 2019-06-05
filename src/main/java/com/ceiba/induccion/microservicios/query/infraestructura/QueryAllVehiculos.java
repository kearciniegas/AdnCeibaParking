package com.ceiba.induccion.microservicios.query.infraestructura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.comun.domain.Parqueados;
import com.ceiba.induccion.comun.domain.entity.Registro;



@Service
@Transactional
public class QueryAllVehiculos {
	@Autowired
	Parqueados parqueados;

	public List<Registro> execute() {
		return parqueados.listaVehiculosEstacionados();
	}
}
