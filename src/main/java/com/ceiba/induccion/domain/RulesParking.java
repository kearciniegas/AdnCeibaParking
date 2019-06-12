package com.ceiba.induccion.domain;

import com.ceiba.induccion.domain.entity.Registry;

public interface RulesParking {

	double calcularPago(Registry registry);

	boolean existeEspacio(int numero);
}
