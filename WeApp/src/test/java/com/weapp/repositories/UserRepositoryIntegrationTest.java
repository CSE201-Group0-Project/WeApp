package com.weapp.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.weapp.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;
	
    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        User amy = new User();
        amy.setUsername("amynguyen.tech@jojo.com");
        entityManager.persist(amy);
        entityManager.flush();
     
        // when
        User found = userRepository.findByUsername(amy.getUsername());
     
        // then
        assertThat(found.getUsername())
          .isEqualTo(amy.getUsername());
    }
    
    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        User mockUser1 = new User();
        mockUser1.setName("amy");
        User mockUser2 = new User();
        mockUser2.setName("amy");
        entityManager.persist(mockUser1);
        entityManager.persist(mockUser2);
        entityManager.flush();
        
        List<User> expRet = new ArrayList<>(); 
        expRet.add(mockUser1);
        expRet.add(mockUser2);
     
        // when
        List<User> results = userRepository.findByName(mockUser1.getName());
     
        // then
        assertThat(results).isEqualTo(expRet);

    }
    
    @Test 
    public void whenSuccessFullySaveUser() {
    	 // given
        User mockUser1 = new User();
        mockUser1.setName("amy");
        mockUser1.setUsername("amy@jojo.com");
        entityManager.persist(mockUser1);
        entityManager.flush();
        
        // when
        User user = userRepository.save(mockUser1);
        
        //then 
        assertThat(user).isNotNull();
    } 
   
}
