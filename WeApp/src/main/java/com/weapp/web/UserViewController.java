package com.weapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.weapp.domain.Application;
import com.weapp.repositories.ApplicationRepository;
import com.weapp.service.ApplicationService;

@Controller
public class UserViewController {


	@Autowired
	private ApplicationService appService;

	@GetMapping("/")
	public String rootView (ModelMap model, @Param("keyword") String keyword, @Param("sortBy") String sortBy) {
		List<Application> applications = new ArrayList<>(); 
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
			if(sortBy.equals("")) {
				applications = appService.findByApproved(true);
				model.addAttribute("applications", applications);
			}
		} else {
			applications = appService.findByApproved(true);
			model.put("applications", applications);
		}

		return "index"; 
	}

	@GetMapping("/dashboard")
	public String dashboard(ModelMap model) {
		List<Application> applications = appService.findAll(); 
		model.put("applications", applications);

		return "dashboard"; 
	}
}
