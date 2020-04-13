package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Bussines.RespuestaBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.EdsmPreguntasResultados;
import com.edu.ec.Modelos.Resultados;

@ManagedBean
public class ResultadoController {
	
	private List<Resultados> ListaRespuestas;
	
	private List<EdsmPreguntasResultados> listaNo;
	
	@Inject
	private RespuestaBussines respBussines;
	
	@Inject
	private Edsm_preguntasBussines edsmpreguntasBussines;
	
	@Inject
	private EdsmFavorito edsmFav;
	
	@PostConstruct
	public void init() {		
	
		ListaRespuestas = respBussines.listarHistorial(edsmFav.getEdsm());
		listaNo = edsmpreguntasBussines.Listarnegativos(edsmFav.getEdsm());
	}

	public List<Resultados> getListaRespuestas() {
		return ListaRespuestas;
	}

	public void setListaRespuestas(List<Resultados> listaRespuestas) {
		ListaRespuestas = listaRespuestas;
	}

	public List<EdsmPreguntasResultados> getListaNo() {
		return listaNo;
	}

	public void setListaNo(List<EdsmPreguntasResultados> listaNo) {
		this.listaNo = listaNo;
	}
	
	
	
}
