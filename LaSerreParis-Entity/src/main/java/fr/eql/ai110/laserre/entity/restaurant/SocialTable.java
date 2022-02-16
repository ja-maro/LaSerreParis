package fr.eql.ai110.laserre.entity.restaurant;

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
@Table(name = "social_table")
public class SocialTable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "seats_quantity")
	private Integer seatsQuantity;
	@Column(name = "subscriptors_held_seats")
	private Integer subscriptorsHeldSeats;
	@Column(name = "hide_date")
	private LocalDate hideDate;

	@OneToMany(mappedBy = "socialTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SocialtableBooking> bookings;

	public SocialTable() {}

	public SocialTable(Integer id, Integer seatsQuantity, Integer subscriptorsHeldSeats, LocalDate hideDate,
			List<SocialtableBooking> bookings) {
		super();
		this.id = id;
		this.seatsQuantity = seatsQuantity;
		this.subscriptorsHeldSeats = subscriptorsHeldSeats;
		this.hideDate = hideDate;
		this.bookings = bookings;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeatsQuantity() {
		return seatsQuantity;
	}
	public void setSeatsQuantity(Integer seatsQuantity) {
		this.seatsQuantity = seatsQuantity;
	}
	public Integer getSubscriptorsHeldSeats() {
		return subscriptorsHeldSeats;
	}
	public void setSubscriptorsHeldSeats(Integer subscriptorsHeldSeats) {
		this.subscriptorsHeldSeats = subscriptorsHeldSeats;
	}
	public LocalDate getHideDate() {
		return hideDate;
	}
	public void setHideDate(LocalDate hideDate) {
		this.hideDate = hideDate;
	}
	public List<SocialtableBooking> getBookings() {
		return bookings;
	}
	public void setBookings(List<SocialtableBooking> bookings) {
		this.bookings = bookings;
	}
	
	
	
}
