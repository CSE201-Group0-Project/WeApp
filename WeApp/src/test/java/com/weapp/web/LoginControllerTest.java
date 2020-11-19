/*
 * Thanks to Spring Security Reference 
 * https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/test-mockmvc.html
 */
package com.weapp.web;


import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.weapp.domain.User;

/**
 * The Class LoginControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;


	/**
	 * Test get login.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetLogin() throws Exception {
		this.mockMvc.perform(get("/login"))
		.andExpect(view().name("login"))
		.andExpect(status().isOk())
		.andReturn();
	}

	/**
	 * Test get register.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetRegister() throws Exception {
		User user = mock(User.class);
		this.mockMvc.perform(get("/register")
				.flashAttr("user", user))
		.andExpect(view().name("register"))
		.andExpect(status().isOk())
		.andReturn();
	}

	/**
	 * Test if a user can login and logout.
	 * 
	 * Thanks to Spring Security Reference 
	 * https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/test-mockmvc.html#securitymockmvcrequestbuilders
	 *
	 * @throws Exception the exception
	 */
	@Test 
	void testIfAUserCanLoginandLogout() throws Exception {
		mockMvc
		.perform(formLogin("/login")
				.user("admin")
				.password("pass"));
		
		mockMvc
        .perform(logout())
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/login?logout"));
	}
	
	  /**
  	 * Invalid login denied.
  	 * Thanks to Spring Security Reference 
  	 * https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/test-mockmvc.html#unauthenticated-assertion
  	 * @throws Exception the exception
  	 */
  	@Test
	  public void testInvalidLogin() throws Exception {
		// Given invalid password redirect to login?error
		// and verifies that no user is authenticated 
	    mockMvc
	            .perform(formLogin().password("invalid"))
	            .andExpect(status().isFound())
	            .andExpect(redirectedUrl("/login?error"))
	            .andExpect(unauthenticated());
	    
	    // Test if login?error is direct to login view 
	    mockMvc
	            .perform(get("/login?error"))
	            .andExpect(view().name("login"));
	  }
}
