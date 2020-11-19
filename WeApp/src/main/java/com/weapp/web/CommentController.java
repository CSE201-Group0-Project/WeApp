/*
 * 
 */
package com.weapp.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weapp.domain.Application;
import com.weapp.domain.Comment;
import com.weapp.domain.User;
import com.weapp.repositories.ApplicationRepository;
import com.weapp.repositories.CommentRepository;
import com.weapp.service.ApplicationService;
import com.weapp.service.CommentService;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentController.
 */
@Controller
@RequestMapping("/app/{applicationId}/comments")
public class CommentController {

	/** The comment service. */
	@Autowired 
	public CommentService commentService; 

	/** The app service. */
	@Autowired
	public ApplicationService appService; 

	/**
	 * Gets the comments.
	 *
	 * @param applicationId the application id
	 * @return the comments
	 */
	@GetMapping("")
	@ResponseBody
	public List<Comment> getComments (@PathVariable Integer applicationId) {

		List<Comment> findByApplicationId = commentService.findByApplicationId(applicationId);
		System.out.println(findByApplicationId);
		return findByApplicationId;
	}
	
	/**
	 * Delete comment.
	 *
	 * @param applicationId the application id
	 * @param commentId the comment id
	 * @param comment the comment
	 * @return the string
	 */
	@GetMapping("/{commentId}/delete")
	public String deleteComment(@PathVariable int applicationId, @PathVariable int commentId, Comment comment) {
		commentService.findById(commentId)
		.orElseThrow(() -> new IllegalArgumentException("Invalid comment id:" + commentId));
		commentService.deleteComment(commentId);
		return "redirect:/app/" + applicationId; 
	}
	
	/**
	 * Post comment.
	 *
	 * @param user the user
	 * @param applicationId the application id
	 * @param rootComment the root comment
	 * @param parentId the parent id
	 * @param childCommentText the child comment text
	 * @return the string
	 */
	@PostMapping("")
	public String postComment(@AuthenticationPrincipal User user, @PathVariable Integer applicationId
			,Comment rootComment, @RequestParam(required=false) Integer parentId,
			@RequestParam(required=false) String childCommentText) {
		Optional<Application> appOpt = appService.findById(applicationId);
		// save a root level comment here
		if (!StringUtils.isEmpty(rootComment.getContent())) {
			populateCommentData(user, appOpt, rootComment);
			commentService.save(rootComment);
		}
		// save a child level comment here 
		else if (parentId != null) {
			Comment comment = new Comment();
			Optional<Comment> parentCommentOpt = commentService.findById(parentId);
			if (parentCommentOpt.isPresent())
				comment.setComment(parentCommentOpt.get());
			comment.setContent(childCommentText);
			populateCommentData(user, appOpt, comment);
			commentService.save(comment);
		} 

		return "redirect:/app/" + applicationId; 
	}

	/**
	 * Populate comment data.
	 *
	 * @param user the user
	 * @param appOpt the app opt
	 * @param comment the comment
	 */
	private void populateCommentData(User user, Optional<Application> appOpt, Comment comment) {
		if(appOpt.isPresent()) {
			comment.setApplication(appOpt.get());
			comment.setUser(user);
			comment.setCreatedDate(new Date());
		}

	}
}

