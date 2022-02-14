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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "premium_crop")
public class PremiumCrop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column (name = "picture")
	private String picture;
	@Column (name = "carousel_description")
	private String carouselDescription;
	@Column (name = "complete_description", length = 2000)
	private String completeDescription;
	@Column(name = "harvest_qty")
	private Integer harvestQty;
	@Column(name = "hide_date")
	private LocalDate hideDate;
	
	@OneToMany(mappedBy="crop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PremiumSubscriptionCrop> subscriptionCrops;

	public PremiumCrop() {
	}

	public PremiumCrop(Integer id, String name, String picture, String carouselDescription, String completeDescription,
			Integer harvestQty, LocalDate hideDate, List<PremiumSubscriptionCrop> subscriptionCrops) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.carouselDescription = carouselDescription;
		this.completeDescription = completeDescription;
		this.harvestQty = harvestQty;
		this.hideDate = hideDate;
		this.subscriptionCrops = subscriptionCrops;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCarouselDescription() {
		return carouselDescription;
	}

	public void setCarouselDescription(String carouselDescription) {
		this.carouselDescription = carouselDescription;
	}

	public String getCompleteDescription() {
		return completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		this.completeDescription = completeDescription;
	}

	public Integer getHarvestQty() {
		return harvestQty;
	}

	public void setHarvestQty(Integer harvestQty) {
		this.harvestQty = harvestQty;
	}

	public LocalDate getHideDate() {
		return hideDate;
	}

	public void setHideDate(LocalDate hideDate) {
		this.hideDate = hideDate;
	}

	public List<PremiumSubscriptionCrop> getSubscriptionCrops() {
		return subscriptionCrops;
	}

	public void setSubscriptionCrops(List<PremiumSubscriptionCrop> subscriptionCrops) {
		this.subscriptionCrops = subscriptionCrops;
	}
	
	
}