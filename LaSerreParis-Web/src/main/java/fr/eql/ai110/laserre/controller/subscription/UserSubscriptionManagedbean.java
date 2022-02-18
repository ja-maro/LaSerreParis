package fr.eql.ai110.laserre.controller.subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionIBusiness;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionPeriodIBusiness;

@ManagedBean(name = "mbUserSub")
@SessionScoped
public class UserSubscriptionManagedbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private SubscriptionIBusiness subBU;
	@EJB
	private SubscriptionPeriodIBusiness periodBU;
	
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private List<Subscription> activeSubscriptions;
	
	@PostConstruct
	void init() {
		
		activeSubscriptions = subBU.getSubscriptionsByUser(connectedUser);
		for (Subscription sub : activeSubscriptions) {
			System.out.println("********************************************");
			System.out.println(sub.getOffer().getPricePerMonth());
			System.out.println(sub.getOffer().getSize().getName());
			
			
		}
	}
	
	public LocalDate displayEndOfperiod(SubscriptionPeriod period) {
		LocalDate endDate = periodBU.getEndDate(period);
		return endDate;
	}
	

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public List<Subscription> getActiveSubscriptions() {
		return activeSubscriptions;
	}

	public void setActiveSubscriptions(List<Subscription> activeSubscriptions) {
		this.activeSubscriptions = activeSubscriptions;
	}
	

}
