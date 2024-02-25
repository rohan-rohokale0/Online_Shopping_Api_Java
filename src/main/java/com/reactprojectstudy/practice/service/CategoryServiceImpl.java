package com.reactprojectstudy.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.pojo.CommonPojo;
import com.reactprojectstudy.practice.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

//	CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public String AddCategory(CommonPojo categoryPojo) {
		try {
			Category category = new Category();
			category.setCategoryName(categoryPojo.getName());
			categoryRepository.save(category);
			return "Category added successfully...";

		} catch (Exception e) {
			e.printStackTrace();
			return "Category added failed !!";
		}
	}

	@Override
	public List<Category> getAllCategory() {
		try {
			return categoryRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public String deleteCategory(Long id) {

		try {
			// Optional<Category> category=categoryRepository.findById(id);
			categoryRepository.deleteById(id);
			return "Category deleted Successfully...";

		} catch (Exception e) {
			return "Category not deleted!!!";
		}
	}

	@Override
	public Category getCategoryById(Long id) {
		try {
			Optional<Category> optionalCategory = categoryRepository.findById(id);
			if (optionalCategory.isPresent()) {
				return optionalCategory.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String updateCategory(Long id, Category category) {
		try {
			Category existingCategory = categoryRepository.findById(id).get();
			categoryRepository.save(existingCategory);
			return "Category Updated Sucessfully..";
		} catch (Exception e) {
			return null;
		}
	}
}
