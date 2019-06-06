package com.ceiba.induccion.comun.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.comun.domain.entity.Vehiculo;
import com.ceiba.induccion.comun.domain.ports.SaveVehiculoService;
import com.ceiba.induccion.comun.infrastructure.entity.VehiculoEntity;
import com.ceiba.induccion.comun.infrastructure.mapper.MapperVehiculo;

@Repository
public class VehiculoRespositoryImpl implements SaveVehiculoService{

	@Autowired
	@Lazy
	private VehiculoRepository vehiculoRepository;

	@Autowired
	private MapperVehiculo vehiculoM;

	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = vehiculoRepository.save(vehiculoM.mapToEntity(vehiculo));
		vehiculo.setId(vehiculoEntity.getId());
		return vehiculo;
	}

}
