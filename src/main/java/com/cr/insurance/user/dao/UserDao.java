package com.cr.insurance.user.dao;

import java.util.List;import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr.insurance.user.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	public User checkUser(User user) {
		// TODO Auto-generated method stub
		List<User> users= jdbcTemplate.query("select * from user where email=? and password=?",  new Object[]{user.getEmail(),user.getPassword()},new BeanPropertyRowMapper(User.class));
		if(users.size()>0)
			return users.get(0);
		else
			return null;
	}



	public void insert(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert user(email,phone,realname,idcard,password,createdate,updatedate) values(?,?,?,?,?,?,?)", user.getEmail(),user.getPhone(),user.getRealname(),user.getIdcard(),user.getPassword(),user.getCreatedate(),user.getUpdatedate());
	}



	public void update(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set email=?,phone=?,realname=?,idcard=?,updatedate=? where id=?",user.getEmail(),user.getPhone(),user.getRealname(),user.getIdcard(),user.getUpdatedate(),user.getId());
	}



	public User get(int userId) {
		// TODO Auto-generated method stub
		List<User> users=jdbcTemplate.query("select * from user where id=?", new Object[] {userId},new BeanPropertyRowMapper<User>(User.class));
		if(users.size()>0)
			return users.get(0);
		else
			return null;
	}



	public void updatepwd(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set password=? where id=?",user.getId(),user.getPassword());
	}



	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users=jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
		return users;
	} 
}
