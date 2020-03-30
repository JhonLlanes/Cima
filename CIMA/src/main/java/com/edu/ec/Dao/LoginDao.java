package com.edu.ec.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.ec.Modelos.Login;

@Stateless
public class LoginDao {
	
	@Inject
	private EntityManager em;
	
	public int insertUsuario(Login login) {
		em.persist(login);
		return login.getLog_id();
	}	
	
	public List<Login> logginaplicacion(String un, String pass) {
		System.out.println("loggin");
		String  jpql = "SELECT s FROM Login s WHERE s.log_usuario=:un AND s.log_contrasena=:pass";
		Query query = em.createQuery(jpql, Login.class);
		query.setParameter("un", un);
		query.setParameter("pass", pass);
		List<Login> listado = query.getResultList();		
		return listado;
	}
	
}
