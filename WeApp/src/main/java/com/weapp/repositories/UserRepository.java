package com.weapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weapp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

  User findByUsername(String username);
  User findByName(String name);
  List<User> findByAuthories(String authority);
}