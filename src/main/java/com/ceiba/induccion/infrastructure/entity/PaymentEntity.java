package com.ceiba.induccion.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "pago")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private double valor;

    @OneToOne(optional = false)
    @JoinColumn(name = "registro")
    private RegistryEntity registryEntity;


    public PaymentEntity() {
    }

    public PaymentEntity(long id, double valor, RegistryEntity registryEntity) {
        super();
        this.id = id;
        this.valor = valor;
        this.registryEntity = registryEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public RegistryEntity getRegistryEntity() {
        return registryEntity;
    }

    public void setRegistryEntity(RegistryEntity registryEntity) {
        this.registryEntity = registryEntity;
    }
}
