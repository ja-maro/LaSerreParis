package fr.eql.ai110.laserre.entity.restaurant;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="booking_type")
@Table(name = "booking")
public abstract class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "booked_date")
	private LocalDate bookedDate;
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	@Column(name = "cancel_date")
	private LocalDate cancelDate;
	@Column(name = "details")
	private String details;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_info")
	private String contactInfo;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private BookingTime bookingTime;
	
	@OneToOne(mappedBy = "booking")
	private WeeklyStatus weeklyStatus;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	

	public Booking() {}
	
	

	public Booking(LocalDate bookedDate, BookingTime bookingTime) {
		super();
		this.bookedDate = bookedDate;
		this.bookingTime = bookingTime;
	}



	public Booking(Integer id, LocalDate bookedDate, LocalDate bookingDate, LocalDate cancelDate, String details,
			String name, String contactInfo, BookingTime bookingTime, WeeklyStatus weeklyStatus, User user) {
		super();
		this.id = id;
		this.bookedDate = bookedDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.details = details;
		this.name = name;
		this.contactInfo = contactInfo;
		this.bookingTime = bookingTime;
		this.weeklyStatus = weeklyStatus;
		this.user = user;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(LocalDate cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public LocalDate getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}
	public BookingTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(BookingTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public WeeklyStatus getWeeklyStatus() {
		return weeklyStatus;
	}
	public void setWeeklyStatus(WeeklyStatus weeklyStatus) {
		this.weeklyStatus = weeklyStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
