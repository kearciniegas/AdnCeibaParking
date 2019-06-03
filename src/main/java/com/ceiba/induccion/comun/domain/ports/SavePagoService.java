package com.ceiba.induccion.comun.domain.ports;

import com.ceiba.induccion.comun.domain.entity.Pago;

public interface SavePagoService {
	Pago save(Pago pago);
}
