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
@Table(name = "time_slot")
public class TimeSlot implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "start_hour")
	private Integer startHour;
	@Column(name = "start_minute")
	private Integer startMinute;
	@Column(name = "end_hour")
	private Integer endHour;
	@Column(name = "end_minute")
	private Integer endMinute;

	@OneToMany(mappedBy = "timeSlot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DaySlot> daySlot;

	public TimeSlot() {}

	public TimeSlot(Integer id, Integer startHour, Integer startMinute, Integer endHour, Integer endMinute,
			List<DaySlot> daySlot) {
		super();
		this.id = id;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.daySlot = daySlot;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(Integer startMinute) {
		this.startMinute = startMinute;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public Integer getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}

	public List<DaySlot> getDaySlot() {
		return daySlot;
	}

	public void setDaySlot(List<DaySlot> daySlot) {
		this.daySlot = daySlot;
	}
	
}
