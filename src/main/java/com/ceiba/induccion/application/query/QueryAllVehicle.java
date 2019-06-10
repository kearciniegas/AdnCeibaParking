package com.ceiba.induccion.application.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.domain.Parked;
import com.ceiba.induccion.domain.entity.Registry;

@Service
@Transactional
public class QueryAllVehicle {
	@Autowired
	Parked parked;

	public List<Registry> execute() {
		return parked.listaVehiculosEstacionados();
	}
}
