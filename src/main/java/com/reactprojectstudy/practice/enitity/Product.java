package com.reactprojectstudy.practice.enitity;

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

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Lob

	@Column(name = "product_image", nullable = false,columnDefinition="LONGTEXT")
	private String productImage;

	/*
	 * @Lob
	 * 
	 * @Column(name = "product_image", nullable = false,columnDefinition="LONGBLOB")
	 * private byte[] productImage;
	 */

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Column(name = "product_status", nullable = false)
	private boolean productStatus;

	@Column(name = "product_code", nullable = false)
	private String productCode;

	@Column(name = "product_price", nullable = false)
	private Number productPrice;

	@Column(name = "product_sale_price", nullable = false)
	private Number productSalePrice;

	@Column(name = "product_quantity", nullable = false)
	private Number productQuantity;

	@Column(name = "product_descriptions", nullable = false)
	private String productDescriptions;

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

	/*
	 * public byte[] getProductImage() { return productImage; }
	 * 
	 * public void setProductImage(byte[] productImage) { this.productImage =
	 * productImage; }
	 */
	

	public Long getId() {
		return id;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
}
