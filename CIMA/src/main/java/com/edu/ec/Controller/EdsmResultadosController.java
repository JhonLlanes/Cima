package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Bussines.RespuestaBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.EdsmPreguntasResultados;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Resultados;
import com.edu.ec.Util.ValidacionesUtil;

@ManagedBean
@ViewScoped
public class EdsmResultadosController {

	private Resultados EntidadRespuesta;
	private List<EdsmPreguntasResultados> edsmResultados;
	private List<Resultados> ListaRespuestas;
	private PieChartModel model;

	List[] resultadosAreglo = new List[2];
	ValidacionesUtil val = new ValidacionesUtil();

	private String observacion;
	private int niv_bus = 1;

	private String edad;
	private String Nombre;

	@Inject
	private Edsm_preguntasBussines edsmpregBus;

	@Inject
	private RespuestaBussines respBussines;

	@Inject
	private EdsmFavorito edsmFav;

	@PostConstruct
	public void init() {

		Nombre = edsmFav.getEdsm().getPersona().getPer_nombre() + " "
				+ edsmFav.getEdsm().getPersona().getPer_apellido();
		edad = val.edad(edsmFav.getEdsm().getPersona().getPer_fecha_nacimiento());
		respuestaNivel1();

	}

	public void respuestaNivel1() {

		if (niv_bus == 1) {
			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);

			ListaRespuestas = respBussines.listaRespuesta(edsmFav.getEdsm(), nivel);
			if (ListaRespuestas.size() == 0) {
				observacion = "";
				saveMessage("NO EVALUADO");
			} else {
				EntidadRespuesta = ListaRespuestas.get(0);
				observacion = EntidadRespuesta.getRes_obseraciones();
				saveMessage("ESTE NIVEL YA FUE EVALUADO");
			}

			resultadosAreglo = edsmpregBus.TemporalResultado(edsmFav.getEdsm(), nivel);
			edsmResultados = resultadosAreglo[0];

			model = new PieChartModel();
			model.set(" A " + resultadosAreglo[1].get(0), (int) resultadosAreglo[1].get(0));
			model.set(" N " + resultadosAreglo[1].get(1), (int) resultadosAreglo[1].get(1));
			model.set(" P " + resultadosAreglo[1].get(2), (int) resultadosAreglo[1].get(2));
			model.setTitle("Resultados");
			model.setShadow(false);
			model.setShowDataLabels(true);
			model.setLegendPosition("w");

		}
		if (niv_bus == 2) {

			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);

			ListaRespuestas = respBussines.listaRespuesta(edsmFav.getEdsm(), nivel);
			if (ListaRespuestas.size() == 0) {
				observacion = "";
				saveMessage("NO EVALUADO");
			} else {
				EntidadRespuesta = ListaRespuestas.get(0);
				observacion = EntidadRespuesta.getRes_obseraciones();
				saveMessage("ESTE NIVEL YA FUE EVALUADO");
			}

			resultadosAreglo = edsmpregBus.TemporalResultado(edsmFav.getEdsm(), nivel);
			edsmResultados = resultadosAreglo[0];

