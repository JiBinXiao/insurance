package com.cr.insurance.admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr.insurance.admin.entity.AdminUser;

@Repository
public class AdminUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		List<AdminUser> adminUsers=jdbcTemplate.query("select * from adminuser where username=? and password=?", new Object[] {adminUser.getUsername(),adminUser.getPassword()},new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
		if(adminUsers!=null && adminUsers.size()>0){
			return adminUsers.get(0);
		}else
			return null;
	
	}
}
