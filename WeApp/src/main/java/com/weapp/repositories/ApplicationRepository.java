package com.weapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weapp.domain.Application;
import com.weapp.domain.User;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	Optional<Application> findById(int id); 
	
	// select * from application where name = :name
	
	@Query("SELECT a FROM Application a WHERE lower(a.name) = lower(:name)"
			+ " and a.approved = true")
	List<Application> findByNameIgnoreCase(String name); 
	
	// select * from application where organization = :organization
	List<Application> findByOrganization(String organization); 
	
	List<Application> findByUser(User user);
	
	List<Application> findByVersion(String version);
	
	List<Application> findByApproved(Boolean approved);
	
	@Query("SELECT a FROM Application a WHERE lower(a.category) = lower(:category)"
			+ " and a.approved = true")
	List<Application> findByCategory(String category);

	@Query("SELECT a FROM Application a WHERE lower(a.platform) = lower(:platform)"
			+ " and a.approved = true")
	List<Application> findByPlatform(String platform);
	
	List<Application> findAll(); 
	
	@Query("SELECT a FROM Application a WHERE a.approved = true ORDER BY name ASC")
	List<Application> findByOrderByNameAsc(); 
	
	@Query("SELECT a FROM Application a WHERE lower(a.name) = lower(:keyword)"
			+ " or lower(a.category) = lower(:keyword)"
			+ " or lower(a.platform) = lower(:keyword)"
			+ " or lower(a.description) like lower(concat('%',:keyword,'%'))"
			+ " and a.approved = true")
	List<Application> findByKeyword(@Param("keyword") String keyword); 
	
	@Query("SELECT a FROM Application a WHERE lower(a.name) = lower(:keyword)"
			+ " or lower(a.category) = lower(:keyword)"
			+ " or lower(a.platform) = lower(:keyword)"
			+ " or lower(a.description) like lower(concat('%',:keyword,'%'))")
	List<Application> findByKeywordForAdmin(@Param("keyword") String keyword); 
	
	@Query("SELECT DISTINCT a.category FROM Application a WHERE a.approved = true")
    List<String> findDistinctCategory();
	
}
