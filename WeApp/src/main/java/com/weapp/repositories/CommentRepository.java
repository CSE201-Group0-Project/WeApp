package com.weapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weapp.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByApplicationId(int applicationId); 
	
}
