package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;

@Stateless
public class Edsm_PreguntaDao {

	@Inject
	private EntityManager em;

	public void ingresar(Edsm_preguntas esdmpre) {
		em.persist(esdmpre);
	}

	public void listar() {

	}

	public List<Edsm_preguntas> listarEdsmPregunta(Edsm edsm, Nivel_preguntas nivel) {
		String jpql = "SELECT n FROM Edsm_preguntas n WHERE n.edsm=:edsmP AND n.preguntas.nivel=:nivP ORDER BY n.preguntas.pre_id ASC ";
		Query query = em.createQuery(jpql, Edsm_preguntas.class);
		query.setParameter("edsmP", edsm);
		query.setParameter("nivP", nivel);
		List<Edsm_preguntas> edsmPreguntasLista = query.getResultList();
		return edsmPreguntasLista;
	}
	
	public void actualizarEdsmPreguntas (Edsm_preguntas esdmpre) {
		em.merge(esdmpre);
	}

	public void Contar(Edsm edsm, Nivel_preguntas nivel) {

		String jpql = "SELECT n FROM Edsm_preguntas n WHERE n.eds_pre_informador is null AND n.eds_pre_observador is null AND "
				+ "n.edsm=:edsmP AND n.preguntas.nivel=:nivP  ";
		Query query = em.createQuery(jpql, Edsm_preguntas.class);
		query.setParameter("edsmP", edsm);
		query.setParameter("nivP", nivel);
		List<Edsm_preguntas> edsmPreguntasLista = query.getResultList();
		;
		System.out.println(" ------- >" + edsmPreguntasLista.size());

	}
	


}
