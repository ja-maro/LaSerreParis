package fr.eql.ai110.laserre.controller.subscription;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionOfferIBusiness;

@ManagedBean(name = "mbSubscription")
@ViewScoped
public class SubscriptionManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private SubscriptionOfferIBusiness offerBU;
	
	List<SubscriptionOffer> availableSimpleOffers;
	List<SubscriptionOffer> availablePremiumOffers;
	
	@PostConstruct
	void init() {
		availableSimpleOffers = offerBU.findAllVisibleSimple();
		availablePremiumOffers = offerBU.findAllVisiblePremium();
	}

	
	public List<SubscriptionOffer> getAvailableSimpleOffers() {
		return availableSimpleOffers;
	}
	public void setAvailableSimpleOffers(List<SubscriptionOffer> availableSimpleOffers) {
		this.availableSimpleOffers = availableSimpleOffers;
	}
	public List<SubscriptionOffer> getAvailablePremiumOffers() {
		return availablePremiumOffers;
	}
	public void setAvailablePremiumOffers(List<SubscriptionOffer> availablePremiumOffers) {
		this.availablePremiumOffers = availablePremiumOffers;
	}

	
	
}
