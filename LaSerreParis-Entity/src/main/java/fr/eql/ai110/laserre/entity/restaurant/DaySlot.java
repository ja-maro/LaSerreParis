package fr.eql.ai110.laserre.entity.restaurant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "day_slot")
public class DaySlot implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private TimeSlot timeSlot;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private OpeningDay openingDay;
	
	@OneToOne(mappedBy = "daySlot")
	private Booking booking;

	public DaySlot() {}

	public DaySlot(Integer id, TimeSlot timeSlot, OpeningDay openingDay, Booking booking) {
		super();
		this.id = id;
		this.timeSlot = timeSlot;
		this.openingDay = openingDay;
		this.booking = booking;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	public OpeningDay getOpeningDay() {
		return openingDay;
	}
	public void setOpeningDay(OpeningDay openingDay) {
		this.openingDay = openingDay;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	
}
