package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Technician entity. @author MyEclipse Persistence Tools
 */

public class Technician implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient Employee employee;
	private transient Set daylyAvailibilities = new HashSet(0);
	private transient Set dedicatedServices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Technician() {
	}

	/** minimal constructor */
	public Technician(Employee employee) {
		this.employee = employee;
	}

	/** full constructor */
	public Technician(Employee employee, Set daylyAvailibilities,
			Set dedicatedServices) {
		this.employee = employee;
		this.daylyAvailibilities = daylyAvailibilities;
		this.dedicatedServices = dedicatedServices;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set getDaylyAvailibilities() {
		return this.daylyAvailibilities;
	}

	public void setDaylyAvailibilities(Set daylyAvailibilities) {
		this.daylyAvailibilities = daylyAvailibilities;
	}

	public Set getDedicatedServices() {
		return this.dedicatedServices;
	}

	public void setDedicatedServices(Set dedicatedServices) {
		this.dedicatedServices = dedicatedServices;
	}

}