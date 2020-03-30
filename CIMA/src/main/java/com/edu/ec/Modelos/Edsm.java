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

@Entity
@Table(name = "tbl_edsm")
public class Edsm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eds_id ;
	
	private String eds_detalle;
	
	@Temporal(TemporalType.DATE)
	private Date eds_fecha;	
		
	@ManyToOne
	@JoinColumn(name = "persona_edsm_fk", referencedColumnName = "per_id")
	private Persona Persona;
	
	@ManyToOne
	@JoinColumn(name = "persona_edsm_encargada_fk", referencedColumnName = "per_id")
	private Persona Persona_encargada;
	

	public int getEds_id() {
		return eds_id;
	}

	public void setEds_id(int eds_id) {
		this.eds_id = eds_id;
	}

	public Date getEds_fecha() {
		return eds_fecha;
	}

	public void setEds_fecha(Date eds_fecha) {
		this.eds_fecha = eds_fecha;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}

	public Persona getPersona_encargada() {
		return Persona_encargada;
	}

	public void setPersona_encargada(Persona persona_encargada) {
		Persona_encargada = persona_encargada;
	}

	public String getEds_detalle() {
		return eds_detalle;
	}

	public void setEds_detalle(String eds_detalle) {
		this.eds_detalle = eds_detalle;
	}

}
