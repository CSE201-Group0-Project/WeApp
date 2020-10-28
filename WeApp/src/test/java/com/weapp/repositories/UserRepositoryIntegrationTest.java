package com.weapp.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.jupiter.api.Test;
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
class UserRepositoryIntegrationTest {
	
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
        User amy = new User();
        amy.setName("amy");
        entityManager.persist(amy);
        entityManager.flush();
     
        // when
        User found = userRepository.findByName(amy.getName());
     
        // then
        assertThat(found.getName())
          .isEqualTo(amy.getName());
    }
}
