package com.cr.insurance.user.service;

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
	
}
