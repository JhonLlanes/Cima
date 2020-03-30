package com.edu.ec.Favorito;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.edu.ec.Modelos.Edsm;

@Named
@SessionScoped
public class EdsmFavorito implements Serializable {
	
	private Edsm edsm;

	public Edsm getEdsm() {
		return edsm;
	}

	public void setEdsm(Edsm edsm) {
		this.edsm = edsm;
	}

}
