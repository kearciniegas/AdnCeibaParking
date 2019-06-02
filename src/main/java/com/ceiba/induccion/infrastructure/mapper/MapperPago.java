package com.ceiba.induccion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.induccion.domain.entity.Pago;
import com.ceiba.induccion.infrastructure.entity.PagoEntity;

public class MapperPago {

	@Autowired
	private MapperRegistro mapperRegistro;

	public PagoEntity mapToEntity(Pago pago) {
		return new PagoEntity(pago.getId(), pago.getValor(), registroMapper.mapToEntity(pago.getRegistro()),
				pago.getUsuarioRegistro(), pago.getFechaRegistro());
	}
}
