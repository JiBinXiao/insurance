package com.cr.insurance.enterprise.web;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.enterprise.entity.Enterprise;
import com.cr.insurance.enterprise.service.EnterpeiseService;

@Controller
@RequestMapping(value = "/enterprise")
public class EnterpriseController {

	@Autowired
	private EnterpeiseService enterpriseService;
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		List<Enterprise> enterprises= enterpriseService.findAll();
		
		model.addAttribute("enterprises", enterprises);
		return "enterprise/list";
	}
	
	@RequestMapping(value = "/insert")
	public String insert (Enterprise enterprise){
		enterprise.setNewRecord(true);
		enterprise.preinsert();
		enterpriseService.insert(enterprise);
		
		return "redirect:/enterprise/list";
		
	}
	
	@RequestMapping(value = "/update")
	public String update(Enterprise enterprise) {
		
		enterprise.setNewRecord(false);
		enterprise.preinsert();
		enterpriseService.update(enterprise);
		return "redirect:/enterprise/list";
	}
	
	@RequestMapping(value = "/gotoupdate")
	public String gotoupdate(Enterprise enterprise) {
		
		
		enterpriseService.get(enterprise.getId());
		return "enterprise/update";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Enterprise enterprise) {
		
		enterpriseService.delete(enterprise);
		return "redirect:/enterprise/list";
	}
	
}
