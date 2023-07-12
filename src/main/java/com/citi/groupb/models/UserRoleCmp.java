package com.citi.groupb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "ROLE_CMP_PRODUCTS")
@Entity
public class UserRoleCmp {
	
	@Id
	@Column(name = "ROLE_ID")
	private String roleId;
	
	@Id
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
}
