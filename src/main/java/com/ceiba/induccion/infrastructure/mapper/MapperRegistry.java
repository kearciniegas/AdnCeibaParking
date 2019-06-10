package com.ceiba.induccion.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.infrastructure.entity.RegistryEntity;

@Component
public class MapperRegistry {

	public RegistryEntity mapToEntity(Registry registry) {
		return new RegistryEntity(registry.getId(), registry.getFechaEntrada(), registry.getFechaSalida(),
				registry.getFechaRegistro(), registry.getPlaca(), registry.getVehicleType(), registry.getCilindraje());
	}

	public Registry mapToDomain(RegistryEntity registryEntity) {
		return new Registry(registryEntity.getId(), registryEntity.getInicio(), registryEntity.getFin(),
				registryEntity.getFechaRegistro(), registryEntity.getPlaca(), registryEntity.getVehicleType(),
				registryEntity.getCilindraje());
	}

	public List<Registry> mapToDomain(Iterable<RegistryEntity> listaEntidad) {
		List<Registry> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(registryEntity -> {
			Registry registry = new Registry(registryEntity.getId(), registryEntity.getInicio(),
					registryEntity.getFin(), registryEntity.getFechaRegistro(),
					registryEntity.getPlaca(), registryEntity.getVehicleType(), registryEntity.getCilindraje());
			listaRegistro.add(registry);
		});
		return listaRegistro;
	}

}
