package fr.eql.ai110.laserre.controller.roles;

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
import fr.eql.ai110.laserre.ibusiness.roles.AccountIBusiness;

@ManagedBean(name = "mbUser")
@SessionScoped
public class UserRolesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(UserRolesManagedBean.class);
	
	@EJB
	private AccountIBusiness accountBU;
	
	private User user;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	public String connect() {
		String forward = null;

		user = accountBU.connect(email, password);
		if (user != null) {
			forward = "/index.xhtml?faces-redirection=true";
			LOG.info("Connexion de l'utilisateur : " + user.getId() + " " + user.getEmail());
		} else {
			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Email et/ou mot de passe incorrect(s)",
					"Email et/ou mot de passe incorrect(s)");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpEmail", fMessage);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", fMessage);
			LOG.info("Connexion échouée : " + email);
		}
		return forward;
	}
	
	public boolean isConnected() {
		return user != null;
	}
	
	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.invalidate();
		user = null;
		
		return "/login.xhtml?faces-redirection=true";
	}
	
	public String register() {
		System.out.println(email + " " + password);
		user = new User(null, firstName, lastName, email, null, null, null);
		accountBU.register(user, password); 
		String forward = "/login.xhtml?faces-redirection=true";
		return forward;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
