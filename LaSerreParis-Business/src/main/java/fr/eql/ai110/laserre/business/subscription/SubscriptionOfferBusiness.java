package fr.eql.ai110.laserre.business.subscription;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionOfferIBusiness;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionOfferIDAO;

@Remote(SubscriptionOfferIBusiness.class)
@Stateless
public class SubscriptionOfferBusiness implements SubscriptionOfferIBusiness {

	@EJB
	private SubscriptionOfferIDAO offerDao;
	
	@Override
	public List<SubscriptionOffer> findAllVisibleSimple() {
		return offerDao.getAllVisibleSimple();
	}
	@Override
	public List<SubscriptionOffer> findAllVisiblePremium() {
		return offerDao.getAllVisiblePremium();
	}
	@Override
	public List<SubscriptionOffer> findAllVisible() {
		return offerDao.getAllVisible();
	}


}
