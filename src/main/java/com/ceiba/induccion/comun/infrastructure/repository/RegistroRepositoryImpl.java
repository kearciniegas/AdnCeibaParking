package com.ceiba.induccion.comun.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.TipoVehiculo;
import com.ceiba.induccion.comun.domain.ports.GetRegistroService;
import com.ceiba.induccion.comun.infrastructure.entity.RegistroEntity;
import com.ceiba.induccion.comun.infrastructure.mapper.MapperRegistro;

@Repository
public class RegistroRepositoryImpl implements GetRegistroService {

	private static final int VEHICULOS_CERO = 0;

	@Autowired
	@Lazy
	private RegistroRepository registroRepo;

	@Autowired
	private MapperRegistro mapperRegistro;

	@Override
	public Registro save(Registro registro) {
		RegistroEntity registroEntity = registroRepo.save(mapperRegistro.mapToEntity(registro));
		registro.setId(registroEntity.getId());
		return registro;
	}

	@Override
	public Registro findById(long id) {
		Registro registro = null;
		Optional<RegistroEntity> opcional = registroRepo.findById(id);
		if (opcional.isPresent()) {
			registro = mapperRegistro.mapToDomain(opcional.get());
		}
		return registro;
	}

	@Override
	public boolean existeVehiculoEnEstacionamiento(String placa) {
		return registroRepo.contarVehiculosEstacionadosConPlaca(placa) > VEHICULOS_CERO;
	}

	@Override
	public int contarVehiculosEstacionados(TipoVehiculo tipoVehiculo) {
		return registroRepo.contarVehiculosEstacionados(tipoVehiculo);
	}

	@Override
	public List<Registro> listaVehiculosEstacionados() {
		return mapperRegistro.mapToDomain(registroRepo.findByFinIsNull());
	}
}
