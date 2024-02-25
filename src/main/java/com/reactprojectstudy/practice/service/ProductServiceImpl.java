package com.reactprojectstudy.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.enitity.Product;
import com.reactprojectstudy.practice.pojo.ProductRequest;
import com.reactprojectstudy.practice.repository.ProductRepository;
import com.reactprojectstudy.practice.response.ApiResponse;
import com.reactprojectstudy.practice.response.ProductResponse;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryService categoryService;

	@Override
	public String AddProduct(ProductRequest productRequest) {
		try {
			Category category = categoryService.getCategoryById(productRequest.getCategoryId());
			Product product = new Product();
			product.setProductName(productRequest.getProductName());
			product.setProductCode(productRequest.getProductCode());
			product.setProductPrice(productRequest.getProductPrice());
			product.setProductSalePrice(productRequest.getProductSalePrice());
			product.setProductQuantity(productRequest.getProductQuantity());
			product.setProductDescriptions(productRequest.getProductDescriptions());
			/*
			 * byte[] imageBytes = Base64.decodeBase64(productRequest.getProductImage());
			 * 
			 * product.setProductImage(imageBytes);
			 */
			product.setProductImage(productRequest.getProductImage());
			product.setProductStatus(productRequest.isProductStatus());
			product.setCategory(category);
			productRepository.save(product);
			return "Product added successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "Product added failed !!";
		}
	}

	@Override
	public Product getProductById(Long id) {
		try {
			Optional<Product> optionalProduct = productRepository.findById(id);
			if (optionalProduct.isPresent()) {
				return optionalProduct.get();
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public String deleteProduct(Long id) {
		try {
			productRepository.deleteById(id);
			return "Product deleted Successfully...";

		} catch (Exception e) {
			return "Product not deleted!!!";
		}
	}

	@Override
	public List<ProductResponse> getAllProduct() {
		try {
			List<Product> productDetails = productRepository.findAll();
			List<ProductResponse> productResponseList = new ArrayList<>();
			for (Product product : productDetails) {
				ProductResponse res = new ProductResponse();
				res.setId(product.getId());
				res.setCategoryName(product.getCategory().getCategoryName());
				res.setProductName(product.getProductName());
//				res.setProductImage(Base64.encodeBase64String(product.getProductImage()));
				res.setProductImage(product.getProductImage());
				res.setStatus(product.isProductStatus());
				productResponseList.add(res);
			}
			return productResponseList;

		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	public String updateProduct(Long id, ProductRequest productRequest) {
		try {
			Product existingProduct = productRepository.findById(id).get();
			productRepository.save(existingProduct);
			return "Product Updated Sucessfully..";
		} catch (Exception e) {
			return null;
		}
	}

}
