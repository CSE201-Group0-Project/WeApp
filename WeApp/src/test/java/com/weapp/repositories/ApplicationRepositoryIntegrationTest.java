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
import com.weapp.domain.User;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationRepositoryIntegrationTest.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ApplicationRepositoryIntegrationTest {

	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/** The application repository. */
	@Autowired
	private ApplicationRepository applicationRepository;

	/**
	 * When find by name then return applications.
	 */
	@Test
	void whenFindByName_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		dummy1.setName("Cook");
		dummy1.setApproved(true);
		Application dummy2 = new Application();
		dummy2.setName("cook");
		dummy2.setApproved(true);
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.flush();

		List<Application> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);

		// when
		List<Application> results = applicationRepository.findByNameIgnoreCase(dummy1.getName());


		// then
		assertThat(results).isEqualTo(expRet);
	}

	/**
	 * When find by organization then return applications.
	 */
	@Test
	void whenFindByOrganization_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		dummy1.setOrganization("No name");
		Application dummy2 = new Application();
		dummy2.setOrganization("No name");
		dummy1.setApproved(true);
		dummy2.setApproved(true);
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

	/**
	 * When find by version then return applications.
	 */
	@Test
	void whenFindByVersion_thenReturnApplications() {
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

	/**
	 * When find by approved then return applications.
	 */
	@Test
	void whenFindByApproved_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		Application dummy2 = new Application();
		List<Application> expRet = applicationRepository.findByApproved(true);  
		expRet.add(dummy1);
		expRet.add(dummy2);
		dummy1.setApproved(true);
		dummy2.setApproved(true);
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.flush();


		// when
		List<Application> results = applicationRepository.findByApproved(dummy1.getApproved());


		// then
		assertThat(results).isEqualTo(expRet);
	}

	/**
	 * When find by category then return applications.
	 */
	@Test
	void whenFindByCategory_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		dummy1.setCategory("dummy");
		Application dummy2 = new Application();
		dummy2.setCategory("dummy");
		dummy1.setApproved(true);
		dummy2.setApproved(true);
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.flush();

		List<Application> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);

		// when
		List<Application> results = applicationRepository.findByCategory(dummy1.getCategory());


		// then
		assertThat(results).isEqualTo(expRet);
	}

	/**
	 * When find by platform then return applications.
	 */
	@Test
	void whenFindByPlatform_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		dummy1.setPlatform("dummy");
		Application dummy2 = new Application();
		dummy2.setPlatform("dummy");
		dummy1.setApproved(true);
		dummy2.setApproved(true);
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.flush();

		List<Application> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);

		// when
		List<Application> results = applicationRepository.findByPlatform(dummy1.getPlatform());


		// then
		assertThat(results).isEqualTo(expRet);
	}

	/**
	 * When find by user then return applications.
	 */
	@Test
	void whenFindByUser_thenReturnApplications() {
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

	/**
	 * When find by keyword then return applications.
	 */
	@Test
	void whenFindByKeyword_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		dummy1.setPlatform("dummy");
		Application dummy2 = new Application();
		dummy2.setName("dummy");
		Application dummy3 = new Application();
		dummy3.setCategory("dummy");
		Application dummy4 = new Application();
		dummy4.setDescription("dummy is dumb");
		Application dummy5 = new Application();
		dummy5.setOrganization("dummy");
		dummy1.setApproved(true);
		dummy2.setApproved(true);
		dummy3.setApproved(true);
		dummy4.setApproved(true);
		dummy5.setApproved(true);
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.persist(dummy3);
		entityManager.persist(dummy4);
		entityManager.persist(dummy5);
		entityManager.flush();

		List<Application> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);
		expRet.add(dummy3);
		expRet.add(dummy4);
		expRet.add(dummy5);

		// when
		List<Application> results = applicationRepository.findByKeyword("dummy"); 

		// then
		assertThat(results).isEqualTo(expRet);
	}

	/**
	 * When find by keyword for admin then return applications.
	 */
	@Test
	void whenFindByKeywordForAdmin_thenReturnApplications() {
		// given
		Application dummy1 = new Application();
		dummy1.setPlatform("dummy");
		Application dummy2 = new Application();
		dummy2.setName("dummy");
		Application dummy3 = new Application();
		dummy3.setCategory("dummy");
		Application dummy4 = new Application();
		dummy4.setDescription("dummy is dumb");
		Application dummy5 = new Application();
		dummy5.setOrganization("dummy");
		entityManager.persist(dummy1);
		entityManager.persist(dummy2);
		entityManager.persist(dummy3);
		entityManager.persist(dummy4);
		entityManager.persist(dummy5);
		entityManager.flush();

		List<Application> expRet = new ArrayList<>(); 
		expRet.add(dummy1);
		expRet.add(dummy2);
		expRet.add(dummy3);
		expRet.add(dummy4);
		expRet.add(dummy5);

		// when
		List<Application> results = applicationRepository.findByKeywordForAdmin("dummy"); 

		// then
		assertThat(results).isEqualTo(expRet);
	}

	/**
	 * When find by order by price desc then return applications.
	 */
	@Test
	void whenFindByOrderByPriceDesc_thenReturnApplications() {
		List<Application> unsortedList = applicationRepository.findByApproved(true); 
		
		Collections.sort(unsortedList,new Comparator<Application>() {
		    @Override
		    public int compare(Application a, Application b) {
		        return  Double.compare(b.getPrice(), a.getPrice());
		    }
		});
		
		// when
		List<Application> results = applicationRepository.findByOrderByPriceDesc(); 
		
		// then
		assertThat(results).isEqualTo(unsortedList);
	}
	
	/**
	 * When find by order by name asc then return applications.
	 */
	@Test
	void whenFindByOrderByNameAsc_thenReturnApplications() {
		List<Application> unsortedList = applicationRepository.findByApproved(true); 
		
		Collections.sort(unsortedList,new Comparator<Application>() {
		    @Override
		    public int compare(Application a, Application b) {
		        return  a.getName().compareTo(b.getName());
		    }
		});
		
		// when
		List<Application> results = applicationRepository.findByOrderByNameAsc();
		
		// then
		assertThat(results).isEqualTo(unsortedList);
	}
}
