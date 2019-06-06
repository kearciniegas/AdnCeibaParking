package com.ceiba.induccion.comun.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ceiba.induccion.comun.domain.entity.TipoVehiculo;

@Entity(name = "vehiculo")
public class VehiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoVehiculo tipo;

	@Column
	private long cilindraje;

	@Column
	private Date fechaRegistro;

	public VehiculoEntity() {
		super();
	}

	public VehiculoEntity(long id, String placa, TipoVehiculo tipo, long cilindraje, Date fechaRegistro) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
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

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
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
