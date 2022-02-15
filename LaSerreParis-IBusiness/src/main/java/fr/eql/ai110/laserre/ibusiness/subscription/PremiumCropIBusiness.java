package fr.eql.ai110.laserre.ibusiness.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.PremiumCrop;

public interface PremiumCropIBusiness {

	/**
	 * Get all premium crops available to subscribers.
	 * 
	 * @return List of all available premium crops (premiumCrop with no hideDate)
	 */
	List<PremiumCrop> getAllAvailablePremiumCrops();
}
