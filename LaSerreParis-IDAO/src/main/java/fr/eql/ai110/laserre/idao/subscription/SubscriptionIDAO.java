package fr.eql.ai110.laserre.idao.subscription;

import java.util.List;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SubscriptionIDAO extends GenericIDAO<Subscription> {

	List<Subscription> getAllActive(User user);

}
