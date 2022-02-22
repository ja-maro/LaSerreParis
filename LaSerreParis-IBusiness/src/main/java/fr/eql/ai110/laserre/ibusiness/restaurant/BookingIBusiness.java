package fr.eql.ai110.laserre.ibusiness.restaurant;

import java.time.LocalDate;
import java.util.List;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;

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
	 * Sum of all seats booked or on waitlist on the social table for the given BookingTime and date
	 * 
	 * @param date given date
	 * @param time given BookingTime
	 * @return Sum of all seats booked or on waitlist 
	 */
	Integer getSocialSeatsAvailable(LocalDate date, BookingTime time);


}
