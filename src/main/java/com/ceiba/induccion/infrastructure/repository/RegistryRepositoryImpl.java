package com.ceiba.induccion.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.infrastructure.entity.RegistryEntity;
import com.ceiba.induccion.infrastructure.mapper.MapperRegistry;

@Repository
public class RegistryRepositoryImpl implements GetPortRegistration {

	private static final int VEHICULOS_CERO = 0;

	@Autowired
	@Lazy
	private RegistryRepository registryRepository;

	@Autowired
	private MapperRegistry mapperRegistry;

	@Override
	public Registry save(Registry registry) {
		RegistryEntity registroEntity = registryRepository.save(mapperRegistry.mapToEntity(registry));
		registry.setId(registroEntity.getId());
		return registry;
	}

	@Override
	public Registry findById(long id) {
		Registry registry = null;
		Optional<RegistryEntity> opcional = registryRepository.findById(id);
		if (opcional.isPresent()) {
			registry = mapperRegistry.mapToDomain(opcional.get());
		}
		return registry;
	}

	@Override
	public boolean existeVehiculoEnEstacionamiento(String placa) {
		return registryRepository.contarVehiculosEstacionadosConPlaca(placa) > VEHICULOS_CERO;
	}

	@Override
	public int contarVehiculosEstacionados(VehicleType vehicleType) {
		return registryRepository.contarVehiculosEstacionados(vehicleType);
	}

	@Override
	public List<Registry> listaVehiculosEstacionados() {
		return mapperRegistry.mapToDomain(registryRepository.findByFinIsNull());
	}
}
