package com.ceiba.induccion.comun.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class WatchfulImpl {

	public LocalDateTime localDateTime(Date currentDate) {
		return currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public long hoursBetweenDate(Date fechaInicio, Date fechaFin) {
		LocalDateTime fechaInicioLocal = localDateTime(fechaInicio);
		LocalDateTime fechaFinLocal = localDateTime(fechaFin);
		return ChronoUnit.HOURS.between(fechaInicioLocal, fechaFinLocal);
	}

	public Date date(LocalDateTime currentDate) {
		return Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
	}

	public DayOfWeek dayOfWeek(Date date) {
		LocalDateTime fechaLocal = localDateTime(date);
		return fechaLocal.getDayOfWeek();
	}
}
