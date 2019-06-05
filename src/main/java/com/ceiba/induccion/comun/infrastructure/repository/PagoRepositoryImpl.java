package com.ceiba.induccion.comun.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.comun.domain.entity.Pago;
import com.ceiba.induccion.comun.domain.ports.SavePagoService;
import com.ceiba.induccion.comun.infrastructure.entity.PagoEntity;
import com.ceiba.induccion.comun.infrastructure.mapper.MapperPago;

@Repository
public class PagoRepositoryImpl implements SavePagoService {

	@Autowired
	private PagoRepository pagoRepository;

	@Autowired
	private MapperPago pagoM;

	@Override
	public Pago save(Pago pago) {
		PagoEntity pagoEntity = pagoRepository.save(pagoM.mapToEntity(pago));
		pago.setId(pagoEntity.getId());
		return pago;
	}
}
