package com.ceiba.induccion.infrastructure.mapper;

import com.ceiba.induccion.domain.entity.Vehiculo;
import com.ceiba.induccion.infrastructure.entity.VehiculoEntity;

public class MapperVehiculo {

	public Vehiculo mapToDomain(VehiculoEntity vehiculoEntity) throws Exception {
		return new Vehiculo(vehiculoEntity.getId(), vehiculoEntity.getPlaca(), vehiculoEntity.getTipo(),
				vehiculoEntity.getCilindraje(), vehiculoEntity.getUsuarioRegistro(), vehiculoEntity.getFechaRegistro());
	}

	public VehiculoEntity mapToEntity(Vehiculo vehiculo) {
		return new VehiculoEntity(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				vehiculo.getUsuario(), vehiculo.getFechaRegistro());
	}
}
