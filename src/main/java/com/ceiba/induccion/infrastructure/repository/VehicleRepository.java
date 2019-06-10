package com.ceiba.induccion.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.infrastructure.entity.VehicleEntity;


@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {

}
