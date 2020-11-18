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
 */
@Controller
public class ApplicationAdminController {
	
	/** The app service. */
	@Autowired
	private ApplicationService appService;

	/**
	 * Gets the applications.
	 *
	 * @param model the model
	 * @param keyword the keyword
	 * @return the applications
	 */
	@GetMapping("/applications") 
	public String getApplications(ModelMap model, @Param("keyword") String keyword) {
		List<Application> applications = new ArrayList<>(); 
		if(keyword != null) {
			applications = appService.findByKeywordForAdmin(keyword); 
			model.addAttribute("applications", applications);
			model.addAttribute("keyword", keyword);
		} else {
			applications = appService.findAll(); 
			model.put("applications", applications);
		}
		return "dashboard"; 
	}

	/**
	 * Gets the application request.
	 *
	 * @param model the model
	 * @return the application request
	 */
	@GetMapping("/applicationRequest") 
	public String getApplicationRequest(ModelMap model) {
		model.addAttribute(new Application()); 
		return "request-application"; 
	}

	/**
	 * Gets the application.
	 *
	 * @param applicationId the application id
	 * @param model the model
	 * @param response the response
	 * @return the application
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
	 * @return the string
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
	 * @return the string
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
	 * @param user the user
	 * @param application the application
	 * @return the string
	 */
	@PostMapping("save")
	public String saveApplication(@AuthenticationPrincipal User user, Application application) {
		application.setUser(user);
		appService.save(application);
		return "redirect:/dashboard"; 
	}
}