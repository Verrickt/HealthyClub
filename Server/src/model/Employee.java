package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String gender;
	private Integer age;
	private String phoneNumber;
	private String jobTitle;
	private String name;
	private String password;
	private Integer authority;
	private transient Set technicians = new HashSet(0);
	private transient Set paymentRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(String email, String gender, Integer age, String jobTitle,
			String name, String password, Integer authority) {
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.jobTitle = jobTitle;
		this.name = name;
		this.password = password;
		this.authority = authority;
	}

	/** full constructor */
	public Employee(String email, String gender, Integer age,
			String phoneNumber, String jobTitle, String name, String password,
			Integer authority, Set technicians, Set paymentRecords) {
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.jobTitle = jobTitle;
		this.name = name;
		this.password = password;
		this.authority = authority;
		this.technicians = technicians;
		this.paymentRecords = paymentRecords;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Set getTechnicians() {
		return this.technicians;
	}

	public void setTechnicians(Set technicians) {
		this.technicians = technicians;
	}

	public Set getPaymentRecords() {
		return this.paymentRecords;
	}

	public void setPaymentRecords(Set paymentRecords) {
		this.paymentRecords = paymentRecords;
	}

}