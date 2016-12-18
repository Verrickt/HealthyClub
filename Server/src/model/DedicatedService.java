package model;

import java.util.HashSet;
import java.util.Set;

/**
 * DedicatedService entity. @author MyEclipse Persistence Tools
 */

public class DedicatedService implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient Service service;
	private transient Technician technician;
	private Double price;

	// Constructors

	/** default constructor */
	public DedicatedService() {
	}



	/** full constructor */
	public DedicatedService(Service service, Technician technician,
			Double price) {
		this.service = service;
		this.technician = technician;
		this.price = price;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Technician getTechnician() {
		return this.technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

}