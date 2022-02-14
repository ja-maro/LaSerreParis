package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionPeriodIDAO;

@Remote(SubscriptionPeriodIDAO.class)
@Stateless
public class SubscriptionPeriodDAO extends GenericDAO<SubscriptionPeriod> implements SubscriptionPeriodIDAO {


}