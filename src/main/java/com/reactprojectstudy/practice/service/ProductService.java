package com.reactprojectstudy.practice.service;
import java.util.List;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.enitity.Product;
import com.reactprojectstudy.practice.pojo.ProductRequest;
import com.reactprojectstudy.practice.response.ProductResponse;

public interface ProductService {
	String AddProduct(ProductRequest productRequest);
	Product getProductById(Long id);
	List<ProductResponse> getAllProduct();
    String deleteProduct(Long id);
    String updateProduct(Long id, ProductRequest productRequest); 
    
}
