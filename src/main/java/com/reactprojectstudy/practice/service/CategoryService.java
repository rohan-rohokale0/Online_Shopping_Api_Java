package com.reactprojectstudy.practice.service;
import java.util.List;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.pojo.CommonPojo;

public interface CategoryService {

	String AddCategory(CommonPojo category);
	
	List<Category> getAllCategory();
    String deleteCategory(Long id);
    Category getCategoryById(Long id);
    String updateCategory(Long id, Category category); 
}
