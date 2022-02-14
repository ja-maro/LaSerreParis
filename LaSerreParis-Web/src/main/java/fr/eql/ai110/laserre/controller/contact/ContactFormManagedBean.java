package fr.eql.ai110.laserre.controller.contact;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.eql.ai110.laserre.entity.ContactForm;
import fr.eql.ai110.laserre.entity.ContactFormType;
import fr.eql.ai110.laserre.ibusiness.ContactFormIBusiness;
import fr.eql.ai110.laserre.ibusiness.services.FormValidationIService;

@ManagedBean(name = "mbContact")
@SessionScoped
public class ContactFormManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(ContactFormManagedBean.class);
	
	@EJB
	private ContactFormIBusiness contactBU;
	@EJB
	private FormValidationIService validator;
	
	private String email;
	private String name;
	private String phone;
	private ContactFormType type;
	private String title;
	private String body;
	private List<ContactFormType> types;
	
	@PostConstruct
	public void init() {
		types = contactBU.findAllTypes();
		for (ContactFormType t : types) {
			System.out.println(t.getName());
		}
	}



	public String submitContactForm() {
		String forward = null;
		boolean isValid = true;
		
		if (!validator.isEmailSyntaxValid(email)) {
			isValid = false;
			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Email inapproprié", "Votre email doit être valide.");
				FacesContext.getCurrentInstance().addMessage("contactForm:inpEmail", fMessage);
		}
		if(!phone.equals("")) {
			if (!validator.isPhoneSyntaxValid(phone)) {
				isValid = false;
				FacesMessage fMessage = new FacesMessage(
						FacesMessage.SEVERITY_WARN, 
						"Téléphone inapproprié", "Ce numéro de téléphone n'est pas français.");
					FacesContext.getCurrentInstance().addMessage("contactForm:inpPhone", fMessage);
			}
		}
		if (!validator.isMessageValid(body)) {
			isValid = false;
 			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Corps du message trop court", "Votre message est inexistant ou trop court.");
				FacesContext.getCurrentInstance().addMessage("contactForm:inpBody", fMessage);
		}
		if (type == null) {
			isValid = false;
			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Pas de type", "Choisissez une raison de contact.");
			FacesContext.getCurrentInstance().addMessage("contactForm:inpType", fMessage);
		}
		if (title.equals("")) {
			isValid = false;
			FacesMessage fMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, 
					"Pas de titre", "Renseignez un titre.");
				FacesContext.getCurrentInstance().addMessage("contactForm:inpTitle", fMessage);
		}
		
		if (isValid) {
			forward = "/index.xhtml?faces-redirection=true";
			ContactForm form = new ContactForm(email, name, phone, title, body, type);
			contactBU.save(form);
		}
		
		return forward;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ContactFormType getType() {
		return type;
	}
	public void setType(ContactFormType type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<ContactFormType> getTypes() {
		return types;
	}
	public void setTypes(List<ContactFormType> types) {
		this.types = types;
	}
	
}
