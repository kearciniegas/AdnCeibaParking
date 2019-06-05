package com.ceiba.induccion.comun.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.infrastructure.entity.RegistroEntity;

@Component
public class MapperRegistro {
	@Autowired
	private MapperVehiculo mapperVehiculo;

	public RegistroEntity mapToEntity(Registro registro) {
		return new RegistroEntity(registro.getId(), mapperVehiculo.mapToEntity(registro.getVehiculo()),
				registro.getFechaEntrada(), registro.getFechaSalida(), registro.getFechaRegistro());
	}

	public Registro mapToDomain(RegistroEntity registroEntity){
		return new Registro(registroEntity.getId(), mapperVehiculo.mapToDomain(registroEntity.getVehiculo()),
				registroEntity.getInicio(), registroEntity.getFin(), registroEntity.getFechaRegistro());
	}

	public List<Registro> mapToDomain(Iterable<RegistroEntity> listaEntidad) {
		List<Registro> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(registroEntity -> {
			Registro registro = new Registro(registroEntity.getId(),
						mapperVehiculo.mapToDomain(registroEntity.getVehiculo()),registroEntity.getInicio(),registroEntity.getFin(), registroEntity.getFechaRegistro());
			listaRegistro.add(registro);
		});
		return listaRegistro;
	}
	
	



	
}
