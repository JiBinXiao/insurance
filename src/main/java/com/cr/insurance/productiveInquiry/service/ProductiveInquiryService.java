package com.cr.insurance.productiveInquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.insurance.common.service.CrudService;
import com.cr.insurance.productiveInquiry.dao.ProductiveInquiryDao;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;

@Service
public class ProductiveInquiryService implements CrudService<ProductiveInquiry>{

	
	@Autowired
	private ProductiveInquiryDao productiveInquiryDao;
	
	@Override
	public int insert(ProductiveInquiry entity) {
		// TODO Auto-generated method stub
		return productiveInquiryDao.insert(entity);
	}

	@Override
	public int update(ProductiveInquiry entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductiveInquiry get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductiveInquiry> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(ProductiveInquiry entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ProductiveInquiry findByInsuranceId(String id) {
		// TODO Auto-generated method stub
		return productiveInquiryDao.findByInsuranceId(id);
	}

	public void insertByInsuranceId(ProductiveInquiry productiveInquiry) {
		// TODO Auto-generated method stub
		productiveInquiryDao.insertbyInsuranceSlip(productiveInquiry);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productiveInquiryDao.deleteById(id);
	}

	

}
