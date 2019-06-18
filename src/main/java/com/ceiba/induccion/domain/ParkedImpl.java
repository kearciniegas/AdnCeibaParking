package com.ceiba.induccion.domain;

import java.util.List;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.ports.GetPortRegistration;

public class ParkedImpl implements Parked {

	private GetPortRegistration getPortRegistration;

	public ParkedImpl(GetPortRegistration getPortRegistration) {
		this.getPortRegistration = getPortRegistration;
	}

	@Override
	public List<Registry> listaVehiculosEstacionados() {
		return getPortRegistration.listaVehiculosEstacionados();
	}
}
