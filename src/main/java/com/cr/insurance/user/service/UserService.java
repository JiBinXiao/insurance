package com.cr.insurance.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.insurance.user.dao.UserDao;
import com.cr.insurance.user.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	


	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUser(user);
	}



	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}
	
}
