/*
 * Thanks to Baeldung for Overview of JPA/Hibernate Cascade Types
 * https://www.baeldung.com/jpa-cascade-types
 * 
 * Thanks to Baeldung for Eager/Lazy Loading In Hibernate
 * https://www.baeldung.com/hibernate-lazy-eager-loading
 */
package com.weapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.weapp.security.Authority;

/**
 * Simple domain object representing a user.
 * 
 * @Entity is used to indicate that it is a JPA entity
 */
@Entity
@Table(name="users")
public class User {
	
	/** The id. */
	private int id; 
	
	/** The username. */
	private String username; 
	
	/** The password. */
	private String password; 
	
	/** The name. */
	private String name; 
	
	/** The authorities. */
	private Set<Authority> authorities = new HashSet<>(); 
	
	/** The applications. */
	private Set<Application> applications = new HashSet<>(); 
	
	/**
	 * Instantiates a new user.
	 */
	public User() {}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param authorities the authorities
	 * @param applications the applications
	 */
	public User(int id, String username, String password, String name, Set<Authority> authorities,
			Set<Application> applications) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.authorities = authorities;
		this.applications = applications;
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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the authorities.
	 * The set of authority is referencing the owner which is the user
	 * 
	 * @OneToMany indicate a one-to-many relationship 
	 * CascadeType.ALL make the parent's operations to propagate to all child entity
	 *
	 * @return the authorities
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	
	/**
	 * Sets the authorities.
	 *
	 * @param authorities the new authorities
	 */
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	/**
	 * Gets the applications.
	 * The set of application is referencing the owner which is the user
	 * 
	 * @OneToMany indicate a one-to-many relationship 
	 * CascadeType.PERSIST makes the persist operation to propagate from a parent to all child entity
	 * 
	 * FetchType.LAZY is a design pattern used to defer initialization of an entity as much as possible 
	 * Thanks to Baeldung for Eager/Lazy Loading In Hibernate
	 * https://www.baeldung.com/hibernate-lazy-eager-loading
	 * 
	 * 
	 * 
	 * @return the applications
	 */
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy="user")
	public Set<Application> getApplications() {
		return applications;
	}
	
	/**
	 * Sets the applications.
	 *
	 * @param applications the new applications
	 */
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", authorities=" + authorities + "]";
	}
	
}
