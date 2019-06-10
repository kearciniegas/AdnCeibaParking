package com.ceiba.induccion.domain;

import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.Registry;

public interface VigilantActivities {

	Payment registrarSalida(long idRegistro);

	Registry registrarEntrada(Registry registry);
}
