package com.ceiba.induccion.domain;

import com.ceiba.induccion.domain.entity.Registry;

public class RulesParkingCarImpl implements RulesParking {

    public static final int MAX_CARROS_PARQUEADERO = 20;
    public static final double VALOR_HORA_CARRO = 1_000;
    public static final double VALOR_DIA_CARRO = 8_000;
    private static final long HORAS_MINIMO_COBRO_CARRO = 1;
    private static final long HORAS_PARQUEADERO_DIA = 8;
    private static final long HORAS_DIA_CARRO = 24;
    
    
    private VigilantImpl vigilantImpl;


    public RulesParkingCarImpl(VigilantImpl vigilantImpl) {
		this.vigilantImpl = vigilantImpl;
	}

    @Override
    public double calcularPago(Registry registry) {
        double costo = 0;
        long totalHoras = vigilantImpl.hoursBetweenDate(registry.getFechaEntrada(), registry.getFechaSalida());
        long diasParqueo =  totalHoras / HORAS_DIA_CARRO;
        long horasParqueo = totalHoras % HORAS_DIA_CARRO;
        costo = diasParqueo * VALOR_DIA_CARRO;
        if (horasParqueo < HORAS_MINIMO_COBRO_CARRO) {
            costo = VALOR_HORA_CARRO;
        } else if (horasParqueo <= HORAS_PARQUEADERO_DIA) {
            costo += horasParqueo * VALOR_HORA_CARRO;
        } else {
            costo += VALOR_DIA_CARRO;
        }
        return costo;
    }

    @Override
    public boolean existeEspacio(int numero) {
        return numero < MAX_CARROS_PARQUEADERO;
    }
}
