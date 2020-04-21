package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Bussines.EdsmBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.UsuarioFavorito;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Persona;

@ManagedBean
public class menuController {

	private List<Edsm> listaEdsmEncargado;
	Persona per = new Persona();
	private String BuscarApellido;

	@Inject
	private UsuarioFavorito usauriofav;

	@Inject
	private EdsmBussines edsmBus;

	@Inject
	private EdsmFavorito edsmFav;

	@PostConstruct
	public void init() {
		per = usauriofav.getPersona();

		if (per.getRol().getRol_numero() == 1 || per.getRol().getRol_numero() == 2) {

			listaEdsmEncargado = edsmBus.listarEdsm(per);

		} else if (per.getRol().getRol_numero() == 3) {

			listaEdsmEncargado = edsmBus.listarEdsmEst(per);
		}

	}

	public String ingresarPersona() {

		if (per.getRol().getRol_numero() == 1 || per.getRol().getRol_numero() == 2) {

			return "IngresoPersona?faces-redirect=true";
		} else {

			info("No tiene los permisos");
		}
		return null;
	}

	public String desarrollaredsm(Edsm edsmpf) {
		if (per.getRol().getRol_numero() == 1 || per.getRol().getRol_numero() == 2) {

			edsmFav.setEdsm(edsmpf);
			return "Esm_Preguntas?faces-redirect=true";

		} else if (per.getRol().getRol_numero() == 3) {

			edsmFav.setEdsm(edsmpf);
			return "EdsmLlenarUsuario?faces-redirect=true";

		}

		return null;

	}

	public String resultadoEdsm(Edsm edsmpf) {
		if (per.getRol().getRol_numero() == 1 || per.getRol().getRol_numero() == 2) {

			edsmFav.setEdsm(edsmpf);
			return "EdsmRespuesta?faces-redirect=true";

		}
		
		return null;
		

	}

	public String resultadoHistorial(Edsm edsmpf) {
		edsmFav.setEdsm(edsmpf);
		return "historial?faces-redirect=true";

	}

	public String crearEdsm() {

		if (usauriofav.getPersona().getRol().getRol_numero() == 1
				|| (usauriofav.getPersona().getRol().getRol_numero() == 2)) {
			return "Edsm?faces-redirect=true";
		} else {

			info("N0 PUEDE INGRESAR");
		}

		return null;
	}
	
	
	public String h1() {

		if (usauriofav.getPersona().getRol().getRol_numero() == 1
				|| (usauriofav.getPersona().getRol().getRol_numero() == 2)) {
			return "h1?faces-redirect=true";
		} else {

			info("N0 PUEDE INGRESAR");
		}

		return null;
	}

	public void Buscar() {
		listaEdsmEncargado = edsmBus.BuscarEdsm(BuscarApellido, usauriofav.getPersona());
	}

	public Persona getPer() {
		return per;
	}

	public void setPer(Persona per) {
		this.per = per;
	}

	public void info(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje));
	}

	public void warn() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	}

	public void fatal() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
	}

	public List<Edsm> getListaEdsmEncargado() {
		return listaEdsmEncargado;
	}

	public void setListaEdsmEncargado(List<Edsm> listaEdsmEncargado) {
		this.listaEdsmEncargado = listaEdsmEncargado;
	}

	public String getBuscarApellido() {
		return BuscarApellido;
	}

	public void setBuscarApellido(String buscarApellido) {
		BuscarApellido = buscarApellido;
	}

}
