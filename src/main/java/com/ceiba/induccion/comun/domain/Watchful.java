package com.ceiba.induccion.comun.domain;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class Watchful {
	public DayOfWeek weekDays(Date currentDate) {
		LocalDateTime fechaLocal = localDateTime(currentDate);
		return fechaLocal.getDayOfWeek();
	}
	public LocalDateTime localDateTime(Date currentDate) {
		return currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public long horasEntreFechas(Date fechaInicio, Date fechaFin) {
		LocalDateTime fechaInicioLocal = localDateTime(fechaInicio);
		LocalDateTime fechaFinLocal = localDateTime(fechaFin);
		return ChronoUnit.HOURS.between(fechaInicioLocal, fechaFinLocal);
	}
	
	public Date date(LocalDateTime currentDate) {
		return (Date) Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
	}
}
