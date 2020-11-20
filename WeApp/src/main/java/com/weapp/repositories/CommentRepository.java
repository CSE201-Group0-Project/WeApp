/*
 * Thanks to spring.io documentation on Query Creation
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 * 
 * Thanks to Baeldung for the guide on use of @Repository
 * https://www.baeldung.com/spring-component-repository-service
 */
package com.weapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weapp.domain.Comment;


/**
 * This is the repository class for Comment objects
 * All method names are compliant with Spring Data naming conventions
 * so that this class can extends Spring Data JPA 
 * See: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 * for more details
 * 
 * @Repository tell Spring that this is the repository - persistence layer (database repository) 
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	/**
	 * Retrieve comments store by application id.
	 *
	 * @param applicationId the application id to search for 
	 * @return the list of comments if found 
	 */
	List<Comment> findByApplicationId(int applicationId); 
	
	/**
	 * Retrieve comments store by user id.
	 *
	 * @param userId the user id to search for 
	 * @return the list of comments if found 
	 */
	List<Comment> findByUserId(int userId); 
	
	/**
	 * Find by order by created date desc.
	 *
	 * @return the list of comments if found 
	 */
	List<Comment> findByOrderByCreatedDateDesc(); 
	
	/**
	 * Find by order by created date asc.
	 *
	 * @return the list of comments if found 
	 */
	List<Comment> findByOrderByCreatedDateAsc(); 
	
	/**
	 * Find all.
	 *
	 * @return the list of comments if found 
	 */
	List<Comment> findAll(); 
	
}
