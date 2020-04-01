package com.edu.ec.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.edu.ec.Dao.EdsmDao;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Persona;

@Stateless
public class EdsmBussines {
	
	@Inject
	private EdsmDao edsmDao ;
	
	public Edsm crearEdsm(Edsm edsm) {	
		return edsmDao.crearEdsm(edsm);		
	}
	
	public List<Edsm> listarEdsm(Persona personaEncargada) {
		return edsmDao.listarEdsm(personaEncargada);
	}
	
	public List<Edsm> BuscarEdsm(String busapellido, Persona personaEncargada) {
		return edsmDao.BuscarEdsm(busapellido, personaEncargada);
	}
	
	public List<Edsm> listarEdsmEst(Persona personaestu) {
		return edsmDao.listarEdsmEst(personaestu);
	}
}
