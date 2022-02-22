package fr.eql.ai110.laserre.dao.restaurant;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.restaurant.BookingTime;
import fr.eql.ai110.laserre.entity.restaurant.WeeklyBookingTime;
import fr.eql.ai110.laserre.idao.restaurant.WeeklyBookingTimeIDAO;

@Remote(WeeklyBookingTimeIDAO.class)
@Stateless
public class WeeklyBookingTimeDAO extends GenericDAO<WeeklyBookingTime> implements WeeklyBookingTimeIDAO {

	@Override
	public List<BookingTime> getBookingTimesByWeekDayId(int id) {
		Query query = em.createQuery("SELECT wbt.bookingTime FROM WeeklyBookingTime wbt WHERE wbt.weekDay.id = :idParam");
		query.setParameter("idParam", id);
		return query.getResultList();
	}

}
