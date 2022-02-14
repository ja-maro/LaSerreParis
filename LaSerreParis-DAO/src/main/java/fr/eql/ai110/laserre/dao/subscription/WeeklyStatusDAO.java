package fr.eql.ai110.laserre.dao.subscription;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.WeeklyStatus;
import fr.eql.ai110.laserre.idao.subscription.WeeklyStatusIDAO;

@Remote(WeeklyStatusIDAO.class)
@Stateless
public class WeeklyStatusDAO extends GenericDAO<WeeklyStatus> implements WeeklyStatusIDAO {


}