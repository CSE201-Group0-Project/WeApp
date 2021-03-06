/*
 * Thanks to Baeldung's Authentication with a Database-backed UserDetailsService
 * https://www.baeldung.com/spring-security-authentication-with-a-database
 */
package com.weapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weapp.domain.User;
import com.weapp.repositories.UserRepository;
import com.weapp.security.CustomSecurityUser;

/**
 * The Class UserDetailsServiceImpl.
 * 
 * Core interface which loads user-specific data.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** The user repo. */
	@Autowired
	private UserRepository userRepo;

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username and password");
		}

		return new CustomSecurityUser(user);
	}

}