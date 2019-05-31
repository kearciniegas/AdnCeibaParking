package com.ceiba.induccion.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ceiba.induccion.domain.entity.TipoVehiculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
	private Integer cilindraje;

	@Column
	private String usuarioRegistro;

	@Column
	private Date fechaRegistro;

	public VehiculoEntity() {
		super();
	}

	public VehiculoEntity(long id, String placa, TipoVehiculo tipo, Integer cilindraje, String usuarioRegistro,
			Date fechaRegistro) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}

}
