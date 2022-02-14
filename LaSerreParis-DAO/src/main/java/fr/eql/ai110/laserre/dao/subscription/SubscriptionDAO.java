package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionIDAO;

@Remote(SubscriptionIDAO.class)
@Stateless
public class SubscriptionDAO extends GenericDAO<Subscription> implements SubscriptionIDAO {

	
}