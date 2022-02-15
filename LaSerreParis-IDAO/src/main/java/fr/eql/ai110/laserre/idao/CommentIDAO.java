package fr.eql.ai110.laserre.idao;

import java.util.List;

import fr.eql.ai110.laserre.entity.Comment;

public interface CommentIDAO extends GenericIDAO<Comment> {

	/**
	 * Returns a list of Comment from database where hideDate IS NULL and ValidationDate IS NOT NULL
	 * @return
	 */
	List<Comment> getAllVisibleAndAccepted();
}
