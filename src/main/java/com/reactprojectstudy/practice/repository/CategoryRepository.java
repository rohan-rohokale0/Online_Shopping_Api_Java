package com.reactprojectstudy.practice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reactprojectstudy.practice.enitity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//@Query("SELECT p From Product p Where LOWER(p.category.name)=:category")

	//public List<Category> findByCategory(@Param("category") String name);
	
}
