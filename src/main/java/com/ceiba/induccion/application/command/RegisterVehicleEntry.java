package com.ceiba.induccion.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.domain.VigilantActivities;
import com.ceiba.induccion.infrastructure.mapper.MapperRegistry;

@Service
@Transactional
public class RegisterVehicleEntry {
	@Autowired
	private VigilantActivities vigilantActivities;

	@Autowired
	private MapperRegistry mapperRegistry;

	public RegisterVehicleEntry(MapperRegistry mapperRegistry, VigilantActivities vigilantActivities) {
		this.mapperRegistry = mapperRegistry;
		this.vigilantActivities = vigilantActivities;
	}

	public CommandEntry execute(CommandEntry commandEntry) {
		CommandEntry registry = mapperRegistry.mapToRegistry(vigilantActivities.registrarEntrada(commandEntry));
		return registry;
	}

}
