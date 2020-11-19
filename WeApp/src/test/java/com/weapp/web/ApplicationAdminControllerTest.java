/**
 * Thanks to Petri Kainulainen for the tutorial on configuration on Spring MVC framework unit test for controllers
 * https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
 * */
package com.weapp.web;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.Mockito.mock;

import java.util.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;


import com.weapp.domain.Application;
import com.weapp.domain.User;
import com.weapp.service.ApplicationService;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationAdminControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationAdminControllerTest {

	/** The context. */
	@Autowired
	private WebApplicationContext context;

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The app service. */
	@MockBean
	private ApplicationService appService; 

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	/**
	 * Find all should add app entries to model and render app list view.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "ad", roles = "ADMIN")
	public void findAll_ShouldAddAppEntriesToModelAndRenderAppListView() throws Exception {
		User user = mock(User.class);

		Application first = new Application(1, "One", "Number", user); 

		Application second = new Application(2, "Two", "Number", user); 

		when(appService.findAll()).thenReturn(Arrays.asList(first, second));


		mockMvc.perform(get("/applications"))
		.andExpect(status().isOk()) // Make sure that the HTTP status code 200 is returned.
		.andExpect(view().name("dashboard")) // Make sure the return view is dashboard 
		// Make sure that model attribute applications has two items in it.
		.andExpect(model().attribute("applications", hasSize(2)))
		// Make sure the model attribute applications contains the correct items
		.andExpect(model().attribute("applications", hasItem(
				allOf(
						hasProperty("id", is(1)),
						hasProperty("name", is("One")),
						hasProperty("category", is("Number")),
						hasProperty("user", is(user))
						)
				)))
		.andExpect(model().attribute("applications", hasItem(
				allOf(
						hasProperty("id", is(2)),
						hasProperty("name", is("Two")),
						hasProperty("category", is("Number")),
						hasProperty("user", is(user))
						)
				)));

		// Verify that the findAll method is invoked only once by the mock service 
		verify(appService, times(1)).findAll();
		// Make sure that other methods of mock service is not called during this test
		verifyNoMoreInteractions(appService);
	}

	/**
	 * Find by keyword should add app entries to model and render app list view.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "ad", roles = "ADMIN")
	public void findByKeyword_ShouldAddAppEntriesToModelAndRenderAppListView() throws Exception {
		User user = mock(User.class);

		Application first = new Application(1, "One", "Number", user); 

		Application second = new Application(2, "Two", "Number", user); 

		when(appService.findByKeywordForAdmin("number")).thenReturn(Arrays.asList(first, second));


		mockMvc.perform(get("/applications")
				.param("keyword", "number")) // Add the keyword request parameter to MockHttpServletRequest 
		.andExpect(status().isOk()) // Make sure that the HTTP status code 200 is returned.
		.andExpect(view().name("dashboard"))  // Make sure the return view is dashboard 
		.andExpect(model().attribute("keyword", "number")) 
		// Make sure that model attribute applications has two items in it.
		.andExpect(model().attribute("applications", hasSize(2))) 
		// Make sure the model attribute applications contains the correct items
		.andExpect(model().attribute("applications", hasItem(
				allOf(
						hasProperty("id", is(1)),
						hasProperty("name", is("One")),
						hasProperty("category", is("Number")),
						hasProperty("user", is(user))
						)
				)))
		.andExpect(model().attribute("applications", hasItem(
				allOf(
						hasProperty("id", is(2)),
						hasProperty("name", is("Two")),
						hasProperty("category", is("Number")),
						hasProperty("user", is(user))
						)
				)));

		// Verify that the findByKeywordForAdmin method is invoked only once by the mock service 
		verify(appService, times(1)).findByKeywordForAdmin("number");
		// Make sure that other methods of mock service is not called during this test
		verifyNoMoreInteractions(appService);
	}


	/**
	 * Test get application request.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(username = "testUser", password = "pass", roles = "USER")
	void testGetApplicationRequest() throws Exception {		
		mockMvc.perform(get("/applicationRequest")
				.sessionAttr("app", new Application()))
		.andExpect(view().name("request-application"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("app", hasProperty("id", is(0))))
		.andReturn();
	}

}
