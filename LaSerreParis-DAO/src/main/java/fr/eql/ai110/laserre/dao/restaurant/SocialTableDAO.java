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


		
System.out.println("&&&&&&&&&&&&&&&& SocialTableDAO");
		
		Integer sumOfSeats = 0;
		Query query = em.createQuery("SELECT st.seatsQuantity FROM SocialTable st WHERE st.hideDate IS NULL");

		List<Integer> seatQuantities = query.getResultList();
		
		System.out.println("size " + seatQuantities.size());
		
		for (Integer seats : seatQuantities) {
			sumOfSeats += seats;
		}
		System.out.println(sumOfSeats);
		return sumOfSeats;
	}
	
	

}
