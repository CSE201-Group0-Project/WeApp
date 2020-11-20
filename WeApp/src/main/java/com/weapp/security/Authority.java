/*
 * Thanks to Baeldung for Overview of JPA/Hibernate Cascade Types
 * https://www.baeldung.com/jpa-cascade-types
 */
package com.weapp.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.weapp.domain.User;

/**
 * The Class Authority.
 * 
 * @Entity is used to indicate that it is a JPA entity
 * GrantedAuthority represents an authority granted to an Authentication object.
 */
@Entity
public class Authority implements GrantedAuthority{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private int id; 
	
	/** The authority. */
	private String authority; 
	
	/** The user. */
	private User user; 

	/**
	 * Gets the authority.
	 *
	 * @return the authority
	 */
	@Override
	public String getAuthority() {
		return this.authority;
	}
	
	/**
	 * Sets the authority.
	 *
	 * @param authority the new authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	/**
	 * Gets the id.
	 * GenerationType.IDENTITY allows for auto-incremented of id 
	 * 
	 * Thanks to Baeldung for Overview of JPA/Hibernate Cascade Types
	 * https://www.baeldung.com/jpa-cascade-types
	 *
	 * @return the id
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	@ManyToOne()
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}


}
