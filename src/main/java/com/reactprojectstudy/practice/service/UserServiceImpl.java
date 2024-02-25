package com.reactprojectstudy.practice.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.enitity.Product;
import com.reactprojectstudy.practice.enitity.User;
import com.reactprojectstudy.practice.pojo.ProductRequest;
import com.reactprojectstudy.practice.repository.ProductRepository;
import com.reactprojectstudy.practice.repository.UserRepository;
import com.reactprojectstudy.practice.response.ApiResponse;
import com.reactprojectstudy.practice.response.ProductResponse;

@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String addImage(User user) {
		try {
		
			userRepository.save(user);
			return "Product added successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "Product added failed !!";
		}
	}

	@Override
	public List<User> getAllImages() {
		return userRepository.findAll();
	}


}
