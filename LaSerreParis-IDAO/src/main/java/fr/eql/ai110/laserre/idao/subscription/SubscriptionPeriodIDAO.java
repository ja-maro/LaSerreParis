package fr.eql.ai110.laserre.idao.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SubscriptionPeriodIDAO extends GenericIDAO<SubscriptionPeriod> {

	Long findNbFuturePeriods();

	List<SubscriptionPeriod> findNextPeriods();

	SubscriptionPeriod getBySubscription(Subscription sub);

}
