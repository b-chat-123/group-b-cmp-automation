package com.citi.groupb.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.groupb.models.CmpProduct;
import com.citi.groupb.services.CmpProductService;

@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/cmp/private/api/v1")
@CrossOrigin(origins = "*")
public class NewUserCmpController {

	@Autowired
	private CmpProductService cps;

	@GetMapping("/role/{role}/products")
	ResponseEntity productListForRole(
			@PathVariable(value="role") String role){

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Access-Control-Allow-Origin", "*");
		
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.body(cps.getProductListForRole(role));
	}

	@GetMapping("/user")
	ResponseEntity productListForRole(
			@RequestBody HashMap<String, Object> body){

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Access-Control-Allow-Origin", "*");
		
		String userId = "", password = "";
		
		if ( body.containsKey("userId") ) {
			userId = ((String) body.get("userId")).trim();
		} else {
			return ResponseEntity
					.badRequest()
					.body("UserId/password mandatory");
		}
		
		if ( body.containsKey("password") ) {
			password = ((String) body.get("password")).trim();
		} else {
			return ResponseEntity
					.badRequest()
					.body("UserId/password mandatory");
		}
		
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.body(cps.getUserDetail(userId, password));
	}
	
	@GetMapping("/user/{userId}/{password}")
	ResponseEntity productListForRoleTest(
			@PathVariable(value="userId") String userId,
			@PathVariable(value="password") String password){

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Access-Control-Allow-Origin", "*");
		
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.body(cps.getUserDetail(userId, password));
	}
}