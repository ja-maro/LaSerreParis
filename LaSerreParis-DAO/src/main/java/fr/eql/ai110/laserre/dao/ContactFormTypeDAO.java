package fr.eql.ai110.laserre.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.ContactFormType;
import fr.eql.ai110.laserre.idao.ContactFormTypeIDAO;

@Remote(ContactFormTypeIDAO.class)
@Stateless
public class ContactFormTypeDAO extends GenericDAO<ContactFormType> implements ContactFormTypeIDAO {

}
