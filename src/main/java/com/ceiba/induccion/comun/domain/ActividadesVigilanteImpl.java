package com.ceiba.induccion.comun.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.comun.domain.entity.Pago;
import com.ceiba.induccion.comun.domain.entity.Registro;
import com.ceiba.induccion.comun.domain.entity.Vehiculo;
import com.ceiba.induccion.comun.domain.excepcion.Excepciones;
import com.ceiba.induccion.comun.domain.ports.GetRegistroService;
import com.ceiba.induccion.comun.domain.ports.SavePagoService;
import com.ceiba.induccion.comun.domain.ports.SaveVehiculoService;

@Transactional
@Service
public class ActividadesVigilanteImpl implements ActividadesVigilante {

	public static final String SMS_ERROR_NO_PUEDE_INGRESO_ENTRE_SEMANA = "Para el vehiculo esta prohibido ingresar entre semana";
	public static final String SMS_ERROR_NO_ESPACIO = "El parqueadero no cuenta con espacios para guardar el vehiculo";
	public static final String SMS_ERROR_YA_ESTACIONADO = "El vehiculo ya esta parqueado";


	@Autowired
	private ReglasParkingImpl reglasParking;
	
	@Autowired
	private SavePagoService savePagoService;

	@Autowired
	private SaveVehiculoService saveVehiculoService;

	@Autowired
	private GetRegistroService getRegistroService;


	@Override
	public Registro registrarEntrada(Vehiculo vehiculo) {
		if (reglasParking.validarSiExisteRestriccion(vehiculo.getPlaca())) {
			throw new Excepciones(SMS_ERROR_NO_PUEDE_INGRESO_ENTRE_SEMANA);
		}

		int numeroVehiculos = getRegistroService.contarVehiculosEstacionados(vehiculo.getTipoVehiculo());
		if (!reglasParking.validarSiHayEspacio(vehiculo.getTipoVehiculo(), numeroVehiculos)) {
			throw new Excepciones(SMS_ERROR_NO_ESPACIO);
		}

		if (getRegistroService.existeVehiculoEnEstacionamiento(vehiculo.getPlaca())) {
			throw new Excepciones(SMS_ERROR_YA_ESTACIONADO);
		}

		vehiculo.setFechaRegistro(new Date());
		vehiculo = saveVehiculoService.save(vehiculo);

		Registro registro = new Registro(vehiculo);
		registro = getRegistroService.save(registro);
		return registro;
	}

	@Override
	public Pago registrarSalida(long idRegistro) {
		Registro registro = getRegistroService.findById(idRegistro);
		registro.setFechaSalida(new Date());
		getRegistroService.save(registro);

		double costoCalculado = reglasParking.ejecutarCalculo(registro);
		Pago pago = new Pago(costoCalculado, registro);
		return savePagoService.save(pago);
	}

}
