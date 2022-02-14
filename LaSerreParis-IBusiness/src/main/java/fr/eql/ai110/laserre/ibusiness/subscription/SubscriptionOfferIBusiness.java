package fr.eql.ai110.laserre.ibusiness.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;

public interface SubscriptionOfferIBusiness {
	
	List<SubscriptionOffer> findAllVisible();
	List<SubscriptionOffer> findAllVisibleSimple();
	List<SubscriptionOffer> findAllVisiblePremium();
	
}
