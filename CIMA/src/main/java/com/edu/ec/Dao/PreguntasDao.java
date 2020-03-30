package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Preguntas;

@Stateless
public class PreguntasDao {

	@Inject
	private EntityManager em;

	public List<Preguntas> listarporNivel(Nivel_preguntas niv) {

		String jpql = "SELECT n FROM Preguntas n WHERE n.nivel=:nivP";
		Query query = em.createQuery(jpql, Preguntas.class);
		query.setParameter("nivP", niv);
		List<Preguntas> listadoPreguntas = query.getResultList();
		for (Preguntas preguntas : listadoPreguntas) {
			System.out.println(preguntas.getPre_nombre());
		}
		return listadoPreguntas;
	}
	
	public List<Preguntas> listarporTodas() {
		String jpql = "SELECT n FROM Preguntas n ";
		Query query = em.createQuery(jpql, Preguntas.class);
		List<Preguntas> listadoPreguntas = query.getResultList();
		return listadoPreguntas;
	}
	
}
