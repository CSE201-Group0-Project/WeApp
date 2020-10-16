package com.weapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

	@Test
	void generateEncryptedPassword() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		String rawPassword = "password123"; 
		String encryptedPassword = encoder.encode(rawPassword); 
		
		System.out.println(encryptedPassword);
		
		assertNotEquals(rawPassword, encryptedPassword);
	}

}
