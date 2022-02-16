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
@Table(name = "restaurant_table")
public class RestaurantTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "min_guests")
	private Integer minGuests;
	@Column(name = "max_guests")
	private Integer maxGuests;
	@Column(name = "hide_date")
	private LocalDate hideDate;
	
	@OneToMany(mappedBy = "table", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PrivateTableBooking> bookings;

	
	public RestaurantTable() {}

	public RestaurantTable(Integer id, Integer minGuests, Integer maxGuests, LocalDate hideDate,
			List<PrivateTableBooking> bookings) {
		super();
		this.id = id;
		this.minGuests = minGuests;
		this.maxGuests = maxGuests;
		this.hideDate = hideDate;
		this.bookings = bookings;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMinGuests() {
		return minGuests;
	}
	public void setMinGuests(Integer minGuests) {
		this.minGuests = minGuests;
	}
	public Integer getMaxGuests() {
		return maxGuests;
	}
	public void setMaxGuests(Integer maxGuests) {
		this.maxGuests = maxGuests;
	}
	public LocalDate getHideDate() {
		return hideDate;
	}
	public void setHideDate(LocalDate hideDate) {
		this.hideDate = hideDate;
	}
	public List<PrivateTableBooking> getBookings() {
		return bookings;
	}
	public void setBookings(List<PrivateTableBooking> bookings) {
		this.bookings = bookings;
	}

	
}
