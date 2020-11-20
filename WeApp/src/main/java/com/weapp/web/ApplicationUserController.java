/*
 * Thanks to Trevor Page for this recursive comment functionality getCommentsWithoutDuplicates
 * The entirety of the getCommentsWithoutDuplicates is implemented with slight modifications 
 * https://github.com/tp02ga/FreshVotes/blob/master/FreshVotes/src/main/java/com/freshvotes/web/FeatureController.java
 * 
 * Thanks to spring.io's Building an Application with Spring Boot guide for the introduction of @Controller
 * https://spring.io/guides/gs/spring-boot/
 * 
 * Thanks to Baeldung for the introduction of Spring MVC
 * https://www.baeldung.com/spring-mvc-model-model-map-model-view
 */
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

/**
 * The Class ApplicationUserController.
 * @Controller tells Spring Model View Controller architecture that this class is used for web requests
 */
@Controller
public class ApplicationUserController {

	/** The log. */
	Logger log = LoggerFactory.getLogger(ApplicationUserController.class); 

	/** The app service. */
	@Autowired
	private ApplicationService appService; 

	/**
	 * App info view.
	 * 
	 * See documentation on HttpServletResponse
	 * https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletResponse.html
	 *
	 * @param applicationId the application id path variable 
	 * @param model ModelMap is used to pass attributes to render a view.
	 * @param response the HttpServletResponse
	 * @return appInfo view 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/app/{applicationId}")
	public String appInfoView(@PathVariable int applicationId, ModelMap model, HttpServletResponse response) throws IOException {
		Optional<Application> appOpt = appService.findById(applicationId);

		if (appOpt.isPresent()) {
			Application application = appOpt.get();
			// Pass application as an attribute to render application on appInfo view 
			model.put("app", application);
			SortedSet<Comment> commentsWithoutDuplicates = getCommentsWithoutDuplicates(0, new HashSet<Integer>(), application.getComments());
			// Pass thread as an attribute to render commentsWithoutDuplicates on appInfo view 
			model.put("thread", commentsWithoutDuplicates);
			// Pass comment as an attribute to render a new comment on appInfo view 
			model.put("rootComment", new Comment());

		} else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Application with id " + applicationId + " was not found");
			return "appInfo";
		}   
		return "appInfo";
	}

	/**
	 * Gets the comments without duplicates.
	 * 
	 *
	 * Thanks to Trevor Page for this recursive comment functionality getCommentsWithoutDuplicates
	 * The entirety of the getCommentsWithoutDuplicates is implemented with slight modifications 
	 * https://github.com/tp02ga/FreshVotes/blob/master/FreshVotes/src/main/java/com/freshvotes/web/FeatureController.java
	 *
	 * @param page the page
	 * @param visitedComments the visited comments
	 * @param comments the comments
	 * @return the comments without duplicates
	 */
	private SortedSet<Comment> getCommentsWithoutDuplicates(int depth, HashSet<Integer> visitedComments,
			SortedSet<Comment> comments) {
		depth++;
		// To modify a collection while iterating through it
		// we need an iterator
	    Iterator<Comment> itr = comments.iterator();
	    while (itr.hasNext()) {
	      Comment comment = itr.next();
	      // If successfully add the comment id to visited comments 
	      // return true 
	      // if false, that comment already exist in the visited comments
	      boolean addedToVisitedComments = visitedComments.add(comment.getId());
	      if (!addedToVisitedComments) {
	    	// if this comment is not added to visited comments 
	    	// remove the comment to avoid duplicates in the set of comments
	        itr.remove();
	        if (depth != 1)
	          return comments;
	      }
	      // Recursive call where we passed in the page, visited comments, nested comments of this current comment 
	      if (addedToVisitedComments && !comment.getComments().isEmpty())
	        getCommentsWithoutDuplicates(depth, visitedComments, comment.getComments());
	    }
	    
	    return comments;
	}

}
