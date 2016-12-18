package model;

import java.sql.Timestamp;

/**
 * PaymentRecord entity. @author MyEclipse Persistence Tools
 */

public class PaymentRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient PaymentMethod paymentMethod;
	private transient ServiceTicket serviceTicket;
	private transient Employee employee;
	private Double amount;
	private Timestamp timeFinished;

	// Constructors

	/** default constructor */
	public PaymentRecord() {
	}

	/** full constructor */
	public PaymentRecord(PaymentMethod paymentMethod,
			ServiceTicket serviceTicket, Employee employee, Double amount,
			Timestamp timeFinished) {
		this.paymentMethod = paymentMethod;
		this.serviceTicket = serviceTicket;
		this.employee = employee;
		this.amount = amount;
		this.timeFinished = timeFinished;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ServiceTicket getServiceTicket() {
		return this.serviceTicket;
	}

	public void setServiceTicket(ServiceTicket serviceTicket) {
		this.serviceTicket = serviceTicket;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getTimeFinished() {
		return this.timeFinished;
	}

	public void setTimeFinished(Timestamp timeFinished) {
		this.timeFinished = timeFinished;
	}

}