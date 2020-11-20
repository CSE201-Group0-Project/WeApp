/*
 * Thanks to Trevor Page for this recursive comment functionality getCommentsWithoutDuplicates
 * The entirety of the getCommentsWithoutDuplicates is implemented with slight modifications 
 * https://github.com/tp02ga/FreshVotes/blob/master/FreshVotes/src/main/java/com/freshvotes/web/FeatureController.java
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

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationUserController.
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
	 * @param applicationId the application id
	 * @param model the model
	 * @param response the response
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
