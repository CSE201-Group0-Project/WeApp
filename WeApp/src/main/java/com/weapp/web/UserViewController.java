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
import com.weapp.repositories.ApplicationRepository;
import com.weapp.service.ApplicationService;

@Controller
public class UserViewController {


	@Autowired
	private ApplicationService appService;

	@GetMapping("/")
	public String rootView (ModelMap model, @Param("keyword") String keyword, @Param("sortBy") String sortBy, 
			@Param("filterBy") String category) {
		List<Application> applications = new ArrayList<>(); 
		List<String> categories = appService.findDistinctCategory(); 
		model.put("categories", categories); 
		if(keyword != null) {
			applications = appService.findByKeyword(keyword); 
			model.addAttribute("applications", applications);
			model.addAttribute("keyword", keyword);
		} else if(sortBy != null) {
			if(sortBy.equals("name")) {
				applications = appService.findByOrderByNameAsc();
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			} 
			if(sortBy.equals("price")) {
				applications = appService.findByOrderByPriceDesc();
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			}
			if(sortBy.equals("")) {
				applications = appService.findByApproved(true);
				model.addAttribute("applications", applications);
			}
		} else if(category != null) {
			applications = appService.findByCategory(category); 
			model.addAttribute("applications", applications);
		}		
		else {
			applications = appService.findByApproved(true);
			model.put("applications", applications);
		}

		return "index"; 
	}

	@GetMapping("/c/{category}")
	public String filterdBy(ModelMap model, @PathVariable String category) {
		List<Application> applications = appService.findByCategory(category); 
		List<String> categories = appService.findDistinctCategory(); 
		model.put("categories", categories); 
		model.put("applications", applications);
		return "index"; 
	}

	@GetMapping("/dashboard")
	public String dashboard(ModelMap model) {
		List<Application> applications = appService.findAll(); 
		model.put("applications", applications);

		return "dashboard"; 
	}
}
