package com.ceiba.induccion.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RegistroEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "vehiculo")
	private VehiculoEntity vehiculo;

	@Column(nullable = false)
	private Date inicio;

	@Column
	private Date fin;

	@Column
	private String usuarioRegistro;

	@Column
	private Date fechaRegistro;

	public RegistroEntity(long id, VehiculoEntity vehiculo, Date inicio, Date fin, String usuarioRegistro,
			Date fechaRegistro) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.inicio = inicio;
		this.fin = fin;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
