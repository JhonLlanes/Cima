package com.edu.ec.Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_edsmpreguntas")
public class Edsm_preguntas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eds_pre_id;
	
	@Size(min = 0, max = 5, message = "Numero de caracteres muy grande")
	private String eds_pre_observador;
	@Size(min = 0, max = 5, message = "Numero de caracteres muy grande")
	private String eds_pre_informador;
		
	
	@ManyToOne
	@JoinColumn(name = "preguntas_edsmP_fk", referencedColumnName = "pre_id")
	private Preguntas preguntas;
	
	@ManyToOne
	@JoinColumn(name = "edsm_edsmP_fk", referencedColumnName = "eds_id")
	private Edsm edsm;

	public int getEds_pre_id() {
		return eds_pre_id;
	}

	public void setEds_pre_id(int eds_pre_id) {
		this.eds_pre_id = eds_pre_id;
	}

	public String getEds_pre_observador() {
		return eds_pre_observador;
	}

	public void setEds_pre_observador(String eds_pre_observador) {
		this.eds_pre_observador = eds_pre_observador;
	}

	public String getEds_pre_informador() {
		return eds_pre_informador;
	}

	public void setEds_pre_informador(String eds_pre_informador) {
		this.eds_pre_informador = eds_pre_informador;
	}

	public Preguntas getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}

	public Edsm getEdsm() {
		return edsm;
	}

	public void setEdsm(Edsm edsm) {
		this.edsm = edsm;
	}

}
