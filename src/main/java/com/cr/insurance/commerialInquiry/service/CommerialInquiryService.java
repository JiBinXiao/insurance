package com.cr.insurance.commerialInquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.insurance.commerialInquiry.dao.CommerialInquiryDao;
import com.cr.insurance.commerialInquiry.entity.CommerialInquiry;
import com.cr.insurance.common.service.CrudService;
import com.cr.insurance.productiveInquiry.dao.ProductiveInquiryDao;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;

@Service
public class CommerialInquiryService implements CrudService<CommerialInquiry>{

	
	@Autowired
	private CommerialInquiryDao commerialInquiryDao;
	
	@Override
	public int insert(CommerialInquiry entity) {
		// TODO Auto-generated method stub
		return commerialInquiryDao.insert(entity);
	}

	@Override
	public int update(CommerialInquiry entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommerialInquiry get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommerialInquiry> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(CommerialInquiry entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CommerialInquiry findByInsuranceId(String id) {
		// TODO Auto-generated method stub
		return commerialInquiryDao.findByInsuranceId(id);
	}

	public void insertByInsuranceId(CommerialInquiry commerialInquiry) {
		// TODO Auto-generated method stub
		commerialInquiryDao.insertbyInsuranceSlip(commerialInquiry);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		commerialInquiryDao.deleteById(id);
	}

	

}
