package fr.eql.ai110.laserre.business.restaurant;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.faces.application.FacesMessage;

import fr.eql.ai110.laserre.entity.User;
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
	public SocialTable getFirstAvailableSocialTableForBooking(SocialTableBooking booking) {
		SocialTable openTable = null;
		List<SocialTable> tables = socTableDAO.getAllAvailable();
		for ( SocialTable table : tables) {
			if (hasEnoughSeats(table, booking.getGuestNumber(), booking.getBookedDate(), booking.getBookingTime())) {
				openTable = table;
				break;
			} 
		}
		return openTable;
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
	public boolean hasEnoughSeats(SocialTable table, Integer guestNumber, LocalDate date, BookingTime time) {
		Boolean hasEnoughSeats = false;
		int bookedSeats = socTBookingDAO.getTotalGuestNumberByBookedDateAndBookingTimeAndSocialTable(date, time, table);
		int availableSeats = table.getSeatsQuantity() - bookedSeats;
		if (availableSeats - guestNumber >= 0) {
			hasEnoughSeats = true;
		}
		return hasEnoughSeats;
	}

	@Override
	public SocialTableBooking saveSocial(SocialTableBooking booking) {
		return socTBookingDAO.add(booking);
	}

	@Override
	public List<SocialTableBooking> finbdAllSocialTableBookingByUser(User user) {
		List<SocialTableBooking> list = socTBookingDAO.getAllByUser(user);

		list.sort((o1,o2) -> o1.getBookingTime().getTime().compareTo(o2.getBookingTime().getTime()));
		list.sort((o1,o2) -> o1.getBookedDate().compareTo(o2.getBookedDate()));
		return list;
	}

	@Override
	public boolean checkGuestNumber(Integer nbr) {
		Boolean isValid = false;
		if (nbr != null && nbr > 0 && nbr <= MAX_GUEST_NUMBER_FOR_BOOKING) {
			isValid = true;
		}
		return isValid;
	}


}
