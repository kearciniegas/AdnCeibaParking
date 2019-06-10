package com.ceiba.induccion.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Vehicle;
import com.ceiba.induccion.infrastructure.entity.VehicleEntity;

@Component
public class VehicleMapper {
	public Vehicle mapToDomain(VehicleEntity vehiculoEntity) {
		return new Vehicle(vehiculoEntity.getId(), vehiculoEntity.getPlaca(), vehiculoEntity.getVehicleType(),
				vehiculoEntity.getCilindraje(), vehiculoEntity.getFechaRegistro());
	}

	public VehicleEntity mapToEntity(Vehicle vehiculo) {
		return new VehicleEntity(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getVehicleType(),
				vehiculo.getCilindraje(), vehiculo.getFechaRegistro());
	}
}
