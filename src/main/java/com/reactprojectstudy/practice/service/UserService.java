package com.reactprojectstudy.practice.service;
import java.util.List;
import com.reactprojectstudy.practice.enitity.Product;
import com.reactprojectstudy.practice.enitity.User;
import com.reactprojectstudy.practice.pojo.ProductRequest;
import com.reactprojectstudy.practice.response.ProductResponse;

public interface UserService {
	String addImage(User user);
	List<User> getAllImages();

}
