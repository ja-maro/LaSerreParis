package fr.eql.ai110.laserre.controller.restaurant;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.ibusiness.restaurant.BookingIBusiness;

@ManagedBean(name = "mbRestaurant")
@SessionScoped
public class RestaurantManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<LocalDate> currentSevenDays;
	private LocalDate today;
	private Integer guestNumber;
	
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
		guestNumber = 3;
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
		int weekDayId = day.getDayOfWeek().getValue();
		return bookingBU.getBookingTimes(day);
	}

	/**
	 * Checks if booking of social table is possible for given time and date.
	 * 
	 * @param day day to check
	 * @param time time of day to check
	 * @return true if booking is possible
	 */
	public Boolean isBookingPossibleSocial(LocalDate day, BookingTime time) {

		System.out.println("@@@@@@@@@@@@@ RestaurantManagedBean  isBookingPossibleSocial ");
		Boolean isPossible = false;
		Integer availableSeats = bookingBU.getSocialSeatsAvailable(day, time);
		System.out.println("@@@@@@@@@@@@@ RestaurantMB  isBookingPossibleSocial available seats : " + availableSeats);
		if (availableSeats >= guestNumber) {
			isPossible = true;
		}	
		return isPossible;
	}
	
	public Boolean isWaitlistPossibleSocial(LocalDate day, BookingTime time) {
		
		//TODO
		
		return false;
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
	
	
	
	
}
