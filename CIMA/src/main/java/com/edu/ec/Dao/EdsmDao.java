package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Persona;

@Stateless
public class EdsmDao {

	@Inject
	private EntityManager em;

	public Edsm crearEdsm(Edsm edsm) {
		em.persist(edsm);
		return edsm;
	}

	public List<Edsm> listarEdsm(Persona personaEncargada) {

		String jpql = "SELECT n FROM Edsm n WHERE n.Persona_encargada=:perEn ORDER BY n.eds_id DESC ";
		Query query = em.createQuery(jpql, Edsm.class);
		query.setParameter("perEn", personaEncargada);
		List<Edsm> listadoEdsmEncargado = query.getResultList();
		return listadoEdsmEncargado;

	}

	public List<Edsm> BuscarEdsm(String busapellido, Persona personaEncargada) {

		String jpql = "SELECT n FROM Edsm n WHERE n.Persona.per_apellido LIKE :busAp AND n.Persona_encargada=:perEn ORDER BY n.eds_id DESC ";
		Query query = em.createQuery(jpql, Edsm.class);
		query.setParameter("perEn", personaEncargada);
		query.setParameter("busAp", "%" +busapellido +"%");
		List<Edsm> listadoEdsmEncargado = query.getResultList();
		return listadoEdsmEncargado;

	}
}
