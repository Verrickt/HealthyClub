package model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String email;
	private String gender;
	private Integer age;
	private String phoneNumber;
	private String password;
	private transient Set memberShipCards = new HashSet(0);
	private transient Set healthyDocuments = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String phoneNumber, String password) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String email, String gender, Integer age,
			String phoneNumber, String password, Set memberShipCards,
			Set healthyDocuments) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.memberShipCards = memberShipCards;
		this.healthyDocuments = healthyDocuments;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getMemberShipCards() {
		return this.memberShipCards;
	}

	public void setMemberShipCards(Set memberShipCards) {
		this.memberShipCards = memberShipCards;
	}

	public Set getHealthyDocuments() {
		return this.healthyDocuments;
	}

	public void setHealthyDocuments(Set healthyDocuments) {
		this.healthyDocuments = healthyDocuments;
	}

}