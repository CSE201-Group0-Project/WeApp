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
import com.weapp.service.ApplicationService;

@Controller
public class ApplicationAdminController {
	  
  @Autowired
  private ApplicationService appService;
  
  @GetMapping("/applications") 
  public String getApplications(ModelMap model) {
	  List<Application> applications = appService.findAll(); 
	  model.put("applications", applications);
	  return "index"; 
  }
  
  @GetMapping("/applications/{applicationId}")
  public String getApplication(@PathVariable int applicationId, ModelMap model, HttpServletResponse response) throws IOException {
	Optional<Application> appOpt = appService.findById(applicationId);
    
    if (appOpt.isPresent()) {
      Application application = appOpt.get();
      model.addAttribute("application", application);
    } else {
      response.sendError(HttpStatus.NOT_FOUND.value(), "Application with id " + applicationId + " was not found");
      return "application";
    }   
    return "application";
  }
  
  @PostMapping("/applications/{applicationId}")
  public String saveApplication(@PathVariable int applicationId, Application application) {
    application = appService.save(application);
    
    return "redirect:/applications/" + application.getId();
  }

  
  @PostMapping("/applications")
  public String createApplication(@AuthenticationPrincipal User user) {
	System.out.println(user.getId());
	Application application = new Application();
    
	application.setApproved(false);
	application.setUser(user);

	application = appService.save(application);
    
    return "redirect:/applications/" + application.getId();
  }
}