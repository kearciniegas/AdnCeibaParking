package com.ceiba.induccion.infrastructure.mapper;

import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.domain.entity.Registry;

public class CommandMapperEntry {

	public static Registry mapToRegistry(CommandEntry commandEntry) {
		return new Registry(commandEntry.getId(), commandEntry.getFechaEntrada(), commandEntry.getFechaSalida(),
				commandEntry.getPlaca(), commandEntry.getVehicleType(), commandEntry.getCilindraje());
	}

}
