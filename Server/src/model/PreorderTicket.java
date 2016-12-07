package model;

import java.sql.Timestamp;

/**
 * PreorderTicket entity. @author MyEclipse Persistence Tools
 */

public class PreorderTicket implements java.io.Serializable {

	// Fields

	private Integer id;
	private DedicatedService dedicatedService;
	private MemberShipCard memberShipCard;
	private Timestamp orderedTime;
	private Timestamp preOrderedTime;
	private String status;
	private String reviewStatus;

	// Constructors

	/** default constructor */
	public PreorderTicket() {
	}

	/** minimal constructor */
	public PreorderTicket(DedicatedService dedicatedService,
			MemberShipCard memberShipCard, Timestamp orderedTime,
			Timestamp preOrderedTime) {
		this.dedicatedService = dedicatedService;
		this.memberShipCard = memberShipCard;
		this.orderedTime = orderedTime;
		this.preOrderedTime = preOrderedTime;
	}

	/** full constructor */
	public PreorderTicket(DedicatedService dedicatedService,
			MemberShipCard memberShipCard, Timestamp orderedTime,
			Timestamp preOrderedTime, String status, String reviewStatus) {
		this.dedicatedService = dedicatedService;
		this.memberShipCard = memberShipCard;
		this.orderedTime = orderedTime;
		this.preOrderedTime = preOrderedTime;
		this.status = status;
		this.reviewStatus = reviewStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DedicatedService getDedicatedService() {
		return this.dedicatedService;
	}

	public void setDedicatedService(DedicatedService dedicatedService) {
		this.dedicatedService = dedicatedService;
	}

	public MemberShipCard getMemberShipCard() {
		return this.memberShipCard;
	}

	public void setMemberShipCard(MemberShipCard memberShipCard) {
		this.memberShipCard = memberShipCard;
	}

	public Timestamp getOrderedTime() {
		return this.orderedTime;
	}

	public void setOrderedTime(Timestamp orderedTime) {
		this.orderedTime = orderedTime;
	}

	public Timestamp getPreOrderedTime() {
		return this.preOrderedTime;
	}

	public void setPreOrderedTime(Timestamp preOrderedTime) {
		this.preOrderedTime = preOrderedTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReviewStatus() {
		return this.reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

}