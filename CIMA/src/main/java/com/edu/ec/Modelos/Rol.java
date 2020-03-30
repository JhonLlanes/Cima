package com.edu.ec.Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_rol")
public class Rol {
	
	@Id
	private int rol_id;
	
	private String rol_nombre;
	private int rol_numero;
	
	public int getRol_id() {
		return rol_id;
	}
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}
	public String getRol_nombre() {
		return rol_nombre;
	}
	public void setRol_nombre(String rol_nombre) {
		this.rol_nombre = rol_nombre;
	}
	public int getRol_numero() {
		return rol_numero;
	}
	public void setRol_numero(int rol_numero) {
		this.rol_numero = rol_numero;
	}	
}
