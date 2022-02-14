package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionSize;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionSizeIDAO;

@Remote(SubscriptionSizeIDAO.class)
@Stateless
public class SubscriptionSizeDAO extends GenericDAO<SubscriptionSize> implements SubscriptionSizeIDAO {


}