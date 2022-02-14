package fr.eql.ai110.laserre.entity.subscription;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_size")
public class SubscriptionSize implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "home_size_low")
	private Integer homeSizeLow;
	@Column(name = "home_size_high")
	private Integer homeSizeHigh;
	@Column(name = "display_home_size")
	private String displayHomeSize;
	
	@OneToMany(mappedBy="size", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SubscriptionOffer> offers;

	
	public SubscriptionSize() {
	}

	public SubscriptionSize(Integer id, String name, Integer homeSizeLow, Integer homeSizeHigh, String displayHomeSize,
			List<SubscriptionOffer> offers) {
		super();
		this.id = id;
		this.name = name;
		this.homeSizeLow = homeSizeLow;
		this.homeSizeHigh = homeSizeHigh;
		this.displayHomeSize = displayHomeSize;
		this.offers = offers;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHomeSizeLow() {
		return homeSizeLow;
	}
	public void setHomeSizeLow(Integer homeSizeLow) {
		this.homeSizeLow = homeSizeLow;
	}
	public Integer getHomeSizeHigh() {
		return homeSizeHigh;
	}
	public void setHomeSizeHigh(Integer homeSizeHigh) {
		this.homeSizeHigh = homeSizeHigh;
	}
	public String getDisplayHomeSize() {
		return displayHomeSize;
	}
	public void setDisplayHomeSize(String displayHomeSize) {
		this.displayHomeSize = displayHomeSize;
	}
	public List<SubscriptionOffer> getOffers() {
		return offers;
	}
	public void setOffers(List<SubscriptionOffer> offers) {
		this.offers = offers;
	}
	
	
}
