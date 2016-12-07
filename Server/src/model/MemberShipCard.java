package model;

import java.util.HashSet;
import java.util.Set;

/**
 * MemberShipCard entity. @author MyEclipse Persistence Tools
 */

public class MemberShipCard implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient MemberShipCardLevel memberShipCardLevel;
	private transient User user;
	private Double fund;
	private transient Set serviceTickets = new HashSet(0);
	private transient Set preorderTickets = new HashSet(0);

	// Constructors

	/** default constructor */
	public MemberShipCard() {
	}

	/** minimal constructor */
	public MemberShipCard(MemberShipCardLevel memberShipCardLevel, User user,
			Double fund) {
		this.memberShipCardLevel = memberShipCardLevel;
		this.user = user;
		this.fund = fund;
	}

	/** full constructor */
	public MemberShipCard(MemberShipCardLevel memberShipCardLevel, User user,
			Double fund, Set serviceTickets, Set preorderTickets) {
		this.memberShipCardLevel = memberShipCardLevel;
		this.user = user;
		this.fund = fund;
		this.serviceTickets = serviceTickets;
		this.preorderTickets = preorderTickets;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MemberShipCardLevel getMemberShipCardLevel() {
		return this.memberShipCardLevel;
	}

	public void setMemberShipCardLevel(MemberShipCardLevel memberShipCardLevel) {
		this.memberShipCardLevel = memberShipCardLevel;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getFund() {
		return this.fund;
	}

	public void setFund(Double fund) {
		this.fund = fund;
	}

	public Set getServiceTickets() {
		return this.serviceTickets;
	}

	public void setServiceTickets(Set serviceTickets) {
		this.serviceTickets = serviceTickets;
	}

	public Set getPreorderTickets() {
		return this.preorderTickets;
	}

	public void setPreorderTickets(Set preorderTickets) {
		this.preorderTickets = preorderTickets;
	}

}