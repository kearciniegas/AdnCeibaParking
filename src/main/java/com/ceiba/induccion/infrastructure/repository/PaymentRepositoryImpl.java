package com.ceiba.induccion.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.ports.PaymentPort;
import com.ceiba.induccion.infrastructure.entity.PaymentEntity;
import com.ceiba.induccion.infrastructure.mapper.PaymentMapper;



@Repository
public class PaymentRepositoryImpl implements PaymentPort {

	@Autowired
	@Lazy
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public Payment save(Payment payment) {
		PaymentEntity paymentEntity = paymentRepository.save(paymentMapper.mapToEntity(payment));
		payment.setId(paymentEntity.getId());
		return payment;
	}
}
