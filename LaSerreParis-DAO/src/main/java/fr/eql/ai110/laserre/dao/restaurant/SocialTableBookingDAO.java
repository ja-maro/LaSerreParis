package fr.eql.ai110.laserre.dao.restaurant;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.entity.restaurant.SocialTableBooking;
import fr.eql.ai110.laserre.idao.restaurant.SocialTableBookingIDAO;

@Remote(SocialTableBookingIDAO.class)
@Stateless
public class SocialTableBookingDAO extends GenericDAO<SocialTableBooking> implements SocialTableBookingIDAO {


	@Override
	public Integer getTotalGuestNumberByBookedDateAndBookingTime(LocalDate date, BookingTime time) {
		Integer sumOfGuests = 0;
		Query query = em.createQuery("SELECT b.guestNumber FROM SocialTableBooking b WHERE b.bookedDate = :dateParam AND b.bookingTime = :timeParam");
		query.setParameter("dateParam", date);
		query.setParameter("timeParam", time);

		List<Integer> bookingGuests = query.getResultList();

		for (Integer guestNumber : bookingGuests) {
			sumOfGuests += guestNumber;
		}
		return sumOfGuests;
	}

	public Integer getTotalGuestNumberByBookedDateAndBookingTimeAndSocialTable(LocalDate date, BookingTime time, SocialTable table) {
		Integer sumOfGuests = 0;
		Query query = em.createQuery("SELECT b.guestNumber FROM SocialTableBooking b "
				+ "WHERE b.bookedDate = :dateParam AND b.bookingTime = :timeParam AND b.socialTable = :tableParam");
		query.setParameter("dateParam", date);
		query.setParameter("timeParam", time);
		query.setParameter("tableParam", table);

		List<Integer> bookingGuests = query.getResultList();

		for (Integer guestNumber : bookingGuests) {
			sumOfGuests += guestNumber;
		}
		return sumOfGuests;
	}
}
