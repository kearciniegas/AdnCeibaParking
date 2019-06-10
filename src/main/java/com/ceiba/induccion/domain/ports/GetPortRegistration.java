package com.ceiba.induccion.domain.ports;

import java.util.List;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

public interface GetPortRegistration {

	Registry save(Registry registry);

	Registry findById(long id);

	int contarVehiculosEstacionados(VehicleType vehicleType);

	boolean existeVehiculoEnEstacionamiento(String placa);

	List<Registry> listaVehiculosEstacionados();

}
