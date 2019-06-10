package com.ceiba.induccion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.infrastructure.entity.PaymentEntity;



@Component
public class PaymentMapper {

	@Autowired
	private MapperRegistry mapperRegistry;

	public PaymentEntity mapToEntity(Payment payment) {
		return new PaymentEntity(payment.getId(), payment.getValor(), mapperRegistry.mapToEntity(payment.getRegistry()),
				payment.getFechaRegistro());
	}
}
