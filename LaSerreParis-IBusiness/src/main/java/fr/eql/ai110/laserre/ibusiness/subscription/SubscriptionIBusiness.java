package fr.eql.ai110.laserre.ibusiness.subscription;

import fr.eql.ai110.laserre.entity.subscription.Subscription;

public interface SubscriptionIBusiness {
	
	static final int MIN_NB_CROPS_SELECTED = 3;

	
	Subscription firstStepSubscription(Subscription sub);
	Subscription finalizeSubscription(Subscription sub);
	/**
	 * Checks if the user selected enough different crops for his premium subscription.
	 * 
	 * @param nbCropsSelected number of différent crops selected bye the user
	 * @return true if enough
	 */
	boolean isNbCropsSelectedEnough(int nbCropsSelected);
	/**
	 * Allows print of the minimum number of premium crops to select in a premium subscription.
	 *  
	 * @return minimum number of premium crops to select in a premium subscription
	 */
	int getMinNbCropsSelected();

}
