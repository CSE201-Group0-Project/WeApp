package com.weapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weapp.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	// select * from application where name = :name
	List<Application> findByName(String name); 
	
	// select * from application where organization = :organization
	List<Application> findByOrganization(String organization); 

}
