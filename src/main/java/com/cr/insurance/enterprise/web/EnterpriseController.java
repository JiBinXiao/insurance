package com.cr.insurance.enterprise.web;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.enterprise.entity.Enterprise;
import com.cr.insurance.enterprise.service.EnterpeiseService;
import com.cr.insurance.user.entity.User;

@Controller
@RequestMapping(value = "/enterprise")
public class EnterpriseController {

	@Autowired
	private EnterpeiseService enterpriseService;
	
	@RequestMapping(value = "/list")
	public String list(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		List<Enterprise> enterprises= enterpriseService.findAll(user.getId());
		
		model.addAttribute("enterprises", enterprises);
		return "enterprise/list";
	}
	

	
	@RequestMapping(value = "/update")
	public String update(Enterprise enterprise,HttpSession session) {
		
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			enterprise.setUserId(user.getId());
			enterprise.setNewRecord(false);
			enterprise.preinsert(user);
		}
		System.out.println(enterprise);
		enterpriseService.update(enterprise);
		return "redirect:/enterprise/list";
	}
	
	@RequestMapping(value = "/gotoupdate")
	public String gotoupdate(Enterprise enterprise,Model model) {
		
		
		enterprise=enterpriseService.get(enterprise.getId());
		
		model.addAttribute("enterprise", enterprise);
		return "enterprise/update";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Enterprise enterprise) {
		
		enterpriseService.delete(enterprise);
		return "redirect:/enterprise/list";
	}
	
	@RequestMapping(value = "gotoadd")
	public String gotoadd() {
		
		
		return "enterprise/add";
	}
	
	@RequestMapping(value = "add")
	public String addd(Enterprise enterprise,HttpSession session) {
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			enterprise.setUserId(user.getId());
			enterprise.setNewRecord(true);
			enterprise.preinsert(user);
		}
		System.out.println(enterprise);

		enterpriseService.insert(enterprise);
		
		return "redirect:/enterprise/list";
	}
	
	@RequestMapping(value = "/gotodetail")
	public String gotodetail(Enterprise enterprise,Model model) {
		
		
		enterprise=enterpriseService.get(enterprise.getId());
		System.out.println(enterprise.getCreatedate()+"\t"+enterprise.getUpdatedate());
		model.addAttribute("enterprise", enterprise);
		return "enterprise/detail";
	}
	
}
