package model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ServiceTicket entity. @author MyEclipse Persistence Tools
 */

public class ServiceTicket implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient DedicatedService dedicatedService;
	private transient MemberShipCard memberShipCard;
	private Timestamp orderedTime;
	private String status;
	private transient Set paymentRecords = new HashSet(0);

	public String dedicatedServiceName;
	public String getDedicatedServiceName() {
		return dedicatedServiceName;
	}

	public void setDedicatedServiceName(String dedicatedServiceName) {
		this.dedicatedServiceName = dedicatedServiceName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String userName;


	// Constructors

	/** default constructor */
	public ServiceTicket() {
	}

	/** minimal constructor */
	public ServiceTicket(DedicatedService dedicatedService,
			MemberShipCard memberShipCard, Timestamp orderedTime) {
		this.dedicatedService = dedicatedService;
		this.memberShipCard = memberShipCard;
		this.orderedTime = orderedTime;
		init();
	}

	public void init() {
		this.dedicatedServiceName=dedicatedService.getService().getName();
		this.userName=memberShipCard.getUser().getName();
	}

	/** full constructor */
	public ServiceTicket(DedicatedService dedicatedService,
			MemberShipCard memberShipCard, Timestamp orderedTime,
			String status, Set paymentRecords) {
		this.dedicatedService = dedicatedService;
		this.memberShipCard = memberShipCard;
		this.orderedTime = orderedTime;
		this.status = status;
		this.paymentRecords = paymentRecords;
		init();
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getPaymentRecords() {
		return this.paymentRecords;
	}

	public void setPaymentRecords(Set paymentRecords) {
		this.paymentRecords = paymentRecords;
	}

}