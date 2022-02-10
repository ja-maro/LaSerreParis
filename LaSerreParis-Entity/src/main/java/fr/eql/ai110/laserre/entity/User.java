package fr.eql.ai110.laserre.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "salt")
	private String salt;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "home_size")
	private Integer homeSize;
	@Column(name = "birth")
	private LocalDate birthDate;
	@Column(name = "validation_code")
	private String validationCode;
	@Column(name = "mail_validation_date")
	private LocalDate mailValidationDate;
	@Column(name = "deactivation_date")
	private LocalDate deactivationDate;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	
	
	public User() {
	}


	

	public User(String firstName, String lastName, String email, String address, String phone, Integer homeSize,
			LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.homeSize = homeSize;
		this.birthDate = birthDate;
	}




	public User(Integer id, String firstName, String lastName, String email, String password, String salt,
			String address, String phone, Integer homeSize, LocalDate birthDate, String validationCode,
			LocalDate mailValidationDate, LocalDate deactivationDate, List<Comment> comments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.address = address;
		this.phone = phone;
		this.homeSize = homeSize;
		this.birthDate = birthDate;
		this.validationCode = validationCode;
		this.mailValidationDate = mailValidationDate;
		this.deactivationDate = deactivationDate;
		this.comments = comments;
	}




	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getHomeSize() {
		return homeSize;
	}
	public void setHomeSize(Integer homeSize) {
		this.homeSize = homeSize;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	public LocalDate getMailValidationDate() {
		return mailValidationDate;
	}
	public void setMailValidationDate(LocalDate mailValidationDate) {
		this.mailValidationDate = mailValidationDate;
	}
	public LocalDate getDeactivationDate() {
		return deactivationDate;
	}
	public void setDeactivationDate(LocalDate deactivationDate) {
		this.deactivationDate = deactivationDate;
	}
	
}
