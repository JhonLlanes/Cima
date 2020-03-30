package com.edu.ec.Favorito;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.edu.ec.Modelos.Persona;

@Named
@SessionScoped
public class UsuarioFavorito implements Serializable{
	
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}	
}
