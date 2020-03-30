package com.edu.ec.Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int log_id;
	
	@Size(min = 0, max = 50, message = "Numero de caracteres muy grande")
	private String log_usuario;
	
	@Size(min = 0, max = 50, message = "Numero de caracteres muy grande")
	private String log_contrasena;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getLog_usuario() {
		return log_usuario;
	}
	public void setLog_usuario(String log_usuario) {
		this.log_usuario = log_usuario;
	}
	public String getLog_contrasena() {
		return log_contrasena;
	}
	public void setLog_contrasena(String log_contrasena) {
		this.log_contrasena = log_contrasena;
	}
}
