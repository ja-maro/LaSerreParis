package fr.eql.ai110.laserre.idao;

import java.util.List;

import fr.eql.ai110.laserre.entity.Comment;

public interface CommentIDAO extends GenericIDAO<Comment> {

	List<Comment> getAllVisibleAndAccepted();
}
