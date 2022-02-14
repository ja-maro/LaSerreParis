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
@Table(name="contact_form")
public class ContactForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "title")
	private String title;
	@Column(name = "body")
	private String body;
	@Column(name = "creation_date")
	private LocalDate creationDate;
	@Column(name = "processing_start_date")
	private LocalDate processingStartDate;
	@Column(name = "processing_end_date")
	private LocalDate processingEndDate;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private ContactFormType type;


	public ContactForm() {
	}

	
	
	public ContactForm(String email, String name, String phone, String title, String body, ContactFormType type) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.title = title;
		this.body = body;
		this.type = type;
	}



	public ContactForm(Integer id, String email, String name, String phone, String title, String body,
			LocalDate creationDate, LocalDate processingStartDate, LocalDate processingEndDate, ContactFormType type) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.title = title;
		this.body = body;
		this.creationDate = creationDate;
		this.processingStartDate = processingStartDate;
		this.processingEndDate = processingEndDate;
		this.type = type;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getProcessingStartDate() {
		return processingStartDate;
	}
	public void setProcessingStartDate(LocalDate processingStartDate) {
		this.processingStartDate = processingStartDate;
	}
	public LocalDate getProcessingEndDate() {
		return processingEndDate;
	}
	public void setProcessingEndDate(LocalDate processingEndDate) {
		this.processingEndDate = processingEndDate;
	}
	public ContactFormType getType() {
		return type;
	}
	public void setType(ContactFormType type) {
		this.type = type;
	}
	

}
