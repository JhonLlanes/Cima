package com.edu.ec.Favorito;

import org.primefaces.model.chart.PieChartModel;

import com.edu.ec.Modelos.Nivel_preguntas;

public class ModeloHistorial {
	
	private String mod_descripcion;
	private String mod_fecha;
	private String mod_edad;
	private Nivel_preguntas nivel;
	private PieChartModel model;
	public String getMod_descripcion() {
		return mod_descripcion;
	}
	public void setMod_descripcion(String mod_descripcion) {
		this.mod_descripcion = mod_descripcion;
	}
	public String getMod_fecha() {
		return mod_fecha;
	}
	public void setMod_fecha(String mod_fecha) {
		this.mod_fecha = mod_fecha;
	}
	public String getMod_edad() {
		return mod_edad;
	}
	public void setMod_edad(String mod_edad) {
		this.mod_edad = mod_edad;
	}
	public Nivel_preguntas getNivel() {
		return nivel;
	}
	public void setNivel(Nivel_preguntas nivel) {
		this.nivel = nivel;
	}
	public PieChartModel getModel() {
		return model;
	}
	public void setModel(PieChartModel model) {
		this.model = model;
	}
	
}
