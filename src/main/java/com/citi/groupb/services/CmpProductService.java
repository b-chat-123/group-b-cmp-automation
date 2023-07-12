package com.citi.groupb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.groupb.daos.UserRoleDao;
import com.citi.groupb.models.CmpProduct;
import com.citi.groupb.models.User;
import com.citi.groupb.repositories.CmpProductRepository;

@Service
public class CmpProductService {
	
	@Autowired 
	CmpProductRepository cpr;
	
	@Autowired
	UserRoleDao urDao;
	
	public List<CmpProduct> getProductListForRole(String role) {
		return urDao.getProductForRole(role);
	}
	
	public User getUserDetail(String userId, String userPwd) {
		return urDao.getUserDetail(userId, userPwd);	
	}
}
