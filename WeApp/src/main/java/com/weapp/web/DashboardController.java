package com.weapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String rootView (ModelMap model) {
		List<Application> applications = appRepo.findAll(); 
		model.put("applications", applications);
		  
		return "index"; 
	}
	
	@GetMapping("/dashboard")
	public String dashboard(ModelMap model) {
		List<Application> applications = appRepo.findAll(); 
		model.put("applications", applications);
		
		return "dashboard"; 
	}
 }
