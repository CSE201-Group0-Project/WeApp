/*
 * 
 */
package com.weapp.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.weapp.domain.Application;
import com.weapp.domain.Comment;
import com.weapp.domain.User;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentRepositoryIntegrationTest.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CommentRepositoryIntegrationTest {
	
	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/** The comment repo. */
	@Autowired
	private CommentRepository commentRepo;
	
	/**
	 * When find by user id then return comments.
	 */
	@Test
	void whenFindByUserId_thenReturnComments() {
		Comment dummy1 = new Comment(); 
		Comment dummy2 = new Comment(); 
		User dummyUser = new User(); 
		dummy1.setUser(dummyUser);
		dummy2.setUser(dummyUser);
		
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.persist(dummyUser);
		entityManager.flush();
		
		List<Comment> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);

		// when
		List<Comment> results = commentRepo.findByUserId(dummyUser.getId());


		// then
		assertThat(results).isEqualTo(expRet);
	}
	
	/**
	 * When find by application id then return comments.
	 */
	@Test
	void whenFindByApplicationId_thenReturnComments() {
		Comment dummy1 = new Comment(); 
		Comment dummy2 = new Comment(); 
		Application dummyApp = new Application(); 
		dummy1.setApplication(dummyApp);
		dummy2.setApplication(dummyApp);
		
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.persist(dummyApp);
		entityManager.flush();
		
		List<Comment> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);

		// when
		List<Comment> results = commentRepo.findByApplicationId(dummyApp.getId());


		// then
		assertThat(results).isEqualTo(expRet);
	}
	
	/**
	 * When find by order by created date desc then return comments.
	 */
	@Test
	void whenFindByOrderByCreatedDateDesc_thenReturnComments() {
		List<Comment> unsortedList = commentRepo.findAll();
		
		Collections.sort(unsortedList,new Comparator<Comment>() {
		    @Override
		    public int compare(Comment a, Comment b) {
		        return  b.getCreatedDate().compareTo(a.getCreatedDate());
		    }
		});
		
		// when
		List<Comment> results = commentRepo.findByOrderByCreatedDateDesc();
		
		// then
		assertThat(results).isEqualTo(unsortedList);

	}
	
	/**
	 * When find by order by created date asc then return comments.
	 */
	@Test
	void whenFindByOrderByCreatedDateAsc_thenReturnComments() {
		List<Comment> unsortedList = commentRepo.findAll();
		
		Collections.sort(unsortedList,new Comparator<Comment>() {
		    @Override
		    public int compare(Comment a, Comment b) {
		        return  a.getCreatedDate().compareTo(b.getCreatedDate());
		    }
		});
		
		// when
		List<Comment> results = commentRepo.findByOrderByCreatedDateAsc();
		
		// then
		assertThat(results).isEqualTo(unsortedList);

	}
	
}
