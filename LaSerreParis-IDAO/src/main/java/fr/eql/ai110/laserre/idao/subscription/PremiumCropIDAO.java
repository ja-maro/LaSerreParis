package fr.eql.ai110.laserre.idao.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.subscription.PremiumCrop;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface PremiumCropIDAO extends GenericIDAO<PremiumCrop> {

	/**
	 * Gets list of all premium crops that are not hidden.
	 * 
	 * @return List of all premiumCrop with no hideDate
	 */
	List<PremiumCrop> getAllVisible();

}
