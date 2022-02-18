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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_period")
public class SubscriptionPeriod implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "duration")
	private Integer duration;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Season season;
	
	@OneToMany(mappedBy="period", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;

	
	public SubscriptionPeriod() {
	}

	public SubscriptionPeriod(Integer id, LocalDate startDate, Integer duration, Season season,
			List<Subscription> subscriptions) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.duration = duration;
		this.season = season;
		this.subscriptions = subscriptions;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	
}