package fr.eql.ai110.laserre.entity.subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.eql.ai110.laserre.entity.User;

@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "subscription_date")
	private LocalDate subscriptionDate;
	@Column(name = "suspension_date")
	private LocalDate supensionDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private SubscriptionOffer offer;
	
	@OneToMany(mappedBy="subscription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PremiumSubscriptionCrop> subscriptionCrops;
	
	@OneToMany(mappedBy="subscription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<WeeklyStatus> weeklyStatuses;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private SubscriptionPeriod period;
	
		
	
	public Subscription() {}


	public Subscription(Integer id, LocalDate subscriptionDate, LocalDate supensionDate, User user,
			SubscriptionOffer offer, List<PremiumSubscriptionCrop> subscriptionCrops, List<WeeklyStatus> weeklyStatuses,
			SubscriptionPeriod period) {
		super();
		this.id = id;
		this.subscriptionDate = subscriptionDate;
		this.supensionDate = supensionDate;
		this.user = user;
		this.offer = offer;
		this.subscriptionCrops = subscriptionCrops;
		this.weeklyStatuses = weeklyStatuses;
		this.period = period;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public LocalDate getSupensionDate() {
		return supensionDate;
	}
	public void setSupensionDate(LocalDate supensionDate) {
		this.supensionDate = supensionDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SubscriptionOffer getOffer() {
		return offer;
	}
	public void setOffer(SubscriptionOffer offer) {
		this.offer = offer;
	}
	public SubscriptionPeriod getPeriod() {
		return period;
	}
	public void setPeriod(SubscriptionPeriod period) {
		this.period = period;
	}
	public List<PremiumSubscriptionCrop> getSubscriptionCrops() {
		return subscriptionCrops;
	}
	public void setSubscriptionCrops(List<PremiumSubscriptionCrop> subscriptionCrops) {
		this.subscriptionCrops = subscriptionCrops;
	}
	public List<WeeklyStatus> getWeeklyStatuses() {
		return weeklyStatuses;
	}
	public void setWeeklyStatuses(List<WeeklyStatus> weeklyStatuses) {
		this.weeklyStatuses = weeklyStatuses;
	}
	
}