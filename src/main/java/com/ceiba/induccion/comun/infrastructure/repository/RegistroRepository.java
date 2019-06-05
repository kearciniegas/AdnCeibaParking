package com.ceiba.induccion.comun.infrastructure.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.comun.domain.entity.TipoVehiculo;
import com.ceiba.induccion.comun.infrastructure.entity.RegistroEntity;

@Repository
public interface RegistroRepository extends CrudRepository<RegistroEntity, Long> {

	@Query("SELECT COUNT(r) FROM registro r WHERE r.vehiculo.tipo = :tipo AND fin is null")
	int contarVehiculosEstacionados(@Param("tipo") TipoVehiculo tipo);

	@Query("SELECT COUNT(r) FROM registro r WHERE r.vehiculo.placa = :placa AND fin is null")
	int contarVehiculosEstacionadosConPlaca(@Param("placa") String placa);

	List<RegistroEntity> findByFinIsNull();
}
