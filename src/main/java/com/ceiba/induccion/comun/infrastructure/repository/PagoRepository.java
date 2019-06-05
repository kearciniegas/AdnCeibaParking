package com.ceiba.induccion.comun.infrastructure.repository;

import org.springframework.stereotype.Repository;

import com.ceiba.induccion.comun.infrastructure.entity.PagoEntity;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PagoRepository extends CrudRepository<PagoEntity, Long> {
	
}
