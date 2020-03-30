package com.edu.ec.Util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.faces.context.FacesContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class Resources {
	
	@Produces
	@PersistenceContext
	private EntityManager em;

	@Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

	@Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }
	
}
