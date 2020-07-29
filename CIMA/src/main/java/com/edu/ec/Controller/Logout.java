package com.edu.ec.Controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Favorito.UsuarioFavorito;

@ManagedBean
public class Logout {
	
	@Inject
	private UsuarioFavorito usauriofav;
	
	
	
	public String salir() {
		usauriofav.setPersona(null);
		redirigir();
		return "index?faces-redirect=true";
	}
	
	public String redirigir() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("/CIMA/Index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