			model = new PieChartModel();
			model.set(" A " + resultadosAreglo[1].get(0), (int) resultadosAreglo[1].get(0));
			model.set(" N " + resultadosAreglo[1].get(1), (int) resultadosAreglo[1].get(1));
			model.set(" P " + resultadosAreglo[1].get(2), (int) resultadosAreglo[1].get(2));
			model.setTitle("Resultados");
			model.setShadow(false);
			model.setShowDataLabels(true);
			model.setLegendPosition("w");

		}
		if (niv_bus == 3) {

			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);

			ListaRespuestas = respBussines.listaRespuesta(edsmFav.getEdsm(), nivel);
			if (ListaRespuestas.size() == 0) {
				observacion = "";
				saveMessage("NO EVALUADO");
			} else {
				EntidadRespuesta = ListaRespuestas.get(0);
				observacion = EntidadRespuesta.getRes_obseraciones();
				saveMessage("ESTE NIVEL YA FUE EVALUADO");
			}

			resultadosAreglo = edsmpregBus.TemporalResultado(edsmFav.getEdsm(), nivel);
			edsmResultados = resultadosAreglo[0];

			model = new PieChartModel();
			model.set(" A " + resultadosAreglo[1].get(0), (int) resultadosAreglo[1].get(0));
			model.set(" N " + resultadosAreglo[1].get(1), (int) resultadosAreglo[1].get(1));
			model.set(" P " + resultadosAreglo[1].get(2), (int) resultadosAreglo[1].get(2));
			model.setTitle("Resultados");
			model.setShadow(false);
			model.setShowDataLabels(true);
			model.setLegendPosition("w");

		}
		if (niv_bus == 4) {

			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);

			ListaRespuestas = respBussines.listaRespuesta(edsmFav.getEdsm(), nivel);
			if (ListaRespuestas.size() == 0) {
				observacion = "";
				saveMessage("NO EVALUADO");
			} else {
				EntidadRespuesta = ListaRespuestas.get(0);
				observacion = EntidadRespuesta.getRes_obseraciones();
				saveMessage("ESTE NIVEL YA FUE EVALUADO");
			}

			resultadosAreglo = edsmpregBus.TemporalResultado(edsmFav.getEdsm(), nivel);
			edsmResultados = resultadosAreglo[0];

			model = new PieChartModel();
			model.set(" A " + resultadosAreglo[1].get(0), (int) resultadosAreglo[1].get(0));
			model.set(" N " + resultadosAreglo[1].get(1), (int) resultadosAreglo[1].get(1));
			model.set(" P " + resultadosAreglo[1].get(2), (int) resultadosAreglo[1].get(2));
			model.setTitle("Resultados");
			model.setShadow(false);
			model.setShowDataLabels(true);
			model.setLegendPosition("w");
		}

	}

	public void guardarResultado() {

		if (ListaRespuestas.size() == 0) {

			Nivel_preguntas nivel = new Nivel_preguntas();
			nivel.setNiv_id(niv_bus);

			Resultados Res = new Resultados();
			Res.setNivel(nivel);
			Res.setEdsm(edsmFav.getEdsm());
			Res.setRes_fecha(val.fechaactual());
			Res.setRes_edad(val.edad(edsmFav.getEdsm().getPersona().getPer_fecha_nacimiento()));
			Res.setRes_A((int) resultadosAreglo[1].get(0));
			Res.setRes_N((int) resultadosAreglo[1].get(1));
			Res.setRes_P((int) resultadosAreglo[1].get(2));
			Res.setRes_obseraciones(observacion);
			respBussines.GuardarRespuesta(Res);
			saveMessage("SE GUARDO CORRECTAMENTE");

		} else {

			EntidadRespuesta.setRes_obseraciones(observacion);
			respBussines.actualizarResultados(EntidadRespuesta);
			saveMessage("RESPUESTA ACTUALIZADA");
		}

	}

	public List<EdsmPreguntasResultados> getEdsmResultados() {
		return edsmResultados;
	}

	public void setEdsmResultados(List<EdsmPreguntasResultados> edsmResultados) {
		this.edsmResultados = edsmResultados;
	}

	public PieChartModel getModel() {
		return model;
	}

	public int getNiv_bus() {
		return niv_bus;
	}

	public void setNiv_bus(int niv_bus) {
		this.niv_bus = niv_bus;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void saveMessage(String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("CORRECTO", mensaje));
	}

	public Resultados getEntidadRespuesta() {
		return EntidadRespuesta;
	}

	public void setEntidadRespuesta(Resultados entidadRespuesta) {
		EntidadRespuesta = entidadRespuesta;
	}

	public List<Resultados> getListaRespuestas() {
		return ListaRespuestas;
	}

	public void setListaRespuestas(List<Resultados> listaRespuestas) {
		ListaRespuestas = listaRespuestas;
	}

}
