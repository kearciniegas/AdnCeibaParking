package com.ceiba.induccion.comun.domain;

import com.ceiba.induccion.comun.domain.entity.Registro;

public interface ReglasParking {
	
	double calcularPago(Registro registro);

	boolean existeEspacio(int numero);
}
