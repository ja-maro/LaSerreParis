package fr.eql.ai110.laserre.business.restaurant;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.OpeningPeriod;
import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;
import fr.eql.ai110.laserre.ibusiness.restaurant.BookingIBusiness;
import fr.eql.ai110.laserre.idao.restaurant.OpeningPeriodIDAO;
import fr.eql.ai110.laserre.idao.restaurant.SocialTableBookingIDAO;
import fr.eql.ai110.laserre.idao.restaurant.SocialTableIDAO;
import fr.eql.ai110.laserre.idao.restaurant.WeeklyBookingTimeIDAO;

@Remote(BookingIBusiness.class)
@Stateless
public class BookingBusiness implements BookingIBusiness {

	@EJB
	private OpeningPeriodIDAO periodDAO;
	@EJB
	private WeeklyBookingTimeIDAO wbtDAO;
	@EJB
	private SocialTableBookingIDAO socTBookingDAO;
	@EJB
	private SocialTableIDAO socTableDAO;
	
	
	@Override
	public Boolean isOpenDay(LocalDate day) {
		Boolean isOpen = false;
		OpeningPeriod period = periodDAO.getByDay(day);
		if (period != null) {
			isOpen = true;
		}
		return isOpen;
	}

	@Override
	public List<BookingTime> getBookingTimes(LocalDate day) {
		int id = day.getDayOfWeek().getValue();
		return wbtDAO.getBookingTimesByWeekDayId(id);
	}

	@Override
	public Integer getMostSocialSeatsAvailable(LocalDate date, BookingTime time) {	
		int availableSeats = 0;
		int mostAvailableSeats = 0;
		List<SocialTable> tables = socTableDAO.getAllAvailable();
		for (SocialTable table : tables) {
			availableSeats = table.getSeatsQuantity() - socTBookingDAO.getTotalGuestNumberByBookedDateAndBookingTimeAndSocialTable(date, time, table);
			if (availableSeats > mostAvailableSeats) {
				mostAvailableSeats = availableSeats;
			}
		}
		return mostAvailableSeats;
		
//		Integer availableSeats = socTableDAO.getTotalSeatsNotHidden();
//		Integer bookedSeats = socTBookingDAO.getTotalGuestNumberByBookedDateAndBookingTime(date, time);
//		return availableSeats - bookedSeats;

	}

	@Override
	public List<SocialTable> getAllAvailableSocialTables() {
		return socTableDAO.getAllAvailable();
	}

	@Override
	public SocialTable getFirstAvailableSocialTableForGuestNumber(SocialTableBooking booking) {
		for ( SocialTable table : getAllAvailableSocialTables()) {
			if (hasEnoughSeats(table, booking.getGuestNumber(), booking.getBookedDate(), booking.getBookingTime())) {
				
			}
		}
		return null;
	}

	/**
	 * Checks if given table has enough seats for given date, time and guest number
	 * 
	 * @param table
	 * @param guestNumber
	 * @param date
	 * @param time
	 * @return true if the booking can happen
	 */
	private boolean hasEnoughSeats(SocialTable table, Integer guestNumber, LocalDate date, BookingTime time) {
		Boolean hasEnoughSeats = false;
		int availableSeats = socTBookingDAO.getTotalGuestNumberByBookedDateAndBookingTimeAndSocialTable(date, time, table);
		if (availableSeats - guestNumber >= 0) {
			hasEnoughSeats = true;
		}
		return hasEnoughSeats;
	}

	@Override
	public SocialTableBooking saveSocial(SocialTableBooking booking) {
		return socTBookingDAO.add(booking);
	}

	
}
