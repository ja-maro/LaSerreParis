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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_offer")
public class SubscriptionOffer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column (name = "price_per_month")
	private Float pricePerMonth;
	@Column (name = "total_harvest_qty")
	private Integer totalHarvestQuantity;
	@Column (name = "picture")
	private String picture;
	@Column (name = "hide_date")
	private LocalDate hideDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private SubscriptionSize size;
	
	@OneToMany(mappedBy="offer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;

	
	
	public SubscriptionOffer() {}

	public SubscriptionOffer(Integer id, Float pricePerMonth, Integer totalHarvestQuantity, String picture,
			LocalDate hideDate, SubscriptionSize size, List<Subscription> subscriptions) {
		super();
		this.id = id;
		this.pricePerMonth = pricePerMonth;
		this.totalHarvestQuantity = totalHarvestQuantity;
		this.picture = picture;
		this.hideDate = hideDate;
		this.size = size;
		this.subscriptions = subscriptions;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getPricePerMonth() {
		return pricePerMonth;
	}
	public void setPricePerMonth(Float pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}
	public Integer getTotalHarvestQuantity() {
		return totalHarvestQuantity;
	}
	public void setTotalHarvestQuantity(Integer totalHarvestQuantity) {
		this.totalHarvestQuantity = totalHarvestQuantity;
	}
	public LocalDate getHideDate() {
		return hideDate;
	}
	public void setHideDate(LocalDate hideDate) {
		this.hideDate = hideDate;
	}
	public SubscriptionSize getSize() {
		return size;
	}
	public void setSize(SubscriptionSize size) {
		this.size = size;
	}
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}	
}
