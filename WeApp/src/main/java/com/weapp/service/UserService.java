package com.weapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weapp.domain.User;
import com.weapp.repositories.UserRepository;
import com.weapp.security.Authority;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo; 
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
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
