/*
 * Thanks to spring.io's Building an Application with Spring Boot guide for the introduction of @Controller
 * https://spring.io/guides/gs/spring-boot/
 * 
 * Thanks to Baeldung for the introduction of Spring MVC
 * https://www.baeldung.com/spring-mvc-model-model-map-model-view
 */
package com.weapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weapp.domain.Application;
import com.weapp.service.ApplicationService;

/**
 * The Class UserViewController.
 * @Controller tells Spring Model View Controller architecture that this class is used for web requests
 */
@Controller
public class UserViewController {


	/** The app service. */
	@Autowired
	private ApplicationService appService;

	/**
	 * Root view of the application
	 *
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @param keyword the keyword the keyword to search for 
	 * @param sortBy the sort by sort criteria 
	 * @return index view 
	 */
	@GetMapping("/")
	public String rootView (ModelMap model, @Param("keyword") String keyword, @Param("sortBy") String sortBy) {
		List<Application> applications = new ArrayList<>(); 
		List<String> categories = appService.findDistinctCategory(); 
		List<String> platforms = appService.findDistinctPlatform(); 
		// Pass categories as an attribute to render categories on index view 
		model.put("categories", categories); 
		// Pass platforms as an attribute to render platforms on index view 
		model.put("platforms", platforms);
		if(keyword != null) {
			// if keyword is not null then find applications by keyword
			applications = appService.findByKeyword(keyword); 
			// Pass applications as an attribute to render found applications on index view 
			model.addAttribute("applications", applications);
			model.addAttribute("keyword", keyword);
		} else if(sortBy != null) {
			if(sortBy.equals("name")) {
				applications = appService.findByOrderByNameAsc();
				// Pass applications as an attribute to render sorted applications on index view 
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			} 
			if(sortBy.equals("price")) {
				applications = appService.findByOrderByPriceDesc();
				// Pass applications as an attribute to render sorted applications on index view 
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			}
			if(sortBy.equals("")) {
				applications = appService.findByApproved(true);
				// Pass applications as an attribute to render found applications on index view 
				model.addAttribute("applications", applications);
			}
		} 		
		else {
			applications = appService.findByApproved(true);
			// Pass applications as an attribute to render found applications on index view 
			model.put("applications", applications);
		}

		return "index"; 
	}

	/**
	 * Filterd by category.
	 *
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @param category the category
	 * @return index view 
	 */
	@GetMapping("/c/{category}")
	public String filterdByCategory(ModelMap model, @PathVariable String category) {
		List<Application> applications = appService.findByCategory(category); 
		List<String> categories = appService.findDistinctCategory(); 
		List<String> platforms = appService.findDistinctPlatform(); 
		// Pass categories as an attribute to render categories on index view 
		// Pass platforms as an attribute to render platforms on index view 
		// Pass applications as an attribute to render applications on index view 
		model.put("categories", categories); 
		model.put("platforms", platforms); 
		model.put("applications", applications);
		return "index"; 
	}

	/**
	 * Filterd by platform.
	 *
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @param platform the platform
	 * @return index view 
	 */
	@GetMapping("/p/{platform}")
	public String filterdByPlatform(ModelMap model, @PathVariable String platform) {
		List<Application> applications = appService.findByPlatform(platform);
		List<String> categories = appService.findDistinctCategory(); 
		List<String> platforms = appService.findDistinctPlatform(); 
		// Pass categories as an attribute to render categories on index view 
		// Pass platforms as an attribute to render platforms on index view 
		// Pass applications as an attribute to render applications on index view 
		model.put("categories", categories); 
		model.put("platforms", platforms);
		model.put("applications", applications);
		return "index"; 
	}

}
