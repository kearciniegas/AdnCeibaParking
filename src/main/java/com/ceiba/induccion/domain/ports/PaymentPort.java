package com.ceiba.induccion.domain.ports;

import com.ceiba.induccion.domain.entity.Payment;

public interface PaymentPort {
	Payment save(Payment payment);
}
