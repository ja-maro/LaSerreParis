package fr.eql.ai110.laserre.business.subscription;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionIBusiness;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionIDAO;
import fr.eql.ai110.laserre.idao.subscription.WeeklyStatusIDAO;

@Remote(SubscriptionIBusiness.class)
@Stateless
public class SubscriptionBusiness implements SubscriptionIBusiness {

	@EJB
	SubscriptionIDAO dao;
	WeeklyStatusIDAO wsDao;

	@Override
	public Subscription subscribe(Subscription sub) {
		return dao.add(sub);
	}

	@Override
	public void saveWeeklyStatus(WeeklyStatus status) {
		wsDao.add(status);
	}


	@Override
	public Subscription generateWeeklyStatus(Subscription sub) {
		return dao.update(sub);
	}
}
