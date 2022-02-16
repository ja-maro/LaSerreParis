package fr.eql.ai110.laserre.entity.restaurant;

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
@Table(name = "opening_day")
public class OpeningDay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "day")
	private LocalDate day;
	
	@OneToMany(mappedBy = "openingDay", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DaySlot> daySlot;

	public OpeningDay() {}

	public OpeningDay(Integer id, LocalDate day, List<DaySlot> daySlot) {
		super();
		this.id = id;
		this.day = day;
		this.daySlot = daySlot;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public List<DaySlot> getDaySlot() {
		return daySlot;
	}
	public void setDaySlot(List<DaySlot> daySlot) {
		this.daySlot = daySlot;
	}


}
