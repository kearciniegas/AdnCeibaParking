package com.ceiba.induccion.comun.domain;

import com.ceiba.induccion.comun.domain.entity.Pago;
import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.Vehiculo;

public interface ActividadesVigilante {

	Registro registrarIngreso(Vehiculo vehiculo);

	Pago registrarSalida(long idRegistro);
}
