package com.ceiba.induccion.comun.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.comun.infrastructure.entity.VehiculoEntity;

@Repository
public interface VehiculoRepository extends CrudRepository<VehiculoEntity, Long> {

}
