package fr.eql.ai110.laserre.dao.subscription;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionIDAO;

@Remote(SubscriptionIDAO.class)
@Stateless
public class SubscriptionDAO extends GenericDAO<Subscription> implements SubscriptionIDAO {

	@Override
	public List<Subscription> getAllActive(User user) {
		Query query = em.createQuery("SELECT s FROM Subscription s "
				+ "INNER JOIN FETCH s.periods p "
				+ "INNER JOIN FETCH s.offer o "
				+ "INNER JOIN FETCH o.size si "
				+ "INNER JOIN FETCH p.season se "
				+ "WHERE s.user = :userParam AND CURDATE() > p.startDate");
		query.setParameter("userParam", user);
		return query.getResultList();
		
		
	}

	
}