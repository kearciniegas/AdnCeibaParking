package com.ceiba.induccion.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.infrastructure.entity.PaymentEntity;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {
	
}
