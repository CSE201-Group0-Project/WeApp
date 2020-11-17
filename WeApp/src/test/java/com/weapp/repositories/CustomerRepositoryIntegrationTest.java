package com.weapp.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.weapp.domain.Application;
import com.weapp.domain.Comment;
import com.weapp.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CommentRepository commentRepo;
	
	@Test
	public void whenFindByUserId_thenReturnComments() {
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
	
	@Test
	public void whenFindByApplicationId_thenReturnComments() {
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
	
	@Test
	public void whenFindByOrderByCreatedDateDesc_thenReturnComments() {
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
	
	@Test
	public void whenFindByOrderByCreatedDateAsc_thenReturnComments() {
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
