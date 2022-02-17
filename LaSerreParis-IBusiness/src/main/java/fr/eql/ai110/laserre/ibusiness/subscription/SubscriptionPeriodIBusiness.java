package fr.eql.ai110.laserre.ibusiness.subscription;

import java.time.LocalDate;
import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;

public interface SubscriptionPeriodIBusiness {

	/**
	 * Retrieves all future SubscriptionPeriods.
	 * 
	 * @return a list of all the SubscriptionPeriods whose startDate is yet to come.
	 */
	Long getNbFuturePeriods();

	/**
	 * Retrieves a number of SubscriptionPeriods starting after the present day.
	 * 
	 * @param numberOfPeriods
	 * @return
	 */
	List<SubscriptionPeriod> findNextPeriods(int numberOfPeriods);

	/**
	 * Calculates the end date of the given SubscriptionPeriod.
	 * 
	 * @param period
	 * @return end date of the Subscription period, which equals its start date + as many weeks as its duration
	 */
	LocalDate getEndDate(SubscriptionPeriod period);

}
