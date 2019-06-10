package com.ceiba.induccion.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.infrastructure.entity.RegistryEntity;



@Component
public class MapperRegistry {
	@Autowired
	private VehicleMapper vehicleMapper;

	public RegistryEntity mapToEntity(Registry registry) {
		return new RegistryEntity(registry.getId(), vehicleMapper.mapToEntity(registry.getVehiculo()),
				registry.getFechaEntrada(), registry.getFechaSalida(), registry.getFechaRegistro());
	}

	public Registry mapToDomain(RegistryEntity registryEntity) {
		return new Registry(registryEntity.getId(), vehicleMapper.mapToDomain(registryEntity.getVehicleEntity()),
				registryEntity.getInicio(), registryEntity.getFin(), registryEntity.getFechaRegistro());
	}

	public List<Registry> mapToDomain(Iterable<RegistryEntity> listaEntidad) {
		List<Registry> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(registroEntity -> {
			Registry registry = new Registry(registroEntity.getId(),
					vehicleMapper.mapToDomain(registroEntity.getVehicleEntity()), registroEntity.getInicio(),
					registroEntity.getFin(), registroEntity.getFechaRegistro());
			listaRegistro.add(registry);
		});
		return listaRegistro;
	}

}
