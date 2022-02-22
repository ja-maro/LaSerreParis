package fr.eql.ai110.laserre.idao.restaurant;
import java.time.LocalDate;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SocialTableBookingIDAO extends GenericIDAO<SocialTableBooking> {

	/**
	 * Sums all guests for the Social table at specified Day and BookingTime
	 * 
	 * @param date
	 * @param time
	 * @return sum of all
	 */
	Integer getTotalGuestNumberByBookedDateAndBookingTime(LocalDate date, BookingTime time);
}
