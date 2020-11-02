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

@Controller
public class DashboardController {


	@Autowired
	private ApplicationRepository appRepo;

	@GetMapping("/")
	public String rootView (ModelMap model, @Param("keyword") String keyword, @Param("sortBy") String sortBy) {
		List<Application> applications = new ArrayList<>(); 
		if(keyword != null) {
			applications = appRepo.findByNameIgnoreCase(keyword); 
			model.addAttribute("applications", applications);
			model.addAttribute("keyword", keyword);
		} else {
			applications = appRepo.findAll(); 
			model.put("applications", applications);
		}

		if(sortBy != null) {
			if(sortBy.equals("name")) {
				applications = appRepo.findByOrderByNameAsc();
				model.addAttribute("applications", applications);
				model.addAttribute("sortBy", sortBy);
			} else {
				applications = appRepo.findAll(); 
				model.put("applications", applications);
			}
		}

		return "index"; 
	}

	@GetMapping("/dashboard")
	public String dashboard(ModelMap model) {
		List<Application> applications = appRepo.findAll(); 
		model.put("applications", applications);

		return "dashboard"; 
	}
}
