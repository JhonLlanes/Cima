package com.edu.ec.Bussines;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import com.edu.ec.Dao.BusDao;
import com.edu.ec.Modelo.Bus;

@Stateless
public class BusBussines {

	@Inject
	private BusDao bus;
	
	public List<Bus> ListadeBuses(){
		
		System.out.println("Paso por el Busines");
		return bus.listarNivel();
	}
}
