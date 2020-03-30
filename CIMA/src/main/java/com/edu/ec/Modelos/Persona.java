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
import javax.validation.constraints.Size;


@Entity
@Table(name = "tbl_persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int per_id;
	
	@Size(min = 0, max = 50, message = "Numero de caracteres muy grande")
	private String per_nombre;
	
	@Size(min = 0, max = 50, message = "Numero de caracteres muy grande")
	private String per_apellido;
	
	@Temporal(TemporalType.DATE)
	private Date per_fecha_nacimiento;
	
	@ManyToOne
	@JoinColumn(name = "rol_persona_fk", referencedColumnName = "rol_id")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "login_persona_fk", referencedColumnName = "log_id")
	private Login login;

	public int getPer_id() {
		return per_id;
	}

	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}

	public String getPer_nombre() {
		return per_nombre;
	}

	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}

	public String getPer_apellido() {
		return per_apellido;
	}

	public void setPer_apellido(String per_apellido) {
		this.per_apellido = per_apellido;
	}

	public Date getPer_fecha_nacimiento() {
		return per_fecha_nacimiento;
	}

	public void setPer_fecha_nacimiento(Date per_fecha_nacimiento) {
		this.per_fecha_nacimiento = per_fecha_nacimiento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

}
