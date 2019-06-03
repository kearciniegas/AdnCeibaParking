package com.ceiba.induccion.comun.domain.ports;

import java.util.List;

import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.TipoVehiculo;



public interface GetRegistroService {
	Registro save(Registro registro);

	Registro findById(long id);

	int contarVehiculosEstacionados(TipoVehiculo tipoVehiculo);

	boolean existeVehiculoEnEstacionamiento(String placa);

	List<Registro> listarVehiculosEstacionados();

}
