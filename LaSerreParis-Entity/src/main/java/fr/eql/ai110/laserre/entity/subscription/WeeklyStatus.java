package fr.eql.ai110.laserre.entity.subscription;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weekly_status")
public class WeeklyStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "start_day")
	private LocalDate startDay;
	@Column(name = "delivery_decision_date")
	private LocalDate deliveryDecisionDate;
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Subscription subscription;

	public WeeklyStatus() {}

	public WeeklyStatus(Integer id, LocalDate startDay, LocalDate deliveryDecisionDate, LocalDate deliveryDate,
			Subscription subscription) {
		super();
		this.id = id;
		this.startDay = startDay;
		this.deliveryDecisionDate = deliveryDecisionDate;
		this.deliveryDate = deliveryDate;
		this.subscription = subscription;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getStartDay() {
		return startDay;
	}
	public void setStartDay(LocalDate startDay) {
		this.startDay = startDay;
	}
	public LocalDate getDeliveryDecisionDate() {
		return deliveryDecisionDate;
	}
	public void setDeliveryDecisionDate(LocalDate deliveryDecisionDate) {
		this.deliveryDecisionDate = deliveryDecisionDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	
}