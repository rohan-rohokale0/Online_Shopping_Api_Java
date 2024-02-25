
package com.reactprojectstudy.practice.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ProductRequest {

	private String productName;

	@Lob
	private String productImage;

	private Long categoryId;
	
	private boolean productStatus;
	
	private Number productPrice;
	private Number productSalePrice;
	private Number productQuantity;
	private String productDescriptions;

	
	private String productCode;
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Number getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Number productPrice) {
		this.productPrice = productPrice;
	}

	public Number getProductSalePrice() {
		return productSalePrice;
	}

	public void setProductSalePrice(Number productSalePrice) {
		this.productSalePrice = productSalePrice;
	}

	public Number getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Number productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductDescriptions() {
		return productDescriptions;
	}

	public void setProductDescriptions(String productDescriptions) {
		this.productDescriptions = productDescriptions;
	}




	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
}
