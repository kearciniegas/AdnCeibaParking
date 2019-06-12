package com.ceiba.induccion.infrastructure.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.domain.entity.VehicleType;
import com.ceiba.induccion.infrastructure.entity.RegistryEntity;



@Repository
public interface RegistryRepository extends CrudRepository<RegistryEntity, Long> {

	@Query("SELECT COUNT(r) FROM registro r WHERE r.vehicleType = :vehicleType AND fin is null")
	int contarVehiculosEstacionados(@Param("vehicleType") VehicleType vehicleType);

	@Query("SELECT COUNT(r) FROM registro r WHERE r.placa = :placa AND fin is null")
	int contarVehiculosEstacionadosConPlaca(@Param("placa") String placa);

	List<RegistryEntity> findAll();

	@Override
	Optional<RegistryEntity> findById(Long aLong);
}
