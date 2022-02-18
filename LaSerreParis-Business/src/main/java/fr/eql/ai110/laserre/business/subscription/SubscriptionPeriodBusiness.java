package fr.eql.ai110.laserre.business.subscription;

import java.time.LocalDate;
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
		 
		 
		 System.out.println("********************** avant tri");
		 for (SubscriptionPeriod p : list) {
			 System.out.println("------ " + p.getStartDate());
			
		}
		 list.sort((o1,o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
		 
		 System.out.println("********************** après tri");
		 for (SubscriptionPeriod p : list) {
			 System.out.println("------ " + p.getStartDate());
			
		}
		return list;
	}

	@Override
	public LocalDate getEndDate(SubscriptionPeriod period) {	
		System.out.println("@@@@@@@@@@@@àà getEndDate subperiodBU");
		LocalDate date = period.getStartDate().plusWeeks(period.getDuration());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("$$$$$$ " + date);
		System.out.println(period.getStartDate());
		System.out.println(period.getDuration());
		return date;
	}
}
