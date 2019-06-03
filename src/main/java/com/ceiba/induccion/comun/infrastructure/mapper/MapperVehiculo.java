package com.ceiba.induccion.comun.infrastructure.mapper;

import com.ceiba.induccion.comun.domain.entity.Vehiculo;
import com.ceiba.induccion.comun.infrastructure.entity.VehiculoEntity;

public class MapperVehiculo {
	public Vehiculo mapToDomain(VehiculoEntity vehiculoEntity) throws Exception {
		return new Vehiculo(vehiculoEntity.getId(), vehiculoEntity.getPlaca(), vehiculoEntity.getTipo(),
				vehiculoEntity.getCilindraje(), vehiculoEntity.getUsuarioRegistro(), vehiculoEntity.getFechaRegistro());
	}

	public VehiculoEntity mapToEntity(Vehiculo vehiculo) {
		return new VehiculoEntity(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
				vehiculo.getCilindraje(), vehiculo.getUsuario(), vehiculo.getFechaRegistro());
	}
}
