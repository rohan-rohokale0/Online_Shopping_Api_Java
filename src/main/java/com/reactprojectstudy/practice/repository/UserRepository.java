package com.reactprojectstudy.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactprojectstudy.practice.enitity.Product;
import com.reactprojectstudy.practice.enitity.User;

public interface UserRepository extends JpaRepository<User,Long>  {
	  User findFirstByEmail(String email);
	  
}
