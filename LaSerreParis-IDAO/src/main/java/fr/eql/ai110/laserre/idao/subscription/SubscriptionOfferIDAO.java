package fr.eql.ai110.laserre.idao.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SubscriptionOfferIDAO extends GenericIDAO<SubscriptionOffer> {
	
	List<SubscriptionOffer> getAllVisible();
	List<SubscriptionOffer> getAllVisibleSimple();
	List<SubscriptionOffer> getAllVisiblePremium();

}
