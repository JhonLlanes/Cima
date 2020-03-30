package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelo.Bus;

@Stateless
public class BusDao {
	@Inject
	private EntityManager em;

	public List<Bus> listarNivel(){
		String jpql = "SELECT t FROM Compania t";
		Query query = em.createQuery(jpql,Bus.class);
		List<Bus> bus = query.getResultList();
		for (Bus bus2 : bus) {
			System.out.println(bus.get(0).getNombre());
		}
		return bus;	
	}
}
