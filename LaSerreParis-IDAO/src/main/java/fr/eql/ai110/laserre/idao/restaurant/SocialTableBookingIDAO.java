package fr.eql.ai110.laserre.idao.restaurant;
import java.time.LocalDate;
import java.util.List;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface SocialTableBookingIDAO extends GenericIDAO<SocialTableBooking> {

	/**
	 * Sums all guests for the Social table at specified Day and BookingTime.
	 * 
	 * @param date given day
	 * @param time given BookingTime
	 * @return sum of all
	 */
	Integer getTotalGuestNumberByBookedDateAndBookingTime(LocalDate date, BookingTime time);
	
	/**
	 * Sums all guests for the Social table at specified Day and BookingTime for given SocialTable.
	 * 
	 * @param date given day
	 * @param time BookingTime
	 * @param table given SocialTable
	 * @return sum of all seats taken for given day and time for given SocialTable
	 */
	Integer getTotalGuestNumberByBookedDateAndBookingTimeAndSocialTable(LocalDate date, BookingTime time, SocialTable table);
	
	/**
	 * Returns all SocialTableBookings of given User.
	 * 
	 * @param user whose SocialtableBookings are needed
	 * @return all SocialTableBookings of user
	 */
	List<SocialTableBooking> getAllByUser(User user);
	
}
