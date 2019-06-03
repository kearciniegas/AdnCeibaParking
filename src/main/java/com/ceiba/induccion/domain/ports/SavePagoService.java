package com.ceiba.induccion.domain.ports;

import com.ceiba.induccion.domain.entity.Pago;

public interface SavePagoService {
	Pago save(Pago pago);
}
