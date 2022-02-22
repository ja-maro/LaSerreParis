package fr.eql.ai110.laserre.idao.restaurant;

import java.util.List;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.WeeklyBookingTime;
import fr.eql.ai110.laserre.idao.GenericIDAO;

public interface WeeklyBookingTimeIDAO extends GenericIDAO<WeeklyBookingTime> {

	/**
	 * Uses association entity WeeklyBookingTime to get all bookingTimes for a given week day.
	 * 
	 * @param id week day id (from java.time.LocalDate.getDayOfWeek().getValue())
	 * @return list of all BookingTime for given week day
	 */
	List<BookingTime> getBookingTimesByWeekDayId(int id);

}
