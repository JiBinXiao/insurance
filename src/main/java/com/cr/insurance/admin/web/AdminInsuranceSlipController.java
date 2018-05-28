package com.cr.insurance.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println(insuranceSlip);
		return insuranceSlip;
	}
}
