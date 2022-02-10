package fr.eql.ai110.laserre.controller.contact;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.ibusiness.ContactFormIBusiness;

@ManagedBean(name = "mbContact")
@SessionScoped
public class ContactFormManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(ContactFormManagedBean.class);
	
	// @EJBee
	private ContactFormIBusiness contactBU;
	
	private String email;
	private String name;
	private String phone;
	private String type;
	private String body;
	


	

}
