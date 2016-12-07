package model;

/**
 * HealthyDocument entity. @author MyEclipse Persistence Tools
 */

public class HealthyDocument implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String notes;

	// Constructors

	/** default constructor */
	public HealthyDocument() {
	}

	/** full constructor */
	public HealthyDocument(User user, String notes) {
		this.user = user;
		this.notes = notes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}