package com.ceiba.induccion.comun.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.ports.GetRegistroService;

@Service
public class ParqueadosImpl implements Parqueados {
	@Autowired
	@Lazy
	private GetRegistroService registro;

	@Override
	public List<Registro> listaVehiculosEstacionados() {
		return registro.listaVehiculosEstacionados();
	}
}
