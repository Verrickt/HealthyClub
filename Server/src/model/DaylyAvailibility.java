package model;

import java.sql.Time;

/**
 * DaylyAvailibility entity. @author MyEclipse Persistence Tools
 */

public class DaylyAvailibility implements java.io.Serializable {

	// Fields

	private Integer id;
	private Technician technician;
	private Time startTime;
	private Time endTime;
	private Integer dayOfWeek;

	// Constructors

	/** default constructor */
	public DaylyAvailibility() {
	}

	/** full constructor */
	public DaylyAvailibility(Technician technician, Time startTime,
			Time endTime, Integer dayOfWeek) {
		this.technician = technician;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dayOfWeek = dayOfWeek;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Technician getTechnician() {
		return this.technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

}