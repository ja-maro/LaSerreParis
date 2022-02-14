package fr.eql.ai110.laserre.business;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.ContactForm;
import fr.eql.ai110.laserre.entity.ContactFormType;
import fr.eql.ai110.laserre.ibusiness.ContactFormIBusiness;
import fr.eql.ai110.laserre.idao.ContactFormIDAO;
import fr.eql.ai110.laserre.idao.ContactFormTypeIDAO;

@Remote(ContactFormIBusiness.class)
@Stateless
public class ContactFormBusiness implements ContactFormIBusiness {
	
	@EJB
	private ContactFormIDAO formDao;
	@EJB
	private ContactFormTypeIDAO typeDao;
	
	@Override
	public List<ContactForm> findAll() {
		return formDao.getAll();
	}

	@Override
	public void save(ContactForm form) {
		form.setCreationDate(LocalDate.now());
		formDao.add(form);
	}

	@Override
	public List<ContactFormType> findAllTypes() {
		return typeDao.getAll();
	}

}
