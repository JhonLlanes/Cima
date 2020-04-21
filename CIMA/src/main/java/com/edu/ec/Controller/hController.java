package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.edu.ec.Bussines.EdsmBussines;
import com.edu.ec.Bussines.PersonaBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.UsuarioFavorito;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Persona;

@ManagedBean

public class hController {
	
	private List<Persona> listaEdsmEncargado;
	Persona per = new Persona();
	private String BuscarApellido;


	@Inject
	private EdsmFavorito edsmFav;
	
	@Inject
	private PersonaBussines perBus;
	
	@Inject
	private UsuarioFavorito usauriofav;
	
	@PostConstruct
	public void init() {
		per = usauriofav.getPersona();

		if (per.getRol().getRol_numero() == 1 || per.getRol().getRol_numero() == 2) {

			listaEdsmEncargado = perBus.listarEstudianteHistorial(usauriofav.getPersona());

		} else if (per.getRol().getRol_numero() == 3) {
			
		}

	}
	
	public void Buscar() {
		listaEdsmEncargado = perBus.BuscarlistarEstudianteHistorial(BuscarApellido, usauriofav.getPersona());
	}

	public String getBuscarApellido() {
		return BuscarApellido;
	}

	public void setBuscarApellido(String buscarApellido) {
		BuscarApellido = buscarApellido;
	}

	public List<Persona> getListaEdsmEncargado() {
		return listaEdsmEncargado;
	}

	public void setListaEdsmEncargado(List<Persona> listaEdsmEncargado) {
		this.listaEdsmEncargado = listaEdsmEncargado;
	}
	
	
	
	
}
