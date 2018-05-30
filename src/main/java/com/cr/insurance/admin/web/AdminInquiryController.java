package com.cr.insurance.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.insurance.commerialInquiry.entity.CommerialInquiry;
import com.cr.insurance.commerialInquiry.service.CommerialInquiryService;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;
import com.cr.insurance.productiveInquiry.service.ProductiveInquiryService;

@Controller
@RequestMapping(value = "Inquiry")
public class AdminInquiryController {
	
	@Autowired
	private CommerialInquiryService commerialInquiryService;

	@Autowired
	private ProductiveInquiryService productiveInquiryService;
	
	@RequestMapping(value = "commerialdetial")
	@ResponseBody
	public CommerialInquiry commerialInquiryDetail(String id) {
		CommerialInquiry commerialInquiry=new CommerialInquiry();
		
		return commerialInquiry;
	}
	
	@RequestMapping(value = "productldetial")
	@ResponseBody
	public ProductiveInquiry productInquiryDetail(String id) {
		ProductiveInquiry productiveInquiry=new ProductiveInquiry();
		
		return productiveInquiry;
	}
}
