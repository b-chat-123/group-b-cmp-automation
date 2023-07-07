package com.citi.groupb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name="USER_ROLE")
public class UserRole {

	@Id
	@Column(name = "ROLE_ID")
	private String roleId;
	
	@Column(name = "ROLE_DESC")
	private String description;

	public UserRole() {
		super();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
