package com.ceiba.induccion.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ceiba.induccion.domain.entity.VehicleType;

@Entity(name = "vehiculo")
public class VehicleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@Column
	private long cilindraje;

	@Column
	private Date fechaRegistro;

	public VehicleEntity() {
		super();
	}

	public VehicleEntity(long id, String placa, VehicleType vehicleType, long cilindraje, Date fechaRegistro) {
		super();
		this.id = id;
		this.placa = placa;
		this.vehicleType = vehicleType;
		this.cilindraje = cilindraje;
		this.fechaRegistro = fechaRegistro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
