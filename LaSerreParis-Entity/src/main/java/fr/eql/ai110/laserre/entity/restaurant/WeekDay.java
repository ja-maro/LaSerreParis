package fr.eql.ai110.laserre.entity.restaurant;

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
@Table(name = "week_day")
public class WeekDay implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "weekDay", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<WeeklyBookingTime> weeklyTimes;

	
	public WeekDay() {}

	public WeekDay(Integer id, String name, List<WeeklyBookingTime> weeklyTimes) {
		super();
		this.id = id;
		this.name = name;
		this.weeklyTimes = weeklyTimes;
	}

	
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

	public List<WeeklyBookingTime> getWeeklyTimes() {
		return weeklyTimes;
	}

	public void setWeeklyTimes(List<WeeklyBookingTime> weeklyTimes) {
		this.weeklyTimes = weeklyTimes;
	}
	
}
