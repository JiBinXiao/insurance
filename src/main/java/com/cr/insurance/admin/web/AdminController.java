package com.cr.insurance.admin.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.admin.entity.AdminUser;
import com.cr.insurance.admin.service.AdminUserService;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private AdminUserService adminUserService;
	
	@RequestMapping(value="index")
	public String gotologin() {
		
		
		return "admin/login";
	}
	
	@RequestMapping(value = "main")
	public String gotomain() {
		
		
		return "admin/main";
	}
	
	@RequestMapping(value="login")
	public String gotologin(AdminUser adminUser,HttpSession httpSession) {
		adminUser=adminUserService.login(adminUser);
		if(adminUser!=null && adminUser.getId()!=0) {
			httpSession.setAttribute("adminUser", adminUser);
			return "redirect:/admin/main";
		}else {
			return "redirect:index";
		}
		
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession httpSession) {
		httpSession.setAttribute("adminUser", null);
		
		return "redirect:index";
		
		
	}
	

	
	

	
	
}
