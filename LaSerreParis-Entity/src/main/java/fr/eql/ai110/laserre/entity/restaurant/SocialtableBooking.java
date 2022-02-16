package fr.eql.ai110.laserre.entity.restaurant;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "social_table_booking")
public class SocialtableBooking extends Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "guest_number")
	private Integer guestNumber;
	@Column(name = "waitlist_inscription_date")
	private LocalDate waitlistInscriptionDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private SocialTable socialTable;

	
	public SocialtableBooking() {}

	public SocialtableBooking(Integer guestNumber, LocalDate waitlistInscriptionDate, SocialTable socialTable) {
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
