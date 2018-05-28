package com.cr.insurance.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cr.insurance.user.dao.UserDao;
import com.cr.insurance.user.entity.User;



@Service
@Transactional( readOnly=true)
public class UserService {

	@Autowired
	private UserDao userDao;
	


	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUser(user);
	}


	@Transactional( readOnly=false)
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Transactional( readOnly=false)
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}


	public User get(int userId) {
		// TODO Auto-generated method stub
		return userDao.get(userId);
	}


	public void updatepwd(User user) {
		// TODO Auto-generated method stub
		userDao.updatepwd(user);
	}


	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
}
