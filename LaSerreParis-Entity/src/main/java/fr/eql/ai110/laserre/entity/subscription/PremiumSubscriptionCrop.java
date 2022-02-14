package fr.eql.ai110.laserre.entity.subscription;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "premium_subscription_crop")
public class PremiumSubscriptionCrop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Subscription subscription;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private PremiumCrop crop;

	
	public PremiumSubscriptionCrop() {
	}

	public PremiumSubscriptionCrop(Integer id, Integer quantity, Subscription subscription, PremiumCrop crop) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.subscription = subscription;
		this.crop = crop;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public PremiumCrop getCrop() {
		return crop;
	}

	public void setCrop(PremiumCrop crop) {
		this.crop = crop;
	}
	
	
}