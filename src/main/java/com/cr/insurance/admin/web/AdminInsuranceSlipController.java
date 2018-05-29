package com.cr.insurance.admin.web;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.insurance.admin.entity.AdminUser;
import com.cr.insurance.insurance.entity.InsuranceSlip;
import com.cr.insurance.insurance.service.InsuranceSlipService;


@Controller
@RequestMapping(value = "admin/insuranceSlip")
public class AdminInsuranceSlipController {

	@Autowired 
	InsuranceSlipService insuranceSlipService;
	
	@ResponseBody
	@RequestMapping(value = "detail")
	public InsuranceSlip detail(String id) {
		
		InsuranceSlip insuranceSlip=insuranceSlipService.get(Integer.parseInt(id));
		
		return insuranceSlip;
	}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		
		List<InsuranceSlip> insuranceSlips=insuranceSlipService.findAll();
		
		model.addAttribute("insuranceSlips",insuranceSlips);
		
		return "admin/insuranceSliplist";
	}
	
	@RequestMapping(value = "modify")
	public String update(InsuranceSlip insuranceSlip,HttpSession HttpSession) {
		AdminUser adminUser=(AdminUser) HttpSession.getAttribute("adminUser"); 
		insuranceSlip.setFirsttrialperson(adminUser.getUsername());
		insuranceSlip.setFirsttrialtime(new Timestamp(System.currentTimeMillis()));
		insuranceSlip.setFirsttrialstate("初审通过");
		System.out.println("审核");
		System.out.println(insuranceSlip);
		
		return "redirect:admin/insuranceSlip/list"; 
	}
}
