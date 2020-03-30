package com.edu.ec.Controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class EncuestaController implements Serializable {

	private String value3;
	private Integer rating3;
	
	@PostConstruct	
	public void init() {
		System.err.println(rating3);
		
	}
	
	

	public Integer getRating3() {
		return rating3;
	}

	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public void addMessage() {
		
		
		if (rating3 == 1) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "State has been changed", "Mal" );
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if (rating3 == 2) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "State has been changed", "Regular" );
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}
		if (rating3 == 3) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "State has been changed", "Bien" );
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
	}
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private int number;
    
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number++;
        rating3 = null;
    }

}
