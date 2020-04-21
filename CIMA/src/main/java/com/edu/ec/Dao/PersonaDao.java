package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelos.Login;
import com.edu.ec.Modelos.Persona;
import com.edu.ec.Modelos.Rol;

@Stateless
public class PersonaDao {
	
	@Inject
	private EntityManager em;
	
	public void insertPersona(Persona  persona) {
		em.persist(persona);
	}
	
	public Persona read(Login id) {
		Persona aux = em.find(Persona.class, id);
		System.out.println(aux.getPer_apellido() + aux.getPer_nombre());
		return aux;
	}
	
	public List<Persona> listarEstudiante(){
		Rol rol = new Rol();
		rol.setRol_id(3);
		
		String jpql = "SELECT n FROM Persona n WHERE n.rol=:rolP ORDER BY n.per_id DESC";
		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter("rolP", rol);
		List<Persona> listadoEstudiantes = query.getResultList();
		return listadoEstudiantes;
	}
	
	public Persona listarLogin(Login lg){
		
		String jpql = "SELECT n FROM Persona n WHERE n.login=:rolP ";
		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter("rolP", lg);
		List<Persona> listlogin  = query.getResultList();
		Persona per = listlogin.get(0);
		
		return per;
	}
	
	
	public List<Persona> listarEstudianteHistorial(Persona perencar){
		
		String jpql = "SELECT n FROM Persona n WHERE n.personaencargada=:perP ORDER BY n.per_id DESC";
		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter("perP", perencar);
		List<Persona> listadoEstudiantes = query.getResultList();
		return listadoEstudiantes;
	}
	
public List<Persona> BuscarlistarEstudianteHistorial( String apellido ,Persona perencar){
		
		String jpql = "SELECT n FROM Persona n WHERE n.per_apellido LIKE :busAp AND n.personaencargada=:perP ORDER BY n.per_id DESC";
		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter("perP", perencar);
		query.setParameter("busAp", "%" +apellido +"%");
		List<Persona> listadoEstudiantes = query.getResultList();
		return listadoEstudiantes;
	}
	
	
	
}
