package fr.eql.ai110.laserre.dao.restaurant;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.entity.restaurant.OpeningPeriod;
import fr.eql.ai110.laserre.idao.restaurant.OpeningPeriodIDAO;

@Remote(OpeningPeriodIDAO.class)
@Stateless
public class OpeningPeriodDAO extends GenericDAO<OpeningPeriod> implements OpeningPeriodIDAO {

	@Override
	public OpeningPeriod getByDay(LocalDate day) {
		List<OpeningPeriod> periods;
		OpeningPeriod period = null;
		
		Query query = em.createQuery("SELECT p FROM OpeningPeriod p WHERE :dayParam BETWEEN p.firstDay AND p.lastDay");
		query.setParameter("dayParam", day); 
		periods = query.getResultList();
		if (periods.size() > 0) {
			period = periods.get(0);
		}
		return period;
	}

}
