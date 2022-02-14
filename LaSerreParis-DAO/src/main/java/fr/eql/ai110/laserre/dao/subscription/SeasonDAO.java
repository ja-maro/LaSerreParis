package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.Season;
import fr.eql.ai110.laserre.idao.subscription.SeasonIDAO;

@Remote(SeasonIDAO.class)
@Stateless
public class SeasonDAO extends GenericDAO<Season> implements SeasonIDAO {

	
}
