package fr.eql.ai110.laserre.business.restaurant;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.OpeningPeriod;
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
	private SocialTableBookingIDAO SBDAO;
	@EJB
	private SocialTableIDAO STDAO;
	
	
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
	public Integer getSocialSeatsAvailable(LocalDate date, BookingTime time) {	
		System.out.println("$$$$$$$$$$$$$$$$$ BookingBU");
		Integer availableSeats = STDAO.getTotalSeatsNotHidden();
		System.out.println("availableSeats : " + availableSeats);
		Integer bookedSeats = SBDAO.getTotalGuestNumberByBookedDateAndBookingTime(date, time);
		System.out.println("bookedSeats : " + bookedSeats);
		return availableSeats - bookedSeats;
	}

	
}
