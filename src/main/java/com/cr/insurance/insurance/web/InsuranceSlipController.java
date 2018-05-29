package com.cr.insurance.insurance.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cr.insurance.commerialInquiry.entity.CommerialInquiry;
import com.cr.insurance.commerialInquiry.service.CommerialInquiryService;
import com.cr.insurance.enterprise.entity.Enterprise;
import com.cr.insurance.enterprise.service.EnterpeiseService;
import com.cr.insurance.insurance.entity.InsuranceSlip;
import com.cr.insurance.insurance.service.InsuranceSlipService;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;
import com.cr.insurance.productiveInquiry.service.ProductiveInquiryService;
import com.cr.insurance.user.entity.User;
import com.cr.insurance.user.service.UserService;

@Controller
@RequestMapping( value ="/insuranceSlip")
public class InsuranceSlipController {

	@Autowired
	private InsuranceSlipService  insuranceSlipService;
	
	@Autowired
	private ProductiveInquiryService productiveInquiryService;
	
	@Autowired
	private CommerialInquiryService commerialInquiryService;
	
	@Autowired
	private EnterpeiseService enterpeiseService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="list")
	public String findAll(HttpSession httpSession,Model model) {
		User user=(User) httpSession.getAttribute("user");
		List<InsuranceSlip> insuranceSlips=null;
		if(user != null) {
			 insuranceSlips= insuranceSlipService.findAll(user.getId());
		}
		model.addAttribute("insuranceSlips", insuranceSlips);
		return "insurance/list";
	}
	
	@RequestMapping( value = "gotoadd")
	public String gotoadd(String enterpriseId,Model model){
		Enterprise enterprise=enterpeiseService.get(Integer.parseInt(enterpriseId));
		User user=userService.get(enterprise.getUserId());
		InsuranceSlip insuranceSlip=new InsuranceSlip();
		
		insuranceSlip.setSurename(enterprise.getName());
		insuranceSlip.setSurepostalcode(enterprise.getPostalcode());
		insuranceSlip.setSurepostaladdress(enterprise.getAddress());
		insuranceSlip.setSuretype(enterprise.getType());
		insuranceSlip.setSureperson(user.getRealname());
		insuranceSlip.setSurephone(user.getPhone());
		model.addAttribute("insuranceSlip",insuranceSlip);
		return "insurance/add";
	}
	
	@RequestMapping( value = "add")
	public String add(InsuranceSlip insuranceSlip,BindingResult bindingResult,HttpSession httpSession) {
		User user=(User) httpSession.getAttribute("user");
	
		if(user!=null) {
			insuranceSlip.setUserid(user.getId());
			insuranceSlip.setNewRecord(true);
			insuranceSlip.preinsert(user);
			insuranceSlip.setEnterpriseid(1);
		}
		
		
		insuranceSlipService.insert(insuranceSlip);
		//通过投保人名称得到投保单
		insuranceSlip=insuranceSlipService.findbySureName(insuranceSlip.getSurename());

		//新增风险咨询表
		String type=insuranceSlip.getSuretype();
		if("商业性企业".equals(type)) {
			CommerialInquiry commerialInquiry=new CommerialInquiry();
			commerialInquiry.setName(insuranceSlip.getSurename());
			commerialInquiry.setAddress(insuranceSlip.getSurepostaladdress());
			commerialInquiry.setPostalcode(insuranceSlip.getSurepostalcode());
			commerialInquiry.setInsuranceslipid(insuranceSlip.getId());
		
			commerialInquiryService.insertByInsuranceId(commerialInquiry);
		}
		
		if("生产性企业".equals(type)) {
			ProductiveInquiry productiveInquiry=new ProductiveInquiry();
			productiveInquiry.setName(insuranceSlip.getSurename());
			productiveInquiry.setAddress(insuranceSlip.getSurepostaladdress());
			productiveInquiry.setPostalcode(insuranceSlip.getSurepostalcode());
			productiveInquiry.setInsuranceslipid(insuranceSlip.getId());
		
			productiveInquiryService.insertByInsuranceId(productiveInquiry);
		}
		
		return "redirect:/insuranceSlip/list";
	}
	
	@RequestMapping( value = "gotodetail")
	public String gotodetail(InsuranceSlip insuranceSlip,Model model) {
	    insuranceSlip=insuranceSlipService.get(insuranceSlip.getId());
		model.addAttribute("insuranceSlip",insuranceSlip);
		return "insurance/detail";
	}
	
	@RequestMapping(value = "delete")
	public String delete(InsuranceSlip insuranceSlip) {
		
		productiveInquiryService.deleteById(insuranceSlip.getId());
		commerialInquiryService.deleteById(insuranceSlip.getId());
		insuranceSlipService.delete(insuranceSlip);
		
		return "redirect:/insuranceSlip/list";
		
	}
	

}
