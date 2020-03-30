package com.edu.ec.Util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ValidacionesUtil {

	public Date fechaactual() {

		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		String cadenaFecha = formato.format(fechaActual);
		System.out.println(cadenaFecha);
		return fechaActual;
	}

	public String edad( Date fechanacimiento ) {
		System.out.println("Fecha: " + fechanacimiento );
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String cadenaFecha = formato.format(fechanacimiento);
		
		System.out.println("Fecha String: " + cadenaFecha );
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(cadenaFecha, fmt);
		LocalDate ahora = LocalDate.now();
		
		
		Period periodo = Period.between(fechaNac, ahora);
		
		return periodo.getYears()+ " años " + periodo.getMonths()+ " meses " + periodo.getDays() +" días";
	}

}
