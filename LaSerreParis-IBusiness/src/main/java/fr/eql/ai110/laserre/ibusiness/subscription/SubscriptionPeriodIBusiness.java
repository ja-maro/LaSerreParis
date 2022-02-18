package fr.eql.ai110.laserre.ibusiness.subscription;

import java.time.LocalDate;
import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;

public interface SubscriptionPeriodIBusiness {

	/**
	 * Retrieves the number of all future SubscriptionPeriods.
	 * 
	 * @return number of all SubscriptionPeriods whose startDate is yet to come.
	 */
	Long getNbFuturePeriods();

	/**
	 * Retrieves a number of SubscriptionPeriods starting after the present day.
	 * 
	 * @param numberOfPeriods number of next period required
	 * @return 'numberOfPeriods' next periods
	 */
	List<SubscriptionPeriod> findNextPeriods(int numberOfPeriods);

	/**
	 * Calculates the end date of the given SubscriptionPeriod.
	 * 
	 * @param period period whose end date is needed
	 * @return end date of the Subscription period, which equals its start date + as many weeks as its duration
	 */
	LocalDate calculateEndDate(SubscriptionPeriod period);

	/**
	 * Returns the SubscriptionPeriod associated with the given Subscription as fetchType is LAZY.
	 * 
	 * @param sub The Subscription whose period needs to be retrieved.
	 * @return Period associated with given Subscription
	 */
	SubscriptionPeriod getPeriodBySubscription(Subscription sub);

}
