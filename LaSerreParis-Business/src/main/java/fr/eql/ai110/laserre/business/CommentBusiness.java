package fr.eql.ai110.laserre.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.Comment;
import fr.eql.ai110.laserre.ibusiness.CommentIBusiness;
import fr.eql.ai110.laserre.idao.CommentIDAO;

@Remote(CommentIBusiness.class)
@Stateless
public class CommentBusiness implements CommentIBusiness {

	@EJB
	private CommentIDAO dao;

	@Override
	public List<Comment> getAllCommentsToDisplay() {
		return dao.getAllVisibleAndAccepted();
	}
}
