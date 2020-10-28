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

import com.weapp.domain.Application;
import com.weapp.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ApplicationRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Test
    public void whenFindByName_thenReturnApplications() {
        // given
        Application dummy1 = new Application();
        dummy1.setName("Cook");
        Application dummy2 = new Application();
        dummy2.setName("Cook");
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByName(dummy1.getName());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }
    
    @Test
    public void whenFindByOrganization_thenReturnApplications() {
        // given
        Application dummy1 = new Application();
        dummy1.setOrganization("No name");
        Application dummy2 = new Application();
        dummy2.setOrganization("No name");
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByOrganization(dummy1.getOrganization());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }
    
    @Test
    public void whenFindByVersion_thenReturnApplications() {
        // given
        Application dummy1 = new Application();
        dummy1.setVersion("v1");
        Application dummy2 = new Application();
        dummy2.setVersion("v1");
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByVersion(dummy1.getVersion());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }
    
    @Test
    public void whenFindByApproved_thenReturnApplications() {
        // given
        Application dummy1 = new Application();
        dummy1.setApproved(true);
        Application dummy2 = new Application();
        dummy2.setApproved(true);
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByApproved(dummy1.getApproved());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }

    @Test
    public void whenFindByUser_thenReturnApplications() {
        // given
        User user1 = new User(); 
        Application dummy1 = new Application();
        dummy1.setUser(user1);
        Application dummy2 = new Application();
        dummy2.setUser(user1);
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.persist(user1);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByUser(dummy1.getUser());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }
}
