/*
 * Thanks to Baeldung's Authentication with a Database-backed UserDetailsService
 * https://www.baeldung.com/spring-security-authentication-with-a-database
 */
package com.weapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weapp.domain.User;
import com.weapp.repositories.UserRepository;
import com.weapp.security.Authority;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service
public class UserService {
	
	/** The user repo. */
	@Autowired
	private UserRepository userRepo; 
	
	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	/**
	 * Save a new user with encrypted password in the user repository
	 * and set authority to ROLE_USER
	 *
	 * @param user the user
	 * @return the user
	 */
	public User save(User user) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		Authority authorities = new Authority(); 
		authorities.setAuthority("ROLE_USER");
		authorities.setUser(user);
		
		user.getAuthorities().add(authorities);
		return userRepo.save(user); 
	}
}
