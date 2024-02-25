package com.reactprojectstudy.practice.response;

import jakarta.persistence.Lob;

public class ProductResponse {
	
//	private String message;
//	private boolean status;
	
	private Long id;
	private String productName;
	private String categoryName;
	private boolean status;
	@Lob
	private String productImage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long long1) {
		this.id = long1;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

}
