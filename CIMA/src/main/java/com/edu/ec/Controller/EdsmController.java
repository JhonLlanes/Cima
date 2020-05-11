package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Bussines.EdsmBussines;
import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Bussines.PersonaBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.UsuarioFavorito;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Persona;
import com.edu.ec.Util.ValidacionesUtil;

@ManagedBean
public class EdsmController {
	
	private List <Persona> personaEstudiante;
	private List <Edsm> listaEdsmEncargado;
	Edsm edsmIngreso = new Edsm();
	
	private String BuscarApellido;
	
	public static int id_per_seleccionada;
	
	@Inject
	private PersonaBussines perBus;
	
	@Inject
	private EdsmBussines edsmBus;
	
	@Inject
	private Edsm_preguntasBussines edsmPreBus;
	
	@Inject
	private EdsmFavorito edsmFav;
	
	@Inject
	private UsuarioFavorito usauriofav;
	
	@PostConstruct
	public void init() {
		personaEstudiante = perBus.listarEstudiante();
		listaEdsmEncargado = edsmBus.listarEdsm(usauriofav.getPersona());
	}	
	
	public void Guardar(Persona persona) {
		id_per_seleccionada = persona.getPer_id();
		addMessage("Ha selccionadado a: " +persona.getPer_nombre() +" "+ persona.getPer_apellido());
	}
	public void craerEdsm() {
		try {
			ValidacionesUtil valida = new ValidacionesUtil();
			Persona est = new Persona();
			est.setPer_id(id_per_seleccionada);
			edsmIngreso.setEds_fecha(valida.fechaactual());
			edsmIngreso.setPersona(est);
			edsmIngreso.setPersona_encargada(usauriofav.getPersona());
			edsmPreBus.ingresar(edsmBus.crearEdsm(edsmIngreso));
			listaEdsmEncargado = edsmBus.listarEdsm(usauriofav.getPersona());
			addMessage("Guardado");
		} catch (Exception e) {
			addMessage("Error");
		}
		
	}
	
	public void BuscarPersonasEdsm() {
		
		personaEstudiante = perBus.BuscarlistarEstudianteHistorialTodos(BuscarApellido);
	}
	
	public String desarrollaredsm(Edsm edsmpf) {
		edsmFav.setEdsm(edsmpf);
		return "Esm_Preguntas?faces-redirect=true";
		
	}
	
	public String resultadoEdsm(Edsm edsmpf) {
		edsmFav.setEdsm(edsmpf);
		return "EdsmRespuesta?faces-redirect=true";
		
	}

	public Edsm getEdsmIngreso() {
		return edsmIngreso;
	}

	public void setEdsmIngreso(Edsm edsmIngreso) {
		this.edsmIngreso = edsmIngreso;
	}

	public List<Persona> getPersonaEstudiante() {
		return personaEstudiante;
	}

	public void setPersonaEstudiante(List<Persona> personaEstudiante) {
		this.personaEstudiante = personaEstudiante;
	}
	
	
	public List<Edsm> getListaEdsmEncargado() {
		return listaEdsmEncargado;
	}

	public void setListaEdsmEncargado(List<Edsm> listaEdsmEncargado) {
		this.listaEdsmEncargado = listaEdsmEncargado;
	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public String getBuscarApellido() {
		return BuscarApellido;
	}

	public void setBuscarApellido(String buscarApellido) {
		BuscarApellido = buscarApellido;
	}
	
	
}
