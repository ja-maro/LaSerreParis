package fr.eql.ai110.laserre.dao.subscription;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.dao.GenericDAO;
import fr.eql.ai110.laserre.entity.subscription.PremiumCrop;
import fr.eql.ai110.laserre.idao.subscription.PremiumCropIDAO;

@Remote(PremiumCropIDAO.class)
@Stateless
public class PremiumCropDAO extends GenericDAO<PremiumCrop> implements PremiumCropIDAO {

	@Override
	public List<PremiumCrop> getAllVisible() {
		Query query = em.createQuery("SELECT pc FROM PremiumCrop pc WHERE pc.hideDate IS NULL");
		return query.getResultList();
	}
}
