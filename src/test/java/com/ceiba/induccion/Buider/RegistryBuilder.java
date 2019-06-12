package com.ceiba.induccion.Buider;

import java.util.Date;

import com.ceiba.induccion.domain.entity.Registry;
import com.ceiba.induccion.domain.entity.VehicleType;

public class RegistryBuilder {
	private long id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String placa;
	private VehicleType vehicleType;
	private long cilindraje;
	
	private RegistryBuilder() {
		super();
	}
	
	public static RegistryBuilder defaultValues() {
		return new RegistryBuilder();
	}
	
	public RegistryBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public RegistryBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public RegistryBuilder conVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	
	public RegistryBuilder conFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada; 
		return this;
	}
	
	public RegistryBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida; 
		return this;
	}
	
	public RegistryBuilder conCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Registry build() {
		return new Registry(id, fechaEntrada, fechaSalida, placa, vehicleType, cilindraje);
	}
}
