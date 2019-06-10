package com.ceiba.induccion.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.domain.VigilantActivities;
import com.ceiba.induccion.domain.entity.Payment;



@Service
@Transactional
public class RegisterVehiclesExit {

	@Autowired
	VigilantActivities vigilantActivities;

	public Payment execute(long idRegistro) {
		return vigilantActivities.registrarSalida(idRegistro);
	}
}
