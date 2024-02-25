package com.reactprojectstudy.practice.controller;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reactprojectstudy.practice.enitity.Category;
import com.reactprojectstudy.practice.enitity.Product;
import com.reactprojectstudy.practice.enitity.User;
import com.reactprojectstudy.practice.pojo.ProductRequest;
import com.reactprojectstudy.practice.response.ApiResponse;
import com.reactprojectstudy.practice.response.ProductResponse;
import com.reactprojectstudy.practice.service.ProductService;
import com.reactprojectstudy.practice.service.UserService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@PostMapping("add-product")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductRequest productRequest) {

		String msg = productService.AddProduct(productRequest);
		ApiResponse res = new ApiResponse(msg, true);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
	}

	@GetMapping("get-product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("get-product")
	public ResponseEntity<List<ProductResponse>> getAllProduct() {
		List<ProductResponse> product = productService.getAllProduct();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
		String msg = productService.deleteProduct(id);
		System.out.println("dlete product controller .... msg " + msg);
		ApiResponse res = new ApiResponse(msg, true);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
	}
	
	

	@PutMapping("updateProductById/{id}")
	public ResponseEntity<ApiResponse>updateProduct(@PathVariable Long id,ProductRequest productRequest)
	{
	String Message=productService.updateProduct(id, productRequest);
	ApiResponse res=new ApiResponse(Message,true);
	return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	
	
	
	}
	

	@GetMapping("get-image")
	public ResponseEntity<List<User>> getAllImage() {
		List<User> user = userService.getAllImages();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
