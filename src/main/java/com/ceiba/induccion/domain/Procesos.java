package com.ceiba.induccion.domain;

import com.ceiba.induccion.domain.entity.Pago;
import com.ceiba.induccion.domain.entity.Registro;
import com.ceiba.induccion.domain.entity.Vehiculo;

public interface Procesos {

	Registro registrarIngreso(Vehiculo vehiculo);

	Pago registrarSalida(long idRegistro);
}
