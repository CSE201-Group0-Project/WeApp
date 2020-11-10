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

@Controller
@RequestMapping("/app/{applicationId}/comments")
public class CommentController {

	@Autowired 
	public CommentRepository commentRepo; 

	@Autowired
	public ApplicationRepository appRepo; 

	@GetMapping("")
	@ResponseBody
	public List<Comment> getComments (@PathVariable Integer applicationId) {

		List<Comment> findByApplicationId = commentRepo.findByApplicationId(applicationId);
		System.out.println(findByApplicationId);
		return findByApplicationId;
	}

	@PostMapping("")
	public String postComment(@AuthenticationPrincipal User user, @PathVariable Integer applicationId
			,Comment rootComment, @RequestParam(required=false) Integer parentId,
			@RequestParam(required=false) String childCommentText) {
		Optional<Application> appOpt = appRepo.findById(applicationId);
		// save a root level comment here
		if (!StringUtils.isEmpty(rootComment.getContent())) {
			populateCommentData(user, appOpt, rootComment);
			commentRepo.save(rootComment);
		}
		// save a child level comment here 
		else if (parentId != null) {
			Comment comment = new Comment();
			Optional<Comment> parentCommentOpt = commentRepo.findById(parentId);
			if (parentCommentOpt.isPresent())
				comment.setComment(parentCommentOpt.get());
			comment.setContent(childCommentText);
			populateCommentData(user, appOpt, comment);
			commentRepo.save(comment);
		} 

		return "redirect:/app/" + applicationId; 
	}

	private void populateCommentData(User user, Optional<Application> appOpt, Comment comment) {
		if(appOpt.isPresent()) {
			comment.setApplication(appOpt.get());
			comment.setUser(user);
			comment.setCreatedDate(new Date());
		}

	}
}

