package com.edu.ec.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.edu.ec.Dao.PreguntasDao;
import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Preguntas;

@Stateless
public class PreguntasBussines {

	@Inject
	private PreguntasDao preDao;
	
	public List<Preguntas> listarporNivel(Nivel_preguntas n) {
		return preDao.listarporNivel(n);
	}
	

	
	
}
