package com.weapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weapp.domain.Comment;
import com.weapp.repositories.CommentRepository;

/**
 * The Class CommentService.
 */
@Service
public class CommentService {
	
	/** The comment repo. */
	@Autowired
	private CommentRepository commentRepo; 
	
	/**
	 * Find by application id.
	 *
	 * @param applicationId the application id
	 * @return the list
	 */
	public List<Comment> findByApplicationId(int applicationId) {
		return commentRepo.findByApplicationId(applicationId);
	}
	
	/**
	 * Save.
	 *
	 * @param comment the comment
	 * @return the comment
	 */
	public Comment save(Comment comment) {
		return commentRepo.save(comment); 
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Comment> findById(int id) {
		return commentRepo.findById(id);
	}
	
	/**
	 * Delete comment.
	 *
	 * @param id the id
	 */
	public void deleteComment(int id) {
		commentRepo.deleteById(id);
	}
	
	/**
	 * Find by user id.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	public List<Comment> findByUserId(int userId) {
		return commentRepo.findByUserId(userId);
	}
	
	/**
	 * Find by order by created date asc.
	 *
	 * @return the list
	 */
	public List<Comment> findByOrderByCreatedDateAsc() {
		return commentRepo.findByOrderByCreatedDateAsc();
	}
	
	/**
	 * Find by order by created date desc.
	 *
	 * @return the list
	 */
	public List<Comment> findByOrderByCreatedDateDesc() {
		return commentRepo.findByOrderByCreatedDateDesc();
	}

}
