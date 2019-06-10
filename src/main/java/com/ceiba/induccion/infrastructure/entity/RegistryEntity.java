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

@Entity(name = "registro")
public class RegistryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private Date inicio;

	@Column
	private Date fin;

	@Column
	private Date fechaRegistro;
	
	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@Column
	private long cilindraje;

	public RegistryEntity(long id,  Date inicio, Date fin, Date fechaRegistro,String placa,VehicleType vehicleType,long cilindraje) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.fechaRegistro = fechaRegistro;
		this.placa = placa;
		this.vehicleType = vehicleType;
		this.cilindraje = cilindraje;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	
}
