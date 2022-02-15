package fr.eql.ai110.laserre.business.subscription;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;

import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.subscription.PremiumCrop;
import fr.eql.ai110.laserre.ibusiness.subscription.PremiumCropIBusiness;
import fr.eql.ai110.laserre.idao.subscription.PremiumCropIDAO;

@Remote(PremiumCropIBusiness.class)
@Stateless
public class PremiumCropBusiness implements PremiumCropIBusiness {
	
	@EJB
	private PremiumCropIDAO dao;

	@Override
	public List<PremiumCrop> getAllAvailablePremiumCrops() {
		return dao.getAllVisible();
	}

}
