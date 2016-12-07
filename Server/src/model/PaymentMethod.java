package model;

import java.util.HashSet;
import java.util.Set;

/**
 * PaymentMethod entity. @author MyEclipse Persistence Tools
 */

public class PaymentMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private transient Set paymentRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public PaymentMethod() {
	}

	/** minimal constructor */
	public PaymentMethod(String name) {
		this.name = name;
	}

	/** full constructor */
	public PaymentMethod(String name, Set paymentRecords) {
		this.name = name;
		this.paymentRecords = paymentRecords;
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

	public Set getPaymentRecords() {
		return this.paymentRecords;
	}

	public void setPaymentRecords(Set paymentRecords) {
		this.paymentRecords = paymentRecords;
	}

}