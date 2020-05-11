package com.edu.ec.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import com.edu.ec.Bussines.EdsmBussines;
import com.edu.ec.Bussines.PersonaBussines;
import com.edu.ec.Bussines.RespuestaBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.EdsmPreguntasResultados;
import com.edu.ec.Favorito.ModeloHistorial;
import com.edu.ec.Favorito.UsuarioFavorito;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Persona;
import com.edu.ec.Modelos.Resultados;

@ManagedBean

public class hController {
	
	private List<Persona> listaEdsmEncargado;
	private List<ModeloHistorial> modelohistorialfinal;
	
	private List<Resultados> resultadosPersonas;
	
	private PieChartModel model;
	 
	Persona per = new Persona();
	private String BuscarApellido;


	@Inject
	private EdsmFavorito edsmFav;
	
	@Inject
	private PersonaBussines perBus;
	
	@Inject
	private RespuestaBussines respBus;
	
	
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
	
	public void buscarpersonas(Persona per) {
		resultadosPersonas = respBus.listarhistorialPerosna(per);
		
		
		List<ModeloHistorial> modeloHistorial = new ArrayList<>();
		for (Resultados resultados : resultadosPersonas) {
			
			PieChartModel modeloprivado = new PieChartModel(); 
			ModeloHistorial mod = new ModeloHistorial();
			mod.setMod_descripcion(resultados.getRes_obseraciones());
			mod.setMod_edad(resultados.getRes_edad());
			mod.setNivel(resultados.getNivel());
			mod.setMod_fecha(""+resultados.getRes_fecha());

			modeloprivado.set(" A " , resultados.getRes_A());
			modeloprivado.set(" N " , resultados.getRes_N());
			modeloprivado.set(" P " , resultados.getRes_P());
			modeloprivado.setTitle("Resultados");
			modeloprivado.setShadow(false);
			modeloprivado.setShowDataLabels(true);
			modeloprivado.setLegendPosition("w"); 
	        
	        mod.setModel(modeloprivado);
			
		
	        modeloHistorial.add(mod);
		}
		
		modelohistorialfinal = modeloHistorial;
		
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

	public List<Resultados> getResultadosPersonas() {
		return resultadosPersonas;
	}

	public void setResultadosPersonas(List<Resultados> resultadosPersonas) {
		this.resultadosPersonas = resultadosPersonas;
	}

	public List<ModeloHistorial> getModelohistorialfinal() {
		return modelohistorialfinal;
	}

	public void setModelohistorialfinal(List<ModeloHistorial> modelohistorialfinal) {
		this.modelohistorialfinal = modelohistorialfinal;
	}
	
	
	
	
}
