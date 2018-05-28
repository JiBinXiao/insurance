package com.cr.insurance.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.enterprise.entity.Enterprise;
import com.cr.insurance.enterprise.service.EnterpeiseService;

@Controller
@RequestMapping(value = "admin/enterprise")
public class AdminEnterpriseController {

	@Autowired
	private EnterpeiseService enterpeiseService;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Enterprise> enterprises=enterpeiseService.findAll();
		model.addAttribute("enterprises", enterprises);
		return "admin/enterpriselist";
	}
}
