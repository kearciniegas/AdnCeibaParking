package com.ceiba.induccion.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.ports.GetPortRegistration;

@Service
public class ParkedImpl implements Parked {
	@Autowired
	@Lazy
	private GetPortRegistration getPortRegistration;

	@Override
	public List<Registry> listaVehiculosEstacionados() {
		return getPortRegistration.listaVehiculosEstacionados();
	}
}
