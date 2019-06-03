package com.ceiba.induccion.comun.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.infrastructure.entity.RegistroEntity;

public class MapperRegistro {
	@Autowired
	private MapperVehiculo mapperVehiculo;

	public RegistroEntity mapToEntity(Registro registro) {
		return new RegistroEntity(registro.getId(), mapperVehiculo.mapToEntity(registro.getVehiculo()),
				registro.getFechaEntrada(), registro.getFechaSalida(), registro.getUsuario(),
				registro.getFechaRegistro());
	}

	public Registro mapToDomain(RegistroEntity registroEntidad) throws Exception {
		return new Registro(registroEntidad.getId(), mapperVehiculo.mapToDomain(registroEntidad.getVehiculo()),
				registroEntidad.getInicio(), registroEntidad.getFin(), registroEntidad.getUsuarioRegistro(),
				registroEntidad.getFechaRegistro());
	}

	public List<Registro> mapToDomain(Iterable<RegistroEntity> listaEntidad) {
		List<Registro> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(registroEntidad -> {
			Registro registro = null;
			try {
				registro = new Registro(registroEntidad.getId(),
						mapperVehiculo.mapToDomain(registroEntidad.getVehiculo()), registroEntidad.getInicio(),
						registroEntidad.getFin(), registroEntidad.getUsuarioRegistro(),
						registroEntidad.getFechaRegistro());
			} catch (Exception e) {
				e.printStackTrace();
			}
			listaRegistro.add(registro);
		});
		return listaRegistro;
	}
}
