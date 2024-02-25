package com.reactprojectstudy.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactprojectstudy.practice.enitity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>  {

}
