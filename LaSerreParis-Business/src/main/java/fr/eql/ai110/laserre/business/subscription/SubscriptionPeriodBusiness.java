package fr.eql.ai110.laserre.business.subscription;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionPeriodIBusiness;
import fr.eql.ai110.laserre.idao.subscription.SubscriptionPeriodIDAO;

@Remote(SubscriptionPeriodIBusiness.class)
@Stateless
public class SubscriptionPeriodBusiness implements SubscriptionPeriodIBusiness {

	@EJB
	SubscriptionPeriodIDAO dao;
	
	@Override
	public Long getNbFuturePeriods() {
		return dao.findNbFuturePeriods();
	}
	
	@Override
	public List<SubscriptionPeriod> findNextPeriods(int numberOfPeriods) {
		 List<SubscriptionPeriod> list = dao.findNextPeriods()
		            .stream()
		            .limit(numberOfPeriods)
		            .collect(Collectors.toList());
		return list;
	}
}
