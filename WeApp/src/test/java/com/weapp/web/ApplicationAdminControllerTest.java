/**
 * Thanks Petri Kainulainen for the tutorial on configuration on Spring MVC framework unit test for controllers
 * https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
 * 
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
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard"))
                .andExpect(model().attribute("applications", hasSize(2)))
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
 
        verify(appService, times(1)).findAll();
        verifyNoMoreInteractions(appService);
    }

}
