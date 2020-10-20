package com.weapp.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	  return "applications"; 
  }
  
  @GetMapping("/applications/{applicationId}")
  public String getApplication(@PathVariable int applicationId, ModelMap model, HttpServletResponse response) throws IOException {
	model.put("application", new Application());
	Optional<Application> appOpt = appRepo.findById(applicationId);
    
    if (appOpt.isPresent()) {
      Application application = appOpt.get();
      model.put("application", application);
    } else {
      response.sendError(HttpStatus.NOT_FOUND.value(), "Application with id " + applicationId + " was not found");
      return "application";
    }   
    return "application";
  }
  
  @PostMapping("/applications/{applicationId}")
  public String saveApplication(@PathVariable int applicationId, Application application) {
    application = appRepo.save(application);
    
    return "redirect:/applications/" + application.getId();
  }

  
  @PostMapping("/applications")
  public String createApplication(@AuthenticationPrincipal User user) {
	System.out.println(user.getId());
	Application application = new Application();
    
	application.setApproved(false);
	application.setUser(user);

	application = appRepo.save(application);
    
    return "redirect:/applications/" + application.getId();
  }
}