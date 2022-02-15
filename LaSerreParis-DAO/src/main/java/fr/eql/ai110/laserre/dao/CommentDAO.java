package fr.eql.ai110.laserre.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai110.laserre.entity.Comment;
import fr.eql.ai110.laserre.idao.CommentIDAO;

@Remote(CommentIDAO.class)
@Stateless
public class CommentDAO extends GenericDAO<Comment> implements CommentIDAO {

	@Override
	public List<Comment> getAllVisibleAndAccepted() {
		Query query = em.createQuery("SELECT c FROM Comment c WHERE c.hideDate IS NULL AND c.validationDate IS NOT NULL");
		return query.getResultList();
	}

	

}