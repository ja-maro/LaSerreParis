package fr.eql.ai110.laserre.controller.restaurant;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai110.laserre.controller.roles.UserRolesManagedBean;
import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;
import fr.eql.ai110.laserre.ibusiness.restaurant.BookingIBusiness;

@ManagedBean(name = "mbRestaurant")
@SessionScoped
public class RestaurantManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<LocalDate> currentSevenDays;
	private LocalDate today;
	private Integer guestNumber;
	@ManagedProperty(value="#{mbUser}")
    private UserRolesManagedBean mbUser;

	@EJB
	private BookingIBusiness bookingBU;

	@PostConstruct
	public void init() {
		currentSevenDays = new ArrayList<LocalDate>();
		today = LocalDate.now();
		for (int i = 0; i < 7; i++) {
			LocalDate day = today.plusDays(i);
			currentSevenDays.add(day);
		}
//		guestNumber = 3;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String displayBookings() {
		String forward = null;
		if (guestNumber != null && guestNumber > 0 && guestNumber < 16) {
			forward = "booking.xhtml?faces-redirect=true";
		}
		return forward;
	}
	/**
	 * Checks whether the given day is part of an opening period.
	 * 
	 * @param day to compare to opening periods
	 * @return true if day is part of an opening period
	 */
	public Boolean isOpenDay(LocalDate day) {
		return bookingBU.isOpenDay(day);
	}

	/**
	 * Get generic BookingTimes for given day, depending on which day of the week it is.
	 * 
	 * @param day Day for which booking times are needed.
	 * @return List of all BookingTimes for given day.
	 */
	public List<BookingTime> getBookingTimes(LocalDate day) {
		return bookingBU.getBookingTimes(day);
	}

	/**
	 * Checks if booking of social table is possible for given time and date and guestNumber of the ManagedBean.
	 * 
	 * @param day day to check
	 * @param time time of day to check
	 * @return true if booking is possible
	 */
	public Boolean isBookingPossibleSocial(LocalDate day, BookingTime time) {
		Boolean isPossible = false;
		
		SocialTableBooking booking = new SocialTableBooking(day, time, guestNumber);
		System.out.println(booking.getBookedDate() + " " + booking.getGuestNumber() + " " + booking.getBookingTime().getTime());
		SocialTable opentable = bookingBU.getFirstAvailableSocialTableForBooking(booking);
		
		if (opentable != null) {
			isPossible = true;
		}	
		return isPossible;
	}

	//TODO
	public Boolean isWaitlistPossibleSocial(LocalDate day, BookingTime time) {

		//TODO

		return false;
	}
	/**
	 * Checks if booking of private table is possible for given time and date and guestNumber of the ManagedBean.
	 * 
	 * @param day day to check
	 * @param time time of day to check
	 * @return true if booking is possible
	 */
	public Boolean isBookingPossiblePrivate(LocalDate day, BookingTime time) {

		//TODO

		return false;
	}

	//TODO
	public String bookSocial(LocalDate day, BookingTime time) {
		String forward = null;
		
		if (!mbUser.isConnected()) {
			forward = "/bookingDetailsSocial.xhtml?faces-redirection=true";
		}
		if (isBookingPossibleSocial(day, time)) {
			SocialTableBooking booking = new SocialTableBooking(day, time, guestNumber);
			booking.setUser(mbUser.getUser());
	
			SocialTable table = bookingBU.getFirstAvailableSocialTableForBooking(booking);
			booking.setSocialTable(table);
			booking.setBookingDate(LocalDate.now());
			
			bookingBU.saveSocial(booking);
			
			forward ="/user.xhtml?faces-redirection=false";
		}
		return forward;
	}

	//TODO
	public String bookPrivate(LocalDate day, BookingTime time) {
		//TODO
		return null;
	}

	
	public List<LocalDate> getCurrentSevenDays() {
		return currentSevenDays;
	}
	public void setCurrentSevenDays(List<LocalDate> currentSevenDays) {
		this.currentSevenDays = currentSevenDays;
	}
	public LocalDate getToday() {
		return today;
	}
	public void setToday(LocalDate today) {
		this.today = today;
	}
	public Integer getGuestNumber() {
		return guestNumber;
	}
	public void setGuestNumber(Integer guestNumber) {
		this.guestNumber = guestNumber;
	}
	public UserRolesManagedBean getMbUser() {
		return mbUser;
	}
	public void setMbUser(UserRolesManagedBean mbUser) {
		this.mbUser = mbUser;
	}




}
