package fr.eql.ai110.laserre.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.Comment;
import fr.eql.ai110.laserre.idao.CommentIDAO;

@Remote(CommentIDAO.class)
@Stateless
public class CommentDAO extends GenericDAO<Comment> implements CommentIDAO {


}