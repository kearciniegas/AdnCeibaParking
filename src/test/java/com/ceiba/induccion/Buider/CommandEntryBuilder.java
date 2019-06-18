package com.ceiba.induccion.Buider;

import java.util.Date;

import com.ceiba.induccion.application.command.CommandEntry;
import com.ceiba.induccion.domain.entity.VehicleType;

public class CommandEntryBuilder {
	private Date fechaEntrada;
	private Date fechaSalida;
	private String placa;
	private VehicleType vehicleType;
	private long cilindraje;
	
	public CommandEntryBuilder() {
		super();
	}
	
	public static CommandEntryBuilder defaultValues() {
		return new CommandEntryBuilder();
	}
	
	public CommandEntryBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public CommandEntryBuilder conVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	
	public CommandEntryBuilder conFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada; 
		return this;
	}
	
	public CommandEntryBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida; 
		return this;
	}
	
	public CommandEntryBuilder conCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public CommandEntry build() {
		return new CommandEntry(0, fechaEntrada, fechaSalida, placa, vehicleType, cilindraje);
	}
}
