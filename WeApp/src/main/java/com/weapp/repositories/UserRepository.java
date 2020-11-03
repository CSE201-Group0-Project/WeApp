package com.weapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weapp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	// @Query("SELECT u FROM User u WHERE u.name = :name")
	User findByUsername(String username);
	List<User> findByName(String name);
}