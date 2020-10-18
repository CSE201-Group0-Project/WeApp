package com.weapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weapp.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	

}
