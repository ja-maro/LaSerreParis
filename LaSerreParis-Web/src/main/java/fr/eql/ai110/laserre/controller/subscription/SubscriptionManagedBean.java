package fr.eql.ai110.laserre.controller.subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.PremiumCrop;
import fr.eql.ai110.laserre.entity.subscription.PremiumSubscriptionCrop;
import fr.eql.ai110.laserre.entity.subscription.Subscription;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionOffer;
import fr.eql.ai110.laserre.entity.subscription.SubscriptionPeriod;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;
import fr.eql.ai110.laserre.ibusiness.subscription.PremiumCropIBusiness;
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
	@EJB
	private PremiumCropIBusiness cropBU;

	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private SubscriptionOffer offer;
	private Subscription subscription;
	private List<SubscriptionOffer> availableSimpleOffers;
	private List<SubscriptionOffer> availablePremiumOffers;
	private Long nbPeriod;
	private Integer duration;
	private List<PremiumSubscriptionCrop> subscribedCrops;
	private PremiumSubscriptionCrop subCrop;

	@PostConstruct
	void init() {
		availableSimpleOffers = offerBU.findAllVisibleSimple();
		availablePremiumOffers = offerBU.findAllVisiblePremium();
		nbPeriod = periodBU.getNbFuturePeriods();
		subscribedCrops = getPossibleCrops();

	}

	public String displayOfferDetails(SubscriptionOffer detailedOffer) {
		String forward = null;

		if (connectedUser != null) {
			if (connectedUser.getPhone() != null && connectedUser.getAddress() != null ) {
				this.offer = detailedOffer;
				forward = "/offerDetails.xhtml?faces-redirection=true";
			} else {
				FacesMessages.warning("Attention :", "Vous devez renseigner votre adresse et numéro de téléphone dans votre espace pour continuer.");
			}
		} else {
			FacesMessages.error("Erreur :", "Vous devez être inscrit et authentifié pour continuer.");
		}
		return forward;
	}


	public List<PremiumCrop> getAvailablePremiumCrops() {
		return cropBU.getAllAvailablePremiumCrops();
	}


	public List<PremiumSubscriptionCrop> getPossibleCrops() {
		List<PremiumSubscriptionCrop> result = new ArrayList<PremiumSubscriptionCrop>();
		List<PremiumCrop> list = cropBU.getAllAvailablePremiumCrops();
		for (PremiumCrop crop : list) {
			PremiumSubscriptionCrop sCrop = new PremiumSubscriptionCrop();
			sCrop.setCrop(crop);
			sCrop.setQuantity(0);
			result.add(sCrop);
		}
		return result;
	}


	public String subscribe() {
		String forward = null;
		Boolean isValid = true;

		if (isValid) {

			Boolean isSoonestSubscription = true;

			List<SubscriptionPeriod> periods = (List<SubscriptionPeriod>) periodBU.findNextPeriods(duration);

			for (SubscriptionPeriod period : periods) {
				Subscription sub = new Subscription();
				sub.setPeriod(period);
				sub.setSubscriptionDate(LocalDate.now());
				sub.setUser(connectedUser);
				sub.setOffer(offer);

				sub = subBU.firstStepSubscription(sub);

				List<WeeklyStatus> statusList = new ArrayList<WeeklyStatus>();
				for (int i = 0; i < period.getDuration(); i++) {
					WeeklyStatus status = new WeeklyStatus();
					status.setStartDay(period.getStartDate().plusWeeks(i));
					status.setSubscription(sub);
					statusList.add(status);	
				}		
				sub.setWeeklyStatuses(statusList);

				if (isSoonestSubscription) {
					subscription = sub;
					isSoonestSubscription = false;
				}
			}
			if (offer.getTotalHarvestQuantity() > 0) {
				forward = "/cropsSelection.xhtml?faces-redirection=true";
			} else {	
				FacesMessages.info("Votre abonnement a été enregistré.");
				forward = "/user.xhtml";
			}
			
		}
		return forward;
	}


	public String selectCrops() {
		String forward = null;
		Boolean isValid = true;
		int requiredQty = subscription.getOffer().getTotalHarvestQuantity();
		int nbCropsSelected = 0;
		int totalChoice = 0;
		
		for (PremiumSubscriptionCrop sCrop : subscribedCrops) {
			int cropTotalWeight = sCrop.getQuantity()*sCrop.getCrop().getHarvestQty();
			totalChoice += cropTotalWeight;
			if (sCrop.getQuantity() > 0) {
				nbCropsSelected ++;
			}
		}

		if (requiredQty > 0) {
			if (totalChoice < requiredQty) {
				FacesMessages.warning("Attention :", "Vous devez sélectionner plus de points.");
				isValid = false;
			} else if (totalChoice > requiredQty) {
				FacesMessages.warning("Attention :", "Vous avez sélectionné trop de points.");
				isValid = false;
			}
			if (subBU.isNbCropsSelectedEnough(nbCropsSelected)) {
				FacesMessages.warning("Attention :", "Vous devez sélectionner au moins " + subBU.getMinNbCropsSelected() + " variétés différentes .");
				isValid = false;
			} 
		}
		if (isValid) {
			subscribedCrops.removeIf(c->c.getQuantity() <= 0);
			for (PremiumSubscriptionCrop sCrop : subscribedCrops) {
				sCrop.setSubscription(subscription);
			}
			subscription.setSubscriptionCrops(subscribedCrops);

			subBU.updateSubscription(subscription);
			FacesMessages.info("Votre abonnement a été enregistré.");
			forward = "/user.xhtml";	
		}


		return forward;
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
	public List<PremiumSubscriptionCrop> getSubscribedCrops() {
		return subscribedCrops;
	}
	public void setSubscribedCrops(List<PremiumSubscriptionCrop> subscribedCrops) {
		this.subscribedCrops = subscribedCrops;
	}
	public PremiumSubscriptionCrop getSubCrop() {
		return subCrop;
	}
	public void setSubCrop(PremiumSubscriptionCrop subCrop) {
		this.subCrop = subCrop;
	}

}
