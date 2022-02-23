package fr.eql.ai110.laserre.entity.restaurant;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;

@Entity
@DiscriminatorValue("social")
@Table(name = "social_table_booking")
public class SocialTableBooking extends Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "guest_number")
	private Integer guestNumber;
	@Column(name = "waitlist_inscription_date")
	private LocalDate waitlistInscriptionDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private SocialTable socialTable;

	
	public SocialTableBooking() {}
	
	

	public SocialTableBooking(LocalDate bookedDate, BookingTime bookingTime, Integer guestNumber) {
		super(bookedDate, bookingTime);
		this.guestNumber = guestNumber;
	}



	public SocialTableBooking(Integer guestNumber, LocalDate waitlistInscriptionDate, SocialTable socialTable) {
		super();
		this.guestNumber = guestNumber;
		this.waitlistInscriptionDate = waitlistInscriptionDate;
		this.socialTable = socialTable;
	}

	
	public Integer getGuestNumber() {
		return guestNumber;
	}
	public void setGuestNumber(Integer guestNumber) {
		this.guestNumber = guestNumber;
	}
	public LocalDate getWaitlistInscriptionDate() {
		return waitlistInscriptionDate;
	}
	public void setWaitlistInscriptionDate(LocalDate waitlistInscriptionDate) {
		this.waitlistInscriptionDate = waitlistInscriptionDate;
	}
	public SocialTable getSocialTable() {
		return socialTable;
	}
	public void setSocialTable(SocialTable socialTable) {
		this.socialTable = socialTable;
	}


}
