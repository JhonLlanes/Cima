package com.edu.ec.Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Bussines.PreguntasBussines;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Preguntas;

@ManagedBean
@ViewScoped
public class PreguntasController implements Serializable {
	private List<Preguntas> PreguntasTem;
	
	
	
	Edsm_preguntas edsmpre = new Edsm_preguntas();
	
	@Inject
	private PreguntasBussines preBus;

	@PostConstruct
	public void init() {	
		Nivel_preguntas n  = new Nivel_preguntas();
		n.setNiv_id(2);
		PreguntasTem = preBus.listarporNivel(n);
	}
	
	public void comenzar(String informador) {		
		System.out.println(informador);
		
		addMessage(informador);
	}


	public List<Preguntas> getPreguntasTem() {
		return PreguntasTem;
	}


	public void setPreguntasTem(List<Preguntas> preguntasTem) {
		PreguntasTem = preguntasTem;
	}
	
	
	
	
    public Edsm_preguntas getEdsmpre() {
		return edsmpre;
	}

	public void setEdsmpre(Edsm_preguntas edsmpre) {
		this.edsmpre = edsmpre;
	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
}
