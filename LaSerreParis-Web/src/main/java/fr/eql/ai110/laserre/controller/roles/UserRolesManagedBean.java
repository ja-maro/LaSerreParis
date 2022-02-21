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
import fr.eql.ai110.laserre.ibusiness.roles.AccountIBusiness;
import fr.eql.ai110.laserre.ibusiness.services.FormValidationIService;
import net.bootsfaces.utils.FacesMessages;

@ManagedBean(name = "mbUser")
@SessionScoped
public class UserRolesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(UserRolesManagedBean.class);
	
	@EJB
	private AccountIBusiness accountBU;
	@EJB
	private FormValidationIService validator;
	
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
			forward = "/index.xhtml?faces-redirection=false";
			LOG.info("Connexion de l'utilisateur : " + user.getId() + " " + user.getEmail().replaceAll("[\r\n]",""));
			FacesMessages.info("Bienvenue !");	
			
		} else {
			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Email et/ou mot de passe incorrect(s) !",
					"Vérifiez vos informations !");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpEmail", fMessage);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", fMessage);
			LOG.info("Connexion échouée : " + email.replaceAll("[\r\n]",""));
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
	 * Allows user to register to the application after checking the 
	 * validity of their information and logs them in.
	 * 
	 * @return Redirects to index.
	 */
	public String register() {
		LocalDate birth = birthDate.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		
		String forward = null;
		boolean isInfoValid = true;
		
		if (!validator.isEmailAvailable(email)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Email existant", "Cet email est déjà utilisé.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpEmail", fMessage);
		}
		if (!validator.isEmailSyntaxValid(email)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Email inapproprié", "Votre email doit être valide.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpEmail", fMessage);
		}
		if (!validator.isPasswordSyntaxvalid(password)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Mot de passe trop faible", 
				"Votre mot de passe doit faire au moins 6 caractères et inclure un chiffre, une minuscule, "
				+ "une majuscule et un caractère spécial.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpPassword", fMessage);
		}
		if (!password.equals(password2)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Mot de passe inconstant", 
					"Veuillez répéter exactement votre mot de passe.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpPassword2", fMessage);
		}
		if (!validator.isNameSyntaxValid(firstName)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Prénom inapproprié", "Votre prénom ne peut pas contenir de chiffres ou de caractères spéciaux.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpFirstName", fMessage);
		}
		if (!validator.isNameSyntaxValid(lastName)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Nom inapproprié", "Votre nom ne peut pas contenir de chiffres ou de caractères spéciaux.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpLastName", fMessage);
		}
		if (!phone.equals("")) {
			if (!validator.isPhoneSyntaxValid(phone)) {
				isInfoValid = false;
				FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Téléphone inapproprié", "Ce numéro de téléphone n'est pas français.");
				FacesContext.getCurrentInstance().addMessage("registerForm:inpPhone", fMessage);
			}
		}
		if (!validator.isBirthDateValid(birth)) {
			isInfoValid = false;
			FacesMessage fMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Date de naissance inappropriée", "Vous devez être majeur et avoir un âge raisonnable.");
			FacesContext.getCurrentInstance().addMessage("registerForm:inpBirth", fMessage);
		}
		
		if (isInfoValid) {
			user = new User(firstName, lastName, email, address, phone, homeSize, birth);
			accountBU.register(user, password); 	
			connect();
			forward = "/index.xhtml?faces-redirection=true";
		}
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
