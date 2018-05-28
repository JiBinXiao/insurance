package com.cr.insurance.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.insurance.admin.dao.AdminUserDao;
import com.cr.insurance.admin.entity.AdminUser;

@Service
public class AdminUserService {

	@Autowired
	private AdminUserDao adminUserDao;

	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return adminUserDao.login(adminUser);
	}
}
