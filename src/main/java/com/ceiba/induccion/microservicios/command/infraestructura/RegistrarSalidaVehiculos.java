package com.ceiba.induccion.microservicios.command.infraestructura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.comun.domain.ActividadesVigilante;
import com.ceiba.induccion.comun.domain.entity.Pago;

@Service
@Transactional
public class RegistrarSalidaVehiculos {

	@Autowired
	ActividadesVigilante actividadesVigilante;

	public Pago execute(long idRegistro) {
		return actividadesVigilante.registrarSalida(idRegistro);
	}
}
