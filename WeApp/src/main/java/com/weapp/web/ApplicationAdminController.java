/*
 * Thanks to spring.io's Building an Application with Spring Boot guide for the introduction of @Controller
 * https://spring.io/guides/gs/spring-boot/
 * 
 * Thanks to Baeldung for the introduction of Spring MVC
 * https://www.baeldung.com/spring-mvc-model-model-map-model-view
 */
package com.weapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.weapp.domain.Application;
import com.weapp.domain.User;
import com.weapp.service.ApplicationService;

/**
 * The Class ApplicationAdminController.
 * @Controller tells Spring Model View Controller architecture that this class is used for web requests
 */
@Controller
public class ApplicationAdminController {

	/** The app service. */
	@Autowired
	private ApplicationService appService;

	/**
	 * Dashboard view for admins.
	 *
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @param keyword the keyword to search for 
	 * @param sortBy the sort by sort criteria 
	 * @return dashboard
	 */
	@GetMapping("/dashboard")
	public String getDashboardView(ModelMap model, @Param("keyword") String keyword, @Param("sortBy") String sortBy) {
		List<Application> applications = new ArrayList<>(); 
		if(keyword != null) {
			applications = appService.findByKeywordForAdmin(keyword); 
			model.addAttribute("applications", applications);
			model.addAttribute("keyword", keyword);
		} else if(sortBy != null) {
			if(sortBy.equals("false")) {
				applications = appService.findByApproved(false); 
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			} 
			if(sortBy.equals("true")) {
				applications = appService.findByApproved(true); 
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			}
			if(sortBy.equals("")) {
				applications = appService.findAll(); 
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			}
		} else {
			applications = appService.findAll(); 
			model.put("applications", applications);
		}
		return "dashboard"; 

	}

	/**
	 * Gets the application request.
	 *
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @return the application request
	 */
	@GetMapping("/applicationRequest") 
	public String getApplicationRequest(ModelMap model) {
		model.addAttribute("app", new Application()); 
		return "request-application"; 
	}

	/**
	 * Gets the application.
	 * 
	 * See documentation on HttpServletResponse
	 * https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletResponse.html
	 *
	 * @param applicationId the application id
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @param response the HttpServletResponse
	 * @return edit application view 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/applications/{applicationId}")
	public String getApplication(@PathVariable int applicationId, ModelMap model, HttpServletResponse response) throws IOException {
		Optional<Application> appOpt = appService.findById(applicationId);

		if (appOpt.isPresent()) {
			Application application = appOpt.get();
			model.addAttribute("application", application);
		} else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Application with id " + applicationId + " was not found");
			return "edit-application";
		}   
		return "edit-application";
	}

	/**
	 * Edits the application.
	 *
	 * @param applicationId the application id
	 * @param application the application
	 * @return the dashboard view 
	 */
	@PostMapping("/applications/{applicationId}")
	public String editApplication(@PathVariable int applicationId, Application application) {
		appService.save(application);  
		System.out.println(application.toString());
		return "redirect:/dashboard";

	}

	/**
	 * Delete application.
	 *
	 * @param applicationId the application id
	 * @param application the application
	 * @return applications view
	 */
	@GetMapping("/applications/{applicationId}/delete")
	public String deleteApplication(@PathVariable int applicationId, Application application) {
		appService.findById(applicationId)
		.orElseThrow(() -> new IllegalArgumentException("Invalid application id:" + applicationId));
		appService.deleteApplication(applicationId);
		return "redirect:/applications";
	}

	/**
	 * Save application.
	 *
	 * @param user the user who is making the request 
	 * @param application the application request
	 * @return dashboard view 
	 */
	@PostMapping("save")
	public String saveApplication(@AuthenticationPrincipal User user, Application application) {
		application.setUser(user);
		appService.save(application);
		return "redirect:/dashboard"; 
	}
	}