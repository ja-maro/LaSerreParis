package fr.eql.ai110.laserre.ibusiness;

import java.util.List;

import fr.eql.ai110.laserre.entity.ContactForm;
import fr.eql.ai110.laserre.entity.ContactFormType;

public interface ContactFormIBusiness {

	List<ContactForm> findAll();
	void save(ContactForm form);
	List<ContactFormType> findAllTypes();
}
