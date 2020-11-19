/*
 * 
 */
package com.weapp.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.weapp.domain.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Authority.
 */
@Entity
public class Authority implements GrantedAuthority{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4231145663136058737L;
	
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
