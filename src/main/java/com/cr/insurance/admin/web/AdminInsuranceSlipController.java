package com.cr.insurance.admin.web;

import java.sql.Timestamp;
import java.util.ArrayList;
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
	public String list(Model model,String sortType) {
		List<InsuranceSlip> insuranceSlips=new ArrayList<InsuranceSlip>();
		//编号升序
		if(sortType==null || "".equals(sortType) || sortType.equals("1") ) {
			insuranceSlips=insuranceSlipService.findAll();
			sortType="1";
			
		}
		
		//编号降序
		if(sortType==null || sortType.equals("2") ) {
			insuranceSlips=insuranceSlipService.findAllDesc();
			
			
		}
		
		//创建时间升序
		if(sortType==null || sortType.equals("3") ) {
			insuranceSlips=insuranceSlipService.findAllbyTimeAsc();
			
			
		}
		
		//创建时间降序
		if(sortType==null || sortType.equals("4") ) {
			insuranceSlips=insuranceSlipService.findAllbyTimeDesc();
			
			
		}
		
		////审核状态
		if(sortType==null || sortType.equals("5") ) {
			insuranceSlips=insuranceSlipService.findPassAll();
			
			
		}
		
	
		model.addAttribute("insuranceSlips",insuranceSlips);
		model.addAttribute("sortType",sortType);
		
		return "admin/insuranceSliplist";
	}
	
	@RequestMapping(value = "modify")
	public String update(InsuranceSlip insuranceSlip,HttpSession HttpSession) {
		AdminUser adminUser=(AdminUser) HttpSession.getAttribute("adminUser"); 
		insuranceSlip.setFirsttrialperson(adminUser.getUsername());
		insuranceSlip.setFirsttrialtime(new Timestamp(System.currentTimeMillis()));
		insuranceSlip.setFirsttrialstate("初审通过");
		insuranceSlipService.updateState(insuranceSlip);
		
		return "redirect:/admin/insuranceSlip/list"; 
	}
	

}
