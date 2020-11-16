package com.weapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weapp.web.ApplicationAdminController;
import com.weapp.web.ApplicationUserController;
import com.weapp.web.UserViewController;
import com.weapp.web.LoginController;

@SpringBootTest
class WeAppApplicationTests {
	
	@Autowired
	private LoginController loginController;
	
	@Autowired
	private ApplicationUserController applicationUserController;
	
	@Autowired
	private ApplicationAdminController applicationAdminController;
	
	@Autowired
	private UserViewController dashboardController;

	@Test
	void contextLoads() {
		assertThat(loginController).isNotNull();
		assertThat(applicationUserController).isNotNull();
		assertThat(applicationAdminController).isNotNull();
		assertThat(dashboardController).isNotNull();
	}

}
