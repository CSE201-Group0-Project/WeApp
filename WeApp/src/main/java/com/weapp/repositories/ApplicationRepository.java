/*
 * 
 */
package com.weapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weapp.domain.Application;
import com.weapp.domain.User;

// TODO: Auto-generated Javadoc
/**
 * This is the repository class for Application objects
 * All method names are compliant with Spring Data naming conventions
 * so that this class can extends Spring Data JPA 
 * See: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 * for more details
 */
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	/**
	 * Find an application by id.
	 *
	 * @param id the id to search for
	 * @return the optional
	 */
	Optional<Application> findById(int id); 
	
	// select * from application where name = :name
	
	/**
	 * Find approved applications by name ignore case.
	 *
	 * @param name the name to search for 
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE lower(a.name) = lower(:name)"
			+ " and a.approved = true")
	List<Application> findByNameIgnoreCase(String name); 
	
	/**
	 * Find applications by organization.
	 *
	 * @param organization the organization to search for 
	 * @return the list of applications if found
	 */
	// select * from application where organization = :organization
	List<Application> findByOrganization(String organization); 
	
	/**
	 * Find by user.
	 *
	 * @param user the user to search for 
	 * @return the list of applications if found
	 */
	List<Application> findByUser(User user);
	
	/**
	 * Find by version.
	 *
	 * @param version the version to search for 
	 * @return the list of applications if found
	 */
	List<Application> findByVersion(String version);
	
	/**
	 * Find by approved.
	 *
	 * @param approved the approved to search for 
	 * @return the list of applications if found
	 */
	List<Application> findByApproved(Boolean approved);
	
	/**
	 * Find approved applications by category.
	 *
	 * @param category the category to search for 
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE lower(a.category) = lower(:category)"
			+ " and a.approved = true")
	List<Application> findByCategory(String category);

	/**
	 * Find approved applications by platform.
	 *
	 * @param platform the platform to search for 
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE lower(a.platform) = lower(:platform)"
			+ " and a.approved = true")
	List<Application> findByPlatform(String platform);
	
	/**
	 * Find all.
	 *
	 * @return the list of applications if found
	 */
	List<Application> findAll(); 
	
	/**
	 * Find approved applications by order by name asc.
	 *
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE a.approved = true ORDER BY name ASC")
	List<Application> findByOrderByNameAsc(); 
	
	/**
	 * Find approved applications by order by price desc.
	 *
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE a.approved = true ORDER BY price DESC")
	List<Application> findByOrderByPriceDesc(); 
	
	/**
	 * Find approved applications functionality by keyword.
	 *
	 * @param keyword the keyword to search for
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE lower(a.name) = lower(:keyword)"
			+ " or lower(a.category) = lower(:keyword)"
			+ " or lower(a.platform) = lower(:keyword)"
			+ " or lower(a.organization) like lower(concat('%',:keyword,'%'))"
			+ " or lower(a.description) like lower(concat('%',:keyword,'%'))"
			+ " and a.approved = true")
	List<Application> findByKeyword(@Param("keyword") String keyword); 
	
	/**
	 * Find applications by keyword functionality for admin.
	 *
	 * @param keyword the keyword to search for 
	 * @return the list of applications if found
	 */
	@Query("SELECT a FROM Application a WHERE lower(a.name) = lower(:keyword)"
			+ " or lower(a.category) = lower(:keyword)"
			+ " or lower(a.platform) = lower(:keyword)"
			+ " or lower(a.organization) like lower(concat('%',:keyword,'%'))"
			+ " or lower(a.description) like lower(concat('%',:keyword,'%'))")
	List<Application> findByKeywordForAdmin(@Param("keyword") String keyword); 
	
	/**
	 * Find approved applications by distinct category.
	 *
	 * @return the list of applications if found
	 */
	@Query("SELECT DISTINCT a.category FROM Application a WHERE a.approved = true")
    List<String> findDistinctCategory();
	
	/**
	 * Find approved applications by distinct platform.
	 *
	 * @return the list of applications if found
	 */
	@Query("SELECT DISTINCT a.platform FROM Application a WHERE a.approved = true")
    List<String> findDistinctPlatform();
	
}
