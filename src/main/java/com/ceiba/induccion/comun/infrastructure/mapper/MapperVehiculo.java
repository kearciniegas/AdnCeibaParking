package com.ceiba.induccion.comun.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.induccion.comun.domain.entity.Vehiculo;
import com.ceiba.induccion.comun.infrastructure.entity.VehiculoEntity;

@Component
public class MapperVehiculo {
	public Vehiculo mapToDomain(VehiculoEntity vehiculoEntity) {
		return new Vehiculo(vehiculoEntity.getId(), vehiculoEntity.getPlaca(), vehiculoEntity.getTipo(),
				vehiculoEntity.getCilindraje(), vehiculoEntity.getFechaRegistro());
	}

	public VehiculoEntity mapToEntity(Vehiculo vehiculo) {
		return new VehiculoEntity(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
				vehiculo.getCilindraje(), vehiculo.getFechaRegistro());
	}
}
