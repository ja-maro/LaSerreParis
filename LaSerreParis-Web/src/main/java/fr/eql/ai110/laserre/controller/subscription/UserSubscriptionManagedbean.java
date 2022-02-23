package fr.eql.ai110.laserre.controller.subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionIBusiness;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionPeriodIBusiness;

@ManagedBean(name = "mbUserSub")
@ViewScoped
public class UserSubscriptionManagedbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private SubscriptionIBusiness subBU;
	@EJB
	private SubscriptionPeriodIBusiness periodBU;
	
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private List<Subscription> activeSubscriptions;
	private List<Subscription> pastSubscriptions;
	private List<Subscription> futureSubscriptions;
	
	@PostConstruct
	void init() {
		activeSubscriptions = new ArrayList<Subscription>();
		pastSubscriptions = new ArrayList<Subscription>();
		futureSubscriptions = new ArrayList<Subscription>();
		
		List<Subscription> userSubs = subBU.getSubscriptionsByUser(connectedUser);	
		for (Subscription sub : userSubs) {			
			SubscriptionPeriod period = periodBU.getPeriodBySubscription(sub);			
			LocalDate startDate = period.getStartDate();
			LocalDate endDate = periodBU.calculateEndDate(period);
			
			if (startDate.isAfter(LocalDate.now())) {
				futureSubscriptions.add(sub);
			} else if (endDate.isBefore(LocalDate.now()) ) {
				pastSubscriptions.add(sub);
			} else {
				activeSubscriptions.add(sub);
			}			
		}
	}
	
	/**
	 * Checks whether active user has no active or future subscription.
	 * 
	 * @return true if hasn't any
	 */
	public boolean hasNoSubscription() {
		return (futureSubscriptions.isEmpty() && activeSubscriptions.isEmpty());
	}
	/**
	 * Checks whether active user has any past subscription.
	 * 
	 * @return true if had at least one.
	 */
	public boolean hadSubscription() {
		return (!pastSubscriptions.isEmpty());
	}
	
	/**
	 * Calculates date of end of given Subscription period (based on its startDate and duration).
	 * 
	 * @param period of which end date is needed
	 * @return period's end date
	 */
	public LocalDate displayEndOfperiod(SubscriptionPeriod period) {
		return periodBU.calculateEndDate(period);
	}
	
	/**
	 * Formats a LocalDate as a String in french language, following pattern "lundi 12 mars 2020".
	 * 
	 * @param date LocalDate to format
	 * @return formatted date as a String
	 */
	public String formatDateFull(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.FRENCH));
	}
	/**
	 * Formats a LocalDate as a String in french language, following pattern "lundi 12 mars".
	 * 
	 * @param date LocalDate to format
	 * @return formatted date as a String
	 */
	public String formatDateNoYear(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("EEEE dd MMMM",Locale.FRENCH));
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

	public List<Subscription> getPastSubscriptions() {
		return pastSubscriptions;
	}

	public void setPastSubscriptions(List<Subscription> pastSubscriptions) {
		this.pastSubscriptions = pastSubscriptions;
	}

	public List<Subscription> getFutureSubscriptions() {
		return futureSubscriptions;
	}

	public void setFutureSubscriptions(List<Subscription> futureSubscriptions) {
		this.futureSubscriptions = futureSubscriptions;
	}
	

}
