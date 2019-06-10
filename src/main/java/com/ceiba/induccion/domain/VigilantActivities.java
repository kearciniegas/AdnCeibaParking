package com.ceiba.induccion.domain;

import com.ceiba.induccion.domain.entity.Payment;
import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.Vehicle;

public interface VigilantActivities {

	Registry registrarEntrada(Vehicle vehicle);

	Payment registrarSalida(long idRegistro);
}
