package com.reactprojectstudy.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.pojo.CommonPojo;
import com.reactprojectstudy.practice.response.ApiResponse;
import com.reactprojectstudy.practice.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("add-category")
	String addCategory(@RequestBody CommonPojo pojo) {

		return categoryService.AddCategory(pojo);

	}

	@GetMapping("getCategory")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> CategoryList = categoryService.getAllCategory();
		return new ResponseEntity<>(CategoryList, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteCategory/{id}")
	public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Long id)
	{
		String msg=categoryService.deleteCategory(id);
		System.out.println("dlete product controller .... msg "+msg);
		ApiResponse res=new ApiResponse(msg,true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("getCategoryById/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id)
	{
		Category categoyList=categoryService.getCategoryById(id);
		return new ResponseEntity<>(categoyList, HttpStatus.OK);
	}

	@PutMapping("updateCategoryById/{id}")
	public ResponseEntity<ApiResponse>updateCategory(@PathVariable Long id,Category category)
	{
	String Message=categoryService.updateCategory(id, category);
	ApiResponse res=new ApiResponse(Message,true);
	return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
}
