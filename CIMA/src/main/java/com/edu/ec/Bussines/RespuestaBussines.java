package com.edu.ec.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import com.edu.ec.Dao.RespuestaDao;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Resultados;

@Stateless
public class RespuestaBussines {

	@Inject
	private RespuestaDao resDao;

	public void GuardarRespuesta(Resultados resultado) {
		resDao.GuardarRespuesta(resultado);
	}

	public List<Resultados> listaRespuesta(Edsm edsm, Nivel_preguntas nivel) {
		return resDao.listaRespuesta(edsm, nivel);
	}

	public void actualizarResultados(Resultados resultados) {
		resDao.actualizarResultados(resultados);
	}
	
	public List<Resultados> listarHistorial(Edsm edsm) {
		return resDao.listarHistorial(edsm);
	}

}
