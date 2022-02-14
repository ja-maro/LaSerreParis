package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.PremiumCrop;
import fr.eql.ai110.laserre.idao.subscription.PremiumCropIDAO;

@Remote(PremiumCropIDAO.class)
@Stateless
public class PremiumCropDAO extends GenericDAO<PremiumCrop> implements PremiumCropIDAO {


}
