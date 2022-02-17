package fr.eql.ai110.laserre.entity.subscription;

import java.io.Serializable;
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
@Table(name = "season")
public class Season implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="season", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SubscriptionPeriod> periods;

	
	
	public Season(Integer id, String name, List<SubscriptionPeriod> periods) {
		super();
		this.id = id;
		this.name = name;
		this.periods = periods;
	}
	public Season() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SubscriptionPeriod> getPeriods() {
		return periods;
	}
	public void setPeriods(List<SubscriptionPeriod> periods) {
		this.periods = periods;
	}
	
	
}