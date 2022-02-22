package fr.eql.ai110.laserre.dao.restaurant;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.restaurant.SocialTable;
import fr.eql.ai110.laserre.idao.restaurant.SocialTableIDAO;

@Remote(SocialTableIDAO.class)
@Stateless
public class SocialTableDAO extends GenericDAO<SocialTable> implements SocialTableIDAO {

	@Override
	public Integer getTotalSeatsNotHidden() {
		Integer sumOfSeats = 0;
		Query query = em.createQuery("SELECT st.seatsQuantity FROM SocialTable st WHERE st.hideDate IS NULL");

		List<Integer> seatQuantities = query.getResultList();
		
		for (Integer seats : seatQuantities) {
			sumOfSeats += seats;
		}
		return sumOfSeats;
	}

	@Override
	public List<SocialTable> getAllAvailable() {
		Query query = em.createQuery("SELECT st FROM SocialTable st WHERE st.hideDate IS NULL");
		return query.getResultList();
	}
	
	

}
