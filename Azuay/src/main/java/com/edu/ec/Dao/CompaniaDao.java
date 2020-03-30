package com.edu.ec.Dao;

import java.awt.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class CompaniaDao {
	
	@Inject
	private EntityManager em;

}
