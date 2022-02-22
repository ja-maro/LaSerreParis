package fr.eql.ai110.laserre.entity.restaurant;

import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name = "weekly_booking_time")
public class WeeklyBookingTime implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private WeekDay weekDay;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private BookingTime bookingTime;

	
	public WeeklyBookingTime() {}
	
	public WeeklyBookingTime(Integer id, WeekDay weekDay, BookingTime bookingTime) {
		super();
		this.id = id;
		this.weekDay = weekDay;
		this.bookingTime = bookingTime;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public WeekDay getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public BookingTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(BookingTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	
}
