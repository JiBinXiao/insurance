package com.cr.insurance.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr.insurance.user.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		List<User> users= jdbcTemplate.query("select * from user where email=? and password=?",  new Object[]{user.getEmail(),user.getPassword()},new BeanPropertyRowMapper(User.class));
		if(users.size()>0)
			return true;
		else
			return false;
	}



	public void insert(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert user(email,phone,realname,idcard,password,createdate,updatedate) values(?,?,?,?,?,?,?)", user.getEmail(),user.getPhone(),user.getRealname(),user.getIdcard(),user.getPassword(),user.getCreatedate(),user.getUpdatedate());
	} 
}
