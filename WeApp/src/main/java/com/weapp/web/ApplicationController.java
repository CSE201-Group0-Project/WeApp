package com.weapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.weapp.domain.Application;
import com.weapp.domain.User;
import com.weapp.repositories.ApplicationRepository;

@Controller
public class ApplicationController {
	
	@Autowired
	private ApplicationRepository appRepo; 
	
	@GetMapping("/applications")
	public String getApplications(ModelMap model) {
		return "application"; 
	}
	
	@GetMapping("/applications/{applicationId}")
	public String getApplication(@PathVariable int applicationId) {
		return "application"; 
	}
	
	@PostMapping("/applications")
	public String createApplication(@AuthenticationPrincipal User user) {
		Application application = new Application(); 
		
		application.setApproved(false);
		application.setUser(user);
		
		application = appRepo.save(application);
		
		return "redirect:/applications/" + application.getId(); 
	}
}
