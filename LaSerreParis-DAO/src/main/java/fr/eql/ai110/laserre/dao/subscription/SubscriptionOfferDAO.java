package fr.eql.ai110.laserre.dao.subscription;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionOfferIDAO;

@Remote(SubscriptionOfferIDAO.class)
@Stateless
public class SubscriptionOfferDAO extends GenericDAO<SubscriptionOffer> implements SubscriptionOfferIDAO {

	@Override
	public List<SubscriptionOffer> getAllVisible() {
		Query query = em.createQuery("SELECT so FROM SubscriptionOffer so WHERE so.hideDate IS NULL");
		return query.getResultList();
	}

	@Override
	public List<SubscriptionOffer> getAllVisibleSimple() {
		Query query = em.createQuery("SELECT so FROM SubscriptionOffer so WHERE so.hideDate IS NULL AND so.totalHarvestQuantity = 0");
		return query.getResultList();
	}

	@Override
	public List<SubscriptionOffer> getAllVisiblePremium() {
		Query query = em.createQuery("SELECT so FROM SubscriptionOffer so WHERE so.hideDate IS NULL AND so.totalHarvestQuantity > 0");
		return query.getResultList();
	}

	
}
