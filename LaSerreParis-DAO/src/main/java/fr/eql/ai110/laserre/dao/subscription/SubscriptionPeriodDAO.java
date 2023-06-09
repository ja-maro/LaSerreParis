package fr.eql.ai110.laserre.dao.subscription;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionPeriodIDAO;

@Remote(SubscriptionPeriodIDAO.class)
@Stateless
public class SubscriptionPeriodDAO extends GenericDAO<SubscriptionPeriod> implements SubscriptionPeriodIDAO {

	@Override
	public Long findNbFuturePeriods() {
		Query query = em.createQuery("SELECT COUNT(p) FROM SubscriptionPeriod p WHERE p.startDate > CURDATE()");
		return (Long) query.getSingleResult();
	}
	
	@Override
	public List<SubscriptionPeriod> findNextPeriods() {
		Query query = em.createQuery("SELECT p FROM SubscriptionPeriod p WHERE p.startDate > SYSDATE() ORDER BY p.startDate ASC");
		return query.getResultList();
	}

	@Override
	public SubscriptionPeriod getBySubscription(Subscription sub) {
		List<SubscriptionPeriod> periods;
		SubscriptionPeriod period = null;

		Query query = em.createQuery("SELECT s.period FROM Subscription s WHERE s = :subParam");
		query.setParameter("subParam", sub);
		periods = query.getResultList();
		if (periods.size() > 0) {
			period = periods.get(0);
		}
		return period;
	}
}