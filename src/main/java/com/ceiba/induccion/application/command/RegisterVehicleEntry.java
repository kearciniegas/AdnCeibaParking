package com.ceiba.induccion.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.domain.VigilantActivities;
import com.ceiba.induccion.domain.entity.Registry;


@Service
@Transactional
public class RegisterVehicleEntry {
	@Autowired
	VigilantActivities vigilantActivities;

	public Registry execute(Registry registry) {
		return vigilantActivities.registrarEntrada(registry);
	}

}
