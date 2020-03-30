package com.edu.ec.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.edu.ec.Dao.PersonaDao;
import com.edu.ec.Modelos.Login;
import com.edu.ec.Modelos.Persona;

@Stateless
public class PersonaBussines {
	
	@Inject
	private PersonaDao perDao;
	
	public void guardarPersona(Persona persona) {
		perDao.insertPersona(persona);		
	}
	
	public List<Persona> listarEstudiante(){
		return perDao.listarEstudiante();
	}
	
	public Persona listarLogin(Login lg){
		return perDao.listarLogin(lg);
	}
}
