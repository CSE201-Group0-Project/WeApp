package com.weapp.web;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weapp.domain.Application;
import com.weapp.repositories.ApplicationRepository;

@Controller
public class ApplicationUserController {

	@Autowired
	private ApplicationRepository appRepo;

	@GetMapping("/app/{applicationId}")
	public String appInfoView(@PathVariable int applicationId, ModelMap model, HttpServletResponse response) throws IOException {
		Optional<Application> appOpt = appRepo.findById(applicationId);

		if (appOpt.isPresent()) {
			Application application = appOpt.get();
			model.put("app", application);
		} else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Application with id " + applicationId + " was not found");
			return "appInfo";
		}   
		return "appInfo";
	}

}
