package model;

import java.util.HashSet;
import java.util.Set;

/**
 * MemberShipCardLevel entity. @author MyEclipse Persistence Tools
 */

public class MemberShipCardLevel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String levelName;
	private transient Set memberShipCards = new HashSet(0);

	// Constructors

	/** default constructor */
	public MemberShipCardLevel() {
	}

	/** minimal constructor */
	public MemberShipCardLevel(String levelName) {
		this.levelName = levelName;
	}

	/** full constructor */
	public MemberShipCardLevel(String levelName, Set memberShipCards) {
		this.levelName = levelName;
		this.memberShipCards = memberShipCards;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Set getMemberShipCards() {
		return this.memberShipCards;
	}

	public void setMemberShipCards(Set memberShipCards) {
		this.memberShipCards = memberShipCards;
	}

}