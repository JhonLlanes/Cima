package com.edu.ec.Controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Favorito.UsuarioFavorito;
import com.edu.ec.Modelos.Persona;

@ManagedBean
public class SesionesController {

	@Inject
	private UsuarioFavorito usuraiofav;
	
	String sesion;
	
	@PostConstruct
	public void init() {
	
		Persona p = usuraiofav.getPersona();
		
		try {
			
			if (p==null ) {
				
				redirigir();
				
			}else {
				
				sesion =  usuraiofav.getPersona().getPer_nombre()+" "+usuraiofav.getPersona().getPer_apellido();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	

	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
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
	
	public String IRmenu() {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("/CIMA/Menu.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
}
