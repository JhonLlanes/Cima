package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Persona;
import com.edu.ec.Modelos.Resultados;

@Stateless
public class RespuestaDao {

	@Inject
	private EntityManager em;

	public void GuardarRespuesta(Resultados resultado) {
		em.persist(resultado);
	}

	public List<Resultados> listaRespuesta(Edsm edsm, Nivel_preguntas nivel) {
		String jpql = "SELECT n FROM Resultados n WHERE n.edsm=:edsmP AND n.nivel=:nivP ORDER BY n.res_id DESC ";
		Query query = em.createQuery(jpql, Resultados.class);
		query.setParameter("edsmP", edsm);
		query.setParameter("nivP", nivel);
		List<Resultados> ResultadoLista = query.getResultList();
		return ResultadoLista;
	}

	public void actualizarResultados(Resultados resultados) {

		em.merge(resultados);

	}
	public List<Resultados> listarHistorial(Edsm edsm) {
		String jpql = "SELECT n FROM Resultados n WHERE n.edsm=:edsmP ORDER BY n.res_id ASC ";
		Query query = em.createQuery(jpql, Resultados.class);
		query.setParameter("edsmP", edsm);
		List<Resultados> ResultadoLista = query.getResultList();
		return ResultadoLista;
	}
	
	public List<Resultados> listarhistorialPerosna(Persona persona) {
		String jpql = "SELECT n FROM Resultados n WHERE n.edsm.Persona=:edsmP ORDER BY n.nivel.niv_id ASC ";
		Query query = em.createQuery(jpql, Resultados.class);
		query.setParameter("edsmP", persona);
		List<Resultados> ResultadoLista = query.getResultList();
		return ResultadoLista;
	}

}
