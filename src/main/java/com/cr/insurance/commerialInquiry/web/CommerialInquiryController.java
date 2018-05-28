package com.cr.insurance.commerialInquiry.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.commerialInquiry.entity.CommerialInquiry;
import com.cr.insurance.commerialInquiry.service.CommerialInquiryService;
import com.cr.insurance.insurance.service.InsuranceSlipService;


import com.cr.insurance.user.entity.User;

@Controller
@RequestMapping(value ="commerialInquiry")
public class CommerialInquiryController {

	@Autowired
	private CommerialInquiryService commerialInquiryService;
	
	@Autowired
	private InsuranceSlipService insuranceSlipService;
	
	@RequestMapping("/gotoadd")
	public String gotoadd(String insuranceId,Model model ) {
		
		CommerialInquiry commerialInquiry=commerialInquiryService.findByInsuranceId(insuranceId);
		System.out.println(commerialInquiry);
		model.addAttribute("commerialInquiry",commerialInquiry);
		return "commerialInquiry/add";
	}
	
	
	@RequestMapping("/add")
	public String add(CommerialInquiry commerialInquiry,HttpSession httpSession ) {
		
		User user=(User) httpSession.getAttribute("user");
		
		if(user!=null) {
	
			commerialInquiry.setNewRecord(true);
			commerialInquiry.preinsert(user);
	
		}
		commerialInquiryService.insert(commerialInquiry);
		return "redirect:/insuranceSlip/list";
	}
	
	
	@RequestMapping(value="gotodetail")
	public String gotodetail(CommerialInquiry commerialInquiry,Model model ) {
		commerialInquiry=commerialInquiryService.get(commerialInquiry.getId());
		model.addAttribute("commerialInquiry", commerialInquiry);
		return "/commerialInquiry/detail";
	}
}
