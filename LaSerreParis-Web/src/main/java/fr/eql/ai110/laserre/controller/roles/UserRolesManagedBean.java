package fr.eql.ai110.laserre.controller.roles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.ibusiness.roles.UserAccountIBusiness;

@ManagedBean(name = "mbUser")
@SessionScoped
public class UserRolesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(UserRolesManagedBean.class);
	
	@EJB
	private UserAccountIBusiness accountBU;
	
	private User user;
	private String email;
	private String password;
	private String password2;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private Integer homeSize;
	private Date birthDate;
	
	/**
	 * Allows user to authenticate through their email and password and saves user data in managedBean.
	 * @return Redirects to index page if successful.
	 */
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
	
	/**
	 * Checks if user is connected.
	 * @return True if user is connected.
	 */
	public boolean isConnected() {
		return user != null;
	}
	
	/**
	 * Disconnects the user by invalidating the session and erasing user data from the managedBean.
	 * @return Redirects to login page.
	 */
	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.invalidate();
		user = null;
		
		return "/login.xhtml?faces-redirection=true";
	}
	
	/**
	 * Allows user to register to the application.
	 * @return Redirects to index.
	 */
	public String register() {
		LocalDate birth = birthDate.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		//user = new User(null, firstName, lastName, email, null, null, address, phone, homeSize, birth, null, null, null, null);
		user = new User(firstName, lastName, email, address, phone, homeSize, birth);
		accountBU.register(user, password); 
		String forward = "/index.xhtml?faces-redirection=true";
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getHomeSize() {
		return homeSize;
	}

	public void setHomeSize(Integer homeSize) {
		this.homeSize = homeSize;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
