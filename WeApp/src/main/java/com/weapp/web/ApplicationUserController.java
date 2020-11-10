package com.weapp.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.SortedSet;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weapp.domain.Application;
import com.weapp.domain.Comment;
import com.weapp.service.ApplicationService;

@Controller
public class ApplicationUserController {

	Logger log = LoggerFactory.getLogger(ApplicationUserController.class); 

	@Autowired
	private ApplicationService appService; 

	@GetMapping("/app/{applicationId}")
	public String appInfoView(@PathVariable int applicationId, ModelMap model, HttpServletResponse response) throws IOException {
		Optional<Application> appOpt = appService.findById(applicationId);

		if (appOpt.isPresent()) {
			Application application = appOpt.get();
			model.put("app", application);
			SortedSet<Comment> commentsWithoutDuplicates = getCommentsWithoutDuplicates(0, new HashSet<Integer>(), application.getComments());
			model.put("thread", commentsWithoutDuplicates);
			model.put("rootComment", new Comment());

		} else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Application with id " + applicationId + " was not found");
			return "appInfo";
		}   
		return "appInfo";
	}

	private SortedSet<Comment> getCommentsWithoutDuplicates(int page, HashSet<Integer> visitedComments,
			SortedSet<Comment> comments) {
		page++;
	    Iterator<Comment> itr = comments.iterator();
	    while (itr.hasNext()) {
	      Comment comment = itr.next();
	      boolean addedToVisitedComments = visitedComments.add(comment.getId());
	      if (!addedToVisitedComments) {
	        itr.remove();
	        if (page != 1)
	          return comments;
	      }
	      if (addedToVisitedComments && !comment.getComments().isEmpty())
	        getCommentsWithoutDuplicates(page, visitedComments, comment.getComments());
	    }
	    
	    return comments;
	}

}
