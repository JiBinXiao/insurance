package com.cr.insurance.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.user.entity.User;
import com.cr.insurance.user.service.UserService;

@Controller
@RequestMapping(value = "admin/user")
public class AdminUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public String findAll(Model model) {
		List<User> users=userService.findAll();
		
		model.addAttribute("users",users);
		return "admin/userlist";
	}
	
}
