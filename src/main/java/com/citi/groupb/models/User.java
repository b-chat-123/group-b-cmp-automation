package com.citi.groupb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name="USER")
public class User {

	@Id
	private String userId;
	private String name;
	private String role;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", role=" + role + "]";
	}
	
}
