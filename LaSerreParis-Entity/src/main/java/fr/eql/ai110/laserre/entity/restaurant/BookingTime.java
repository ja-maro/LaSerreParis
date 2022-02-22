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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "booking_time")
public class BookingTime  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "time")
	private LocalTime time;
	
	@OneToMany(mappedBy = "bookingTime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<WeeklyBookingTime> weeklyTimes;
	
	@OneToMany(mappedBy = "bookingTime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Booking> bookings;

	
	public BookingTime() {}

	public BookingTime(Integer id, LocalTime time, List<WeeklyBookingTime> weeklyTimes) {
		super();
		this.id = id;
		this.time = time;
		this.weeklyTimes = weeklyTimes;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public List<WeeklyBookingTime> getWeeklyTimes() {
		return weeklyTimes;
	}
	public void setWeeklyTimes(List<WeeklyBookingTime> weeklyTimes) {
		this.weeklyTimes = weeklyTimes;
	}
	
}
