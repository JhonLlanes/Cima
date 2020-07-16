package com.edu.ec.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.edu.ec.Bussines.LoginBussines;
import com.edu.ec.Bussines.PersonaBussines;
import com.edu.ec.Favorito.UsuarioFavorito;
import com.edu.ec.Modelos.Login;
import com.edu.ec.Modelos.Persona;
import com.edu.ec.Modelos.Rol;

@ManagedBean
public class PersonaController {

	private  String verficar_contra;
	private  String verficar_contra_1;
	
	// para mostrar el mensaje 
	private  String res_contra;

	@Inject
	private LoginBussines logBus;

	@Inject
	private PersonaBussines perBus;

	@Inject
	private UsuarioFavorito usauriofav;

	Persona persona = new Persona();
	Login login = new Login();
	Rol rol = new Rol();

	@PostConstruct
	public void init() {

	}

	public String guardar() {
		try {

			if (usauriofav.getPersona().getRol().getRol_numero() == 1
					|| (usauriofav.getPersona().getRol().getRol_numero() == 2)) {
				System.out.print(res_contra);
				if (handleKeyEvent() == true) {
					
					login.setLog_contrasena(verficar_contra_1);
					
					int idLogin = logBus.guardarLogin(login);
					
					Login log = new Login();
					log.setLog_id(idLogin);
					persona.setLogin(log);
					persona.setRol(rol);
					persona.setPersonaencargada(usauriofav.getPersona());
					
					perBus.guardarPersona(persona);
					addMessage("Guardado");
					return "Edsm?faces-redirect=true";
					
				}else {
					addMessage("ERROR EN LA CONTRASEÑA");
				}

				
			} else {
				addMessage("No puede ingresar a personas");

			}
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("ERROR");
		}
		return null;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getVerficar_contra() {
		return verficar_contra;
	}

	public void setVerficar_contra(String verficar_contra) {
		this.verficar_contra = verficar_contra;
	}

	public boolean handleKeyEvent() {
		
		System.out.println(verficar_contra + verficar_contra_1);
		
		if (verficar_contra.equals(verficar_contra_1)) {
			res_contra = "COINCIDE";
			return true;
		} else {
			
			res_contra = "no coinciden";
		}
		if (verficar_contra_1.equals(verficar_contra)) {
			res_contra = "COINCIDE";
			return true;
		} else {
			res_contra = "no coinciden";
		}
		
		return false;

	}


	public String getRes_contra() {
		return res_contra;
	}

	public void setRes_contra(String res_contra) {
		this.res_contra = res_contra;
	}

	public String getVerficar_contra_1() {
		return verficar_contra_1;
	}

	public void setVerficar_contra_1(String verficar_contra_1) {
		this.verficar_contra_1 = verficar_contra_1;
	}
}
