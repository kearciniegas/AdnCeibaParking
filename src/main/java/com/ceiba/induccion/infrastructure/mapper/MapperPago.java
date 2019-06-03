package com.ceiba.induccion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.domain.entity.Pago;
import com.ceiba.induccion.infrastructure.entity.PagoEntity;

@Component
public class MapperPago {

	@Autowired
	private MapperRegistro mapperRegistro;

	public PagoEntity mapToEntity(Pago pago) {
		return new PagoEntity(pago.getId(), pago.getValor(), mapperRegistro.mapToEntity(pago.getRegistro()),
				pago.getUsuarioRegistro(), pago.getFechaRegistro());
	}
}
