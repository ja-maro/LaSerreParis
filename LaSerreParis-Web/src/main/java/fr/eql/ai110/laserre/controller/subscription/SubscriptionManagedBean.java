package fr.eql.ai110.laserre.controller.subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionIBusiness;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionOfferIBusiness;
import fr.eql.ai110.laserre.ibusiness.subscription.SubscriptionPeriodIBusiness;
import net.bootsfaces.utils.FacesMessages;

@ManagedBean(name = "mbSubscription")
@SessionScoped
public class SubscriptionManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private SubscriptionOfferIBusiness offerBU;
	@EJB
	private SubscriptionPeriodIBusiness periodBU;
	@EJB
	private SubscriptionIBusiness subBU;
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private SubscriptionOffer offer;
	private List<SubscriptionOffer> availableSimpleOffers;
	private List<SubscriptionOffer> availablePremiumOffers;
	private Long nbPeriod;
	private Integer duration;
	
	@PostConstruct
	void init() {
		availableSimpleOffers = offerBU.findAllVisibleSimple();
		availablePremiumOffers = offerBU.findAllVisiblePremium();
		nbPeriod = periodBU.getNbFuturePeriods();
	}
	
	public String displayOfferDetails(SubscriptionOffer detailedOffer) {
		String forward = null;
		
		if (connectedUser != null) {
			if (connectedUser.getPhone() != null && connectedUser.getAddress() != null ) {
				this.offer = detailedOffer;
				forward = "/offerDetails.xhtml?faces-redirection=true";
			} else {
				FacesMessages.error("Erreur", "Vous devez renseigner votre adresse et numéro de téléphone dans votre espace pour continuer.");
			}
		} else {
			FacesMessages.error("Erreur", "Vous devez être inscrit et authentifié pour continuer.");
		}	
		return forward;
	}
	
	public String subscribe() {
		
		Subscription sub = new Subscription();
		List<SubscriptionPeriod> periods = (List<SubscriptionPeriod>) periodBU.findNextPeriods(duration);
		sub.setPeriods(periods);
		sub.setSubscriptionDate(LocalDate.now());
		sub.setUser(connectedUser);
		sub.setOffer(offer);
		
		sub = subBU.subscribe(sub);
		
		System.out.println(periods.get(0).getDuration());
		
		List<WeeklyStatus> statusList = new ArrayList<WeeklyStatus>();
		
		for (SubscriptionPeriod period : periods) {
			for (int i = 0; i < period.getDuration(); i++) {
				WeeklyStatus status = new WeeklyStatus();
				status.setStartDay(period.getStartDate().plusWeeks(i));
				status.setSubscription(sub);
				statusList.add(status);
				
			}		
		}
		
		sub.setWeeklyStatuses(statusList);
		subBU.generateWeeklyStatus(sub);
		
		
		return "/index.xhtml";
		
	}

	
	public List<SubscriptionOffer> getAvailableSimpleOffers() {
		return availableSimpleOffers;
	}
	public void setAvailableSimpleOffers(List<SubscriptionOffer> availableSimpleOffers) {
		this.availableSimpleOffers = availableSimpleOffers;
	}
	public List<SubscriptionOffer> getAvailablePremiumOffers() {
		return availablePremiumOffers;
	}
	public void setAvailablePremiumOffers(List<SubscriptionOffer> availablePremiumOffers) {
		this.availablePremiumOffers = availablePremiumOffers;
	}
	public User getConnectedUser() {
		return connectedUser;
	}
	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}
	public SubscriptionOffer getOffer() {
		return offer;
	}
	public void setOffer(SubscriptionOffer offer) {
		this.offer = offer;
	}
	public Long getNbPeriod() {
		return nbPeriod;
	}
	public void setNbPeriod(Long nbPeriod) {
		this.nbPeriod = nbPeriod;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
}
