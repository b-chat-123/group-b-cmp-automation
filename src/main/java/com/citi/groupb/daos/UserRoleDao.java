package com.citi.groupb.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.citi.groupb.models.CmpProduct;
import com.citi.groupb.models.User;

@Repository
public class UserRoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CmpProduct> getProductForRole (String role) {
		
		return this.jdbcTemplate.query(
				"select P.PRODUCT_ID, P.PRODUCT_DESC, P.API_PARM from ROLE_CMP_PRODUCTS R, CMP_PRODUCT P where R.ROLE_ID = ? and R.PRODUCT_ID = P.PRODUCT_ID",
				new CmpProductMapRow(),
				role);
	}
	
	//********************************************************************************
	class CmpProductMapRow implements RowMapper<CmpProduct> {

		@Override
		public CmpProduct mapRow(ResultSet rs, int rowNum) throws SQLException {

			CmpProduct cp = new CmpProduct();
			
			cp.setProductId(rs.getLong("PRODUCT_ID")); 
			cp.setDescription(rs.getString("PRODUCT_DESC"));
			cp.setParams(rs.getString("API_PARM"));
			
			return cp;
		}
		
	}

	public User getUserDetail(String userId, String userPwd) {
		List<User> userList = this.jdbcTemplate.query(
				"select USER_ID, USER_NAME, ROLE_ID from USER where upper(USER_ID) = upper(?) and USER_PWD = ?",
				new UserMapRow(),
				userId,
				userPwd);
		
		return userList.size() == 1 ? userList.get(0) : null;
	}


	//********************************************************************************
	class UserMapRow implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User u = new User();
			
			u.setUserId(rs.getString("USER_ID")); 
			u.setName(rs.getString("USER_NAME")); 
			u.setRole(rs.getString("ROLE_ID")); 
			
			return u;
		}
		
	}

}
