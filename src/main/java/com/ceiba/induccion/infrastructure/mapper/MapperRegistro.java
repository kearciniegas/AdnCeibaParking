package com.ceiba.induccion.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.induccion.domain.entity.Registro;
import com.ceiba.induccion.infrastructure.entity.RegistroEntity;

public class MapperRegistro {
	@Autowired
	private MapperVehiculo MapperVehiculo;

	public Registro mapToDomain(RegistroEntity registroEntidad) {
		return new Registro(registroEntidad.getId(), vehiculoMapper.mapToDomain(registroEntidad.getVehiculo()),
				registroEntidad.getInicio(), registroEntidad.getFin(), registroEntidad.getUsuarioRegistro(),
				registroEntidad.getFechaRegistro());
	}

	public List<Registro> mapToDomain(Iterable<RegistroEntity> listaEntidad) {
		List<Registro> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(registroEntidad -> {
			Registro registro = new Registro(registroEntidad.getId(),
					vehiculoMapper.mapToDomain(registroEntidad.getVehiculo()), registroEntidad.getInicio(),
					registroEntidad.getFin(), registroEntidad.getUsuarioRegistro(), registroEntidad.getFechaRegistro());
			listaRegistro.add(registro);
		});
		return listaRegistro;
	}

	public RegistroEntity mapToEntity(Registro registro) {
		return new RegistroEntity(registro.getId(), vehiculoMapper.mapToEntity(registro.getVehiculo()),
				registro.getInicio(), registro.getFin(), registro.getUsuarioRegistro(), registro.getFechaRegistro());
	}
}
