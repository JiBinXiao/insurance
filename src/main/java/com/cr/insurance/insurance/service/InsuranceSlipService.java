package com.cr.insurance.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cr.insurance.common.service.CrudService;
import com.cr.insurance.insurance.dao.InsuranceSlipDao;
import com.cr.insurance.insurance.entity.InsuranceSlip;


@Service
@Transactional( readOnly=true)
public class InsuranceSlipService implements CrudService<InsuranceSlip> {

	@Autowired
	private InsuranceSlipDao insuranceSlipDao;
	
	@Transactional( readOnly=false)
	@Override
	public int insert(InsuranceSlip entity) {
		// TODO Auto-generated method stub
		return insuranceSlipDao.insert(entity);
	}

	@Transactional( readOnly=false)
	@Override
	public int update(InsuranceSlip entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InsuranceSlip get(int id) {
		// TODO Auto-generated method stub
		return insuranceSlipDao.get(id);
	}

	@Override
	public List<InsuranceSlip> findAll() {
		// TODO Auto-generated method stub
		return insuranceSlipDao.findAll();
	}

	@Transactional( readOnly=false)
	@Override
	public int delete(InsuranceSlip entity) {
		// TODO Auto-generated method stub
		return insuranceSlipDao.delete(entity);
	}
	
	public List<InsuranceSlip> findAll(int userId) {
		// TODO Auto-generated method stub
		return insuranceSlipDao.findAll(userId);
	}

	public InsuranceSlip findbySureName(String surename) {
		// TODO Auto-generated method stub
		return insuranceSlipDao.findBySureName(surename);
	}

}
