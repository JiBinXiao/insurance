package com.cr.insurance.user.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cr.insurance.user.entity.User;
import com.cr.insurance.user.service.UserService;import javassist.bytecode.CodeAttribute;

@Controller
@RequestMapping( value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user) {
		
		boolean flag=userService.checkUser(user);
		
		if(flag)
			return "redirect:/index";
		else
			return "redirect:/user/gotologin";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
		
		user.setNewRecord(true);
		user.preinsert();
		userService.insert(user);
		
		
		return "redirect:/index";

	}
	
	
	
	
	@RequestMapping(value = "/gotologin")
	public String gotologin() {
		
		
		return "login";
	}
	
	@RequestMapping(value = "/gotoregister")
	public String gotoregister() {
		
		
		return "register";
	}
}
