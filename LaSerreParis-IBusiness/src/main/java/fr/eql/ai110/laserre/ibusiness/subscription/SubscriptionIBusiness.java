package fr.eql.ai110.laserre.ibusiness.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;

public interface SubscriptionIBusiness {

	Subscription subscribe(Subscription sub);
	Subscription generateWeeklyStatus(Subscription sub);
	void saveWeeklyStatus(WeeklyStatus status);

}
