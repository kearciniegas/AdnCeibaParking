package com.ceiba.induccion.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private double valor;

	@OneToOne(optional = false)
	@JoinColumn(name = "registro")
	private RegistroEntity registroEntity;

	@Column(nullable = false)
	private String usuarioRegistro;

	@Column(nullable = false)
	private Date fechaRegistro;

	public PagoEntity(long id, double valor, RegistroEntity registroEntity, String usuarioRegistro,
			Date fechaRegistro) {
		super();
		this.id = id;
		this.valor = valor;
		this.registroEntity = registroEntity;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}	
}
