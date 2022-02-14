package fr.eql.ai110.laserre.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.idao.UserIDAO;

@Remote(UserIDAO.class)
@Stateless
public class UserDAO extends GenericDAO<User> implements UserIDAO {

	@Override
	public String getSalt(String email) {
		String salt = "";
		List<String> salts;

		Query query = em.createQuery("SELECT u.salt FROM User u WHERE u.email = :emailParam");
		query.setParameter("emailParam", email); 
		salt = (String) query.getSingleResult();
		return salt;
	}

	@Override
	public User authenticate(String email, String password) {
		List<User> users;
		User user = null;

		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :emailParam "
				+ "AND u.password=:passwordParam");
		query.setParameter("emailParam", email);
		query.setParameter("passwordParam", password);
		users = query.getResultList();
		if (users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}

	@Override
	public User getByEmail(String email) {
		List<User> users;
		User user = null;
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :emailParam");
		query.setParameter("emailParam", email); 
		users = query.getResultList();
		if (users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}

}
