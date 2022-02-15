package fr.eql.ai110.laserre.business.subscription;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionIBusiness;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionIDAO;
import fr.eql.ai110.laserre.idao.subscription.WeeklyStatusIDAO;

@Remote(SubscriptionIBusiness.class)
@Stateless
public class SubscriptionBusiness implements SubscriptionIBusiness {

	@EJB
	SubscriptionIDAO subDao;
	WeeklyStatusIDAO wsDao;

	@Override
	public Subscription subscribe(Subscription sub) {
		return subDao.add(sub);
	}

	@Override
	public Subscription finalizeSubscription(Subscription sub) {
		return subDao.update(sub);
	}


}
