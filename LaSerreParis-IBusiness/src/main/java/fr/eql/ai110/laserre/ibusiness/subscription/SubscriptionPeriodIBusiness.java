package fr.eql.ai110.laserre.ibusiness.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;

public interface SubscriptionPeriodIBusiness {

	Long getNbFuturePeriods();

	/**
	 * retrieves a number of SubscriptionPeriods starting after the present day
	 * @param numberOfPeriods
	 * @return
	 */
	List<SubscriptionPeriod> findNextPeriods(int numberOfPeriods);

}
