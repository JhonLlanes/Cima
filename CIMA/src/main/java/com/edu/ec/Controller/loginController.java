package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Modelos.Login;
import com.edu.ec.Bussines.LoginBussines;
import com.edu.ec.Bussines.PersonaBussines;
import com.edu.ec.Favorito.UsuarioFavorito;

@ManagedBean
public class loginController {
	
	private String usuario;
	private String contra;
	private List<Login> loginLista;
	
	@Inject
	private UsuarioFavorito usauriofav;
	
	@Inject
	private PersonaBussines perBus;

	@Inject
	private LoginBussines logbus;
	
	@PostConstruct
	public void init() {
		
	}
	
	public String login() {
		
		
		loginLista = logbus.logginaplicacion(usuario, contra);
		System.out.println();
		if (loginLista.size() >= 1) {
			usauriofav.setPersona(perBus.listarLogin(loginLista.get(0)));
			info(usauriofav.getPersona().getPer_apellido() + usauriofav.getPersona().getPer_nombre());
			return "Menu?faces-redirect=true";
		}else {
			error("USUARIO NO ENCONTRADO");
		}
		
		return null;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public List<Login> getLoginLista() {
		return loginLista;
	}

	public void setLoginLista(List<Login> loginLista) {
		this.loginLista = loginLista;
	}
	
	public void info(String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje));
    }
     
    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }
     
    public void error(String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", mensaje));
    }
     
    public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }
}
