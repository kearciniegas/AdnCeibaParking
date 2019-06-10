package com.ceiba.induccion.domain.ports;

import com.ceiba.induccion.domain.entity.Vehicle;

public interface VehiclePort {
	Vehicle save(Vehicle vehicle);

}
