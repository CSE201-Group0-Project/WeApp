package com.weapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weapp.domain.Comment;
import com.weapp.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepo; 
	
	public List<Comment> findByApplicationId(int applicationId) {
		return commentRepo.findByApplicationId(applicationId);
	}
	
	public Comment save(Comment comment) {
		return commentRepo.save(comment); 
	}
	
	public Optional<Comment> findById(int id) {
		return commentRepo.findById(id);
	}
	
	public void deleteComment(int id) {
		commentRepo.deleteById(id);
	}
	
	public List<Comment> findByUserId(int userId) {
		return commentRepo.findByUserId(userId);
	}
	
	public List<Comment> findByOrderByCreatedDateAsc() {
		return commentRepo.findByOrderByCreatedDateAsc();
	}
	
	public List<Comment> findByOrderByCreatedDateDesc() {
		return commentRepo.findByOrderByCreatedDateDesc();
	}

}
