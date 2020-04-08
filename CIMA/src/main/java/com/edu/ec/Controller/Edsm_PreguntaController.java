package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;

@ManagedBean
@ViewScoped
public class Edsm_PreguntaController {

	private List<Edsm_preguntas> edsmTemp;
	private int niv_bus = 1;
	private String Nombre;

	@Inject
	private Edsm_preguntasBussines edsmpregBus;

	@Inject
	private EdsmFavorito edsmFav;

	@PostConstruct
	public void init() {
		Nombre = edsmFav.getEdsm().getPersona().getPer_nombre() + " "
				+ edsmFav.getEdsm().getPersona().getPer_apellido();	
		
		respuestaNivel1();

	}

	public void respuestaNivel1() {

		if (niv_bus == 1) {
			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);
			edsmTemp = edsmpregBus.Contarlistar(edsmFav.getEdsm(), nivel);

		}
		if (niv_bus == 2) {
			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);
			edsmTemp = edsmpregBus.Contarlistar(edsmFav.getEdsm(), nivel);

		}
		if (niv_bus == 3) {
			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);
			edsmTemp = edsmpregBus.Contarlistar(edsmFav.getEdsm(), nivel);

		}
		if (niv_bus == 4) {
			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);
			edsmTemp = edsmpregBus.Contarlistar(edsmFav.getEdsm(), nivel);
		}

	}

	public void actualizarEdsmPreguntas(Edsm_preguntas edsmPregunta) {
		edsmpregBus.actualizarEdsmPreguntas(edsmPregunta);
		addMessage("Infromador" + edsmPregunta.getEds_pre_informador() + " Observador "
				+ edsmPregunta.getEds_pre_observador());
	}
	
	public void actualizarTodolosdatos() {
		
		try {
			
			for (int i = 0; i < edsmTemp.size(); i++) {			
				edsmpregBus.actualizarEdsmPreguntas(edsmTemp.get(i));
			}	
			
			addMessage("SE GUARDARON LAS PREGUNTAS");
			
		} catch (Exception e) {
			// TODO: handle exception	
			addMessage("ERRO AL GUARDAR");
		}
	}
	

	public List<Edsm_preguntas> getEdsmTemp() {
		return edsmTemp;
	}

	public void setEdsmTemp(List<Edsm_preguntas> edsmTemp) {
		this.edsmTemp = edsmTemp;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public int getNiv_bus() {
		return niv_bus;
	}

	public void setNiv_bus(int niv_bus) {
		this.niv_bus = niv_bus;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	

}
