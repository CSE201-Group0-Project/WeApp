package com.weapp.web;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.weapp.domain.User;

// TODO: Auto-generated Javadoc
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
	                .andDo(MockMvcResultHandlers.print())
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
			        .andDo(MockMvcResultHandlers.print())
			        .andReturn();
	}

}
