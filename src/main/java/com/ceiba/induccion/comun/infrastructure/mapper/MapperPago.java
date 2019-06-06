package com.ceiba.induccion.comun.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.comun.domain.entity.Pago;
import com.ceiba.induccion.comun.infrastructure.entity.PagoEntity;

@Component
public class MapperPago {

	@Autowired
	private MapperRegistro mapperRegistro;

	public PagoEntity mapToEntity(Pago pago) {
		return new PagoEntity(pago.getId(), pago.getValor(), mapperRegistro.mapToEntity(pago.getRegistro()),
				pago.getFechaRegistro());
	}
}
