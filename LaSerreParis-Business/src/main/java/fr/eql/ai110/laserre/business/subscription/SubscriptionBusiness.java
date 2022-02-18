package fr.eql.ai110.laserre.business.subscription;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionIBusiness;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionIDAO;

@Remote(SubscriptionIBusiness.class)
@Stateless
public class SubscriptionBusiness implements SubscriptionIBusiness {

	@EJB
	SubscriptionIDAO subDao;

	@Override
	public Subscription firstStepSubscription(Subscription sub) {
		return subDao.add(sub);
	}

	@Override
	public Subscription updateSubscription(Subscription sub) {
		return subDao.update(sub);
	}

	@Override
	public boolean isNbCropsSelectedEnough(int nbCropsSelected) {
		if (nbCropsSelected >= MIN_NB_CROPS_SELECTED) {
			return false;
		}
		return true;
	}

	@Override
	public int getMinNbCropsSelected() {
		return MIN_NB_CROPS_SELECTED;
	}

	@Override
	public List<Subscription> getSubscriptionsByUser(User user) {	
		return subDao.getAllByUser(user);
	}

}
