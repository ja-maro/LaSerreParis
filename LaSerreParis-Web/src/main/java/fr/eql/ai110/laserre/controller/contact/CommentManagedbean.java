package fr.eql.ai110.laserre.controller.contact;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.eql.ai110.laserre.entity.Comment;
import fr.eql.ai110.laserre.ibusiness.CommentIBusiness;

@ManagedBean(name = "mbComment")
@ViewScoped
public class CommentManagedbean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private CommentIBusiness comBU;

	public List<Comment> getDisplayedComments() {
		return comBU.getAllCommentsToDisplay();
	}
}
