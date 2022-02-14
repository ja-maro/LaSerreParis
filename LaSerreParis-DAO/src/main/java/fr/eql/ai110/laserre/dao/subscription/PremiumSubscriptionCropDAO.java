package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.PremiumSubscriptionCrop;
import fr.eql.ai110.laserre.idao.subscription.PremiumSubscriptionCropIDAO;


@Remote(PremiumSubscriptionCropIDAO.class)
@Stateless
public class PremiumSubscriptionCropDAO extends GenericDAO<PremiumSubscriptionCrop> implements PremiumSubscriptionCropIDAO {


}
