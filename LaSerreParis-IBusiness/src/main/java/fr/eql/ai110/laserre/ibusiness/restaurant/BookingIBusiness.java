package fr.eql.ai110.laserre.ibusiness.restaurant;

import java.time.LocalDate;
import java.util.List;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;

public interface BookingIBusiness {

	/**
	 * Checks if given day in part of an opening period.
	 * 
	 * @param day to compare to opening periods
	 * @return true if day is part of an opening period
	 */
	Boolean isOpenDay(LocalDate day);

	/**
	 * Returns list of BookingTime for given day by finding out which weekday it is.
	 * 
	 * @param day date for which the bookingTimes are needed.
	 * @return list of all BookingTimes for the given day
	 */
	List<BookingTime> getBookingTimes(LocalDate day);
	
	/**
	 * Highest number of seats not booked or on waitlist on a social table for the given BookingTime and date
	 * 
	 * @param date given date
	 * @param time given BookingTime
	 * @return Sum of all seats booked or on waitlist 
	 */
	Integer getMostSocialSeatsAvailable(LocalDate date, BookingTime time);

	/**
	 * Returns all non hidden SocialTables
	 * 
	 * @return available social tables
	 */
	List<SocialTable> getAllAvailableSocialTables();
	
	/**
	 * Returns any SocialTable with enough empty seats for the given booking.
	 * 
	 * @param booking the SocialTableBooking needing a table
	 * @return SocialTable with enough free seats
	 */
	SocialTable getFirstAvailableSocialTableForGuestNumber(SocialTableBooking booking);
	
	/**
	 * Saves given booking to BDD.
	 * 
	 * @param booking booking to save
	 * @return saved booking
	 */
	SocialTableBooking saveSocial(SocialTableBooking booking);

}
