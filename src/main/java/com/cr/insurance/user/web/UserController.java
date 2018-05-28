package com.cr.insurance.user.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String login(User user,HttpSession session) {
		
		user=userService.checkUser(user);
		
		if(user!=null) {
			
			session.setAttribute("user", user);
			return "redirect:/index";
		}
			
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
	
	@RequestMapping( value = "gotodetail")
	public String gotodetail(HttpSession httpSession,Model model) {
		User user =(User) httpSession.getAttribute("user");
		model.addAttribute("user",user);
		return "/user/detail";
	}
	
	@RequestMapping( value = "update")
	public String update(User user,Model model,HttpSession httpSession) {
		
		userService.update(user);
		httpSession.setAttribute("user", user);
		return "redirect:/index";
	}
	
	
	
	
	@RequestMapping(value = "gotologin")
	public String gotologin() {
		
		
		return "login";
	}
	
	@RequestMapping(value = "gotoregister")
	public String gotoregister() {
		
		
		return "register";
	}
	
	@RequestMapping(value = "quit")
	public String quit(HttpSession httpSession) {
		
		httpSession.setAttribute("user", null);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "modifypwd")
	public String modifypwd(String newpwd,HttpSession httpSession) {
		User user =(User) httpSession.getAttribute("user");
		user.setPassword(newpwd);
		userService.updatepwd(user);
		
		return "redirect:/index";
		
	}
}
