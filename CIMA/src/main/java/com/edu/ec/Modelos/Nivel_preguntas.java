package com.edu.ec.Modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_nivel_preguntas")
public class Nivel_preguntas {
	
	@Id
	private int niv_id;
	
	@Size(min = 0, max = 20, message = "Numero de caracteres muy grande")
	private String niv_nombre;
	private int niv_numero;
	public int getNiv_id() {
		return niv_id;
	}
	public void setNiv_id(int niv_id) {
		this.niv_id = niv_id;
	}
	public String getNiv_nombre() {
		return niv_nombre;
	}
	public void setNiv_nombre(String niv_nombre) {
		this.niv_nombre = niv_nombre;
	}
	public int getNiv_numero() {
		return niv_numero;
	}
	public void setNiv_numero(int niv_numero) {
		this.niv_numero = niv_numero;
	}
	
	

}
