package com.ceiba.induccion.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.domain.entity.Vehicle;
import com.ceiba.induccion.domain.ports.VehiclePort;
import com.ceiba.induccion.infrastructure.entity.VehicleEntity;
import com.ceiba.induccion.infrastructure.mapper.VehicleMapper;



@Repository
public class VehicleRespositoryImpl implements VehiclePort{

	@Autowired
	@Lazy
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	public Vehicle save(Vehicle vehiculo) {
		VehicleEntity vehiculoEntity = vehicleRepository.save(vehicleMapper.mapToEntity(vehiculo));
		vehiculo.setId(vehiculoEntity.getId());
		return vehiculo;
	}

}
