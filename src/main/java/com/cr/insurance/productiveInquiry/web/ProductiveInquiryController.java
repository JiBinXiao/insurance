package com.cr.insurance.productiveInquiry.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.insurance.entity.InsuranceSlip;
import com.cr.insurance.insurance.service.InsuranceSlipService;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;
import com.cr.insurance.productiveInquiry.service.ProductiveInquiryService;
import com.cr.insurance.user.entity.User;

@Controller
@RequestMapping(value ="productiveInquiry")
public class ProductiveInquiryController {

	@Autowired
	private ProductiveInquiryService productiveInquiryService;
	
	@Autowired
	private InsuranceSlipService insuranceSlipService;
	
	@RequestMapping("/gotoadd")
	public String gotoadd(String insuranceId,String type,Model model ) {
		
		ProductiveInquiry productiveInquiry=productiveInquiryService.findByInsuranceId(insuranceId);
		System.out.println(productiveInquiry);
		model.addAttribute("productiveInquiry",productiveInquiry);
		return "productiveInquiry/add";
	}
	
	
	@RequestMapping("/add")
	public String add(ProductiveInquiry productiveInquiry,HttpSession httpSession ) {
		
		User user=(User) httpSession.getAttribute("user");
		
		if(user!=null) {
	
			productiveInquiry.setNewRecord(true);
			productiveInquiry.preinsert(user);
	
		}
		productiveInquiryService.insert(productiveInquiry);
		return "redirect:/insuranceSlip/list";
	}
	
	
	@RequestMapping(value="gotodetail")
	public String gotodetail(ProductiveInquiry productiveInquiry,Model model ) {
		productiveInquiry=productiveInquiryService.get(productiveInquiry.getId());
		model.addAttribute("productiveInquiry", productiveInquiry);
		return "/productiveInquiry/detail";
	}
}
