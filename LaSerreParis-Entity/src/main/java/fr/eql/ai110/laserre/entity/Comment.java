package fr.eql.ai110.laserre.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="text")
	private String text;
	@Column(name="submission_date")
	private LocalDate submissionDate;
	@Column(name="validation_date")
	private LocalDate validationDate;
	@Column(name="rejection_date")
	private LocalDate rejectionDate;
	@Column(name="hide_date")
	private LocalDate hideDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;

	
	public Comment(Integer id, String text, LocalDate submissionDate, LocalDate validationDate, LocalDate rejectionDate,
			LocalDate hideDate, User user) {
		super();
		this.id = id;
		this.text = text;
		this.submissionDate = submissionDate;
		this.validationDate = validationDate;
		this.rejectionDate = rejectionDate;
		this.hideDate = hideDate;
		this.user = user;
	}

	public Comment() {
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDate getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
	public LocalDate getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(LocalDate validationDate) {
		this.validationDate = validationDate;
	}
	public LocalDate getRejectionDate() {
		return rejectionDate;
	}
	public void setRejectionDate(LocalDate rejectionDate) {
		this.rejectionDate = rejectionDate;
	}
	public LocalDate getHideDate() {
		return hideDate;
	}
	public void setHideDate(LocalDate hideDate) {
		this.hideDate = hideDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
