package com.edu.ec.Modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_resultados")
public class Resultados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int res_id;
	
	@NotNull(message = "Ingrese las observaciones")
	private String res_obseraciones;
	
	@NotNull
	@Size(min = 0, max = 30, message = "Numero de caracteres muy grande")
	private String res_edad;	
	
	@NotNull(message = "No hay numero")
	private int res_A;
	@NotNull(message = "No hay numero")
	private int res_N;
	@NotNull(message = "No hay numero")
	private int res_P;
	
	@Temporal(TemporalType.DATE)
	private Date res_fecha;

	@ManyToOne
	@JoinColumn(name = "edsm_res_fk", referencedColumnName = "eds_id")
	private Edsm edsm;
	
	@ManyToOne
	@JoinColumn(name = "niv_res_fk", referencedColumnName = "niv_id")
	private Nivel_preguntas nivel;

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public String getRes_obseraciones() {
		return res_obseraciones;
	}

	public void setRes_obseraciones(String res_obseraciones) {
		this.res_obseraciones = res_obseraciones;
	}

	public String getRes_edad() {
		return res_edad;
	}

	public void setRes_edad(String res_edad) {
		this.res_edad = res_edad;
	}

	public int getRes_A() {
		return res_A;
	}

	public void setRes_A(int res_A) {
		this.res_A = res_A;
	}

	public int getRes_N() {
		return res_N;
	}

	public void setRes_N(int res_N) {
		this.res_N = res_N;
	}

	public int getRes_P() {
		return res_P;
	}

	public void setRes_P(int res_P) {
		this.res_P = res_P;
	}

	public Date getRes_fecha() {
		return res_fecha;
	}

	public void setRes_fecha(Date res_fecha) {
		this.res_fecha = res_fecha;
	}

	public Edsm getEdsm() {
		return edsm;
	}

	public void setEdsm(Edsm edsm) {
		this.edsm = edsm;
	}

	public Nivel_preguntas getNivel() {
		return nivel;
	}

	public void setNivel(Nivel_preguntas nivel) {
		this.nivel = nivel;
	}
	
}
