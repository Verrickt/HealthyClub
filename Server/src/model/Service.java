package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Service entity. @author MyEclipse Persistence Tools
 */

public class Service implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private transient Set dedicatedServices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Service() {
	}

	/** minimal constructor */
	public Service(String name) {
		this.name = name;
	}

	/** full constructor */
	public Service(String name, Set dedicatedServices) {
		this.name = name;
		this.dedicatedServices = dedicatedServices;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getDedicatedServices() {
		return this.dedicatedServices;
	}

	public void setDedicatedServices(Set dedicatedServices) {
		this.dedicatedServices = dedicatedServices;
	}

}