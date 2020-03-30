package com.edu.ec.Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_preguntas")
public class Preguntas {
	
	@Id
	private int pre_id;
	
	@Size(min = 0, max = 50, message = "Numero de caracteres muy grande")
	private String pre_nombre;
	private String pre_descripcion;
	
	@ManyToOne
	@JoinColumn(name = "niv_preguntas_fk", referencedColumnName = "niv_id")
	private Nivel_preguntas nivel;

	public int getPre_id() {
		return pre_id;
	}

	public void setPre_id(int pre_id) {
		this.pre_id = pre_id;
	}

	public String getPre_nombre() {
		return pre_nombre;
	}

	public void setPre_nombre(String pre_nombre) {
		this.pre_nombre = pre_nombre;
	}

	public String getPre_descripcion() {
		return pre_descripcion;
	}

	public void setPre_descripcion(String pre_descripcion) {
		this.pre_descripcion = pre_descripcion;
	}

	public Nivel_preguntas getNivel() {
		return nivel;
	}

	public void setNivel(Nivel_preguntas nivel) {
		this.nivel = nivel;
	}
	
}
