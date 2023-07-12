package com.citi.groupb.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity (name="CMP_PRODUCT")
public class CmpProduct {
	
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_DESC")
	private String description;
	
	@Column(name = "API_PARM")
	private String params;
	
	public CmpProduct() {
		super();
	}

	public CmpProduct(long productId, String description, String params) {
		super();
		this.productId = productId;
		this.description = description;
		this.params = params;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		return "CmpProduct [productId=" + productId + ", description=" + description + ", params=" + params + "]";
	}
	
}
