package fr.eql.ai110.laserre.ibusiness.subscription;

import fr.eql.ai110.laserre.entity.subscription.Subscription;

public interface SubscriptionIBusiness {

	Subscription subscribe(Subscription sub);
	Subscription generateWeeklyStatus(Subscription sub);
//	void saveWeeklyStatus(WeeklyStatus status);

}
