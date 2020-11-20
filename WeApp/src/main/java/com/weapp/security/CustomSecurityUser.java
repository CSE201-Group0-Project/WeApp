/*
 * Thanks to spring.io documentation on UserDetails 
 * https://docs.spring.io/spring-security/site/docs/4.2.15.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html
 * 
 * Thanks to Baeldung's Authentication with a Database-backed UserDetailsService
 * https://www.baeldung.com/spring-security-authentication-with-a-database
 */
package com.weapp.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.weapp.domain.User;

/**
 * The Class CustomSecurityUser.
 * 
 * UserDetails provides core user information.
 */
public class CustomSecurityUser extends User implements UserDetails {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Instantiates a new custom security user.
	 */
	public CustomSecurityUser() {}
	
	/**
	 * Instantiates a new custom security user.
	 *
	 * @param user the user
	 */
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getName());
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return super.getUsername(); 
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
