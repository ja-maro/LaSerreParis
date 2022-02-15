package fr.eql.ai110.laserre.ibusiness;

import java.util.List;

import fr.eql.ai110.laserre.entity.Comment;

public interface CommentIBusiness {

	/**
	 * Gets all comments to display on the index page
	 * 
	 * @return List of all comments with no hideDate and a validationDate
	 */
	List<Comment> getAllCommentsToDisplay();
}
