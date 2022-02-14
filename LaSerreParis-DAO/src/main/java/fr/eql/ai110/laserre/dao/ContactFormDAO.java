package fr.eql.ai110.laserre.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.ContactForm;
import fr.eql.ai110.laserre.idao.ContactFormIDAO;

@Remote(ContactFormIDAO.class)
@Stateless
public class ContactFormDAO extends GenericDAO<ContactForm> implements ContactFormIDAO {


}
