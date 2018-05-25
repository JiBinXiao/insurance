package com.cr.insurance.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.insurance.common.service.CrudService;
import com.cr.insurance.enterprise.dao.EnterpriseDao;
import com.cr.insurance.enterprise.entity.Enterprise;

@Service
public class EnterpeiseService implements CrudService<Enterprise>{

	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Override
	public int insert(Enterprise entity) {
		// TODO Auto-generated method stub
		return enterpriseDao.insert(entity);
	}

	@Override
	public int update(Enterprise entity) {
		// TODO Auto-generated method stub
		return enterpriseDao.update(entity);
	}

	@Override
	public Enterprise get(int id) {
		// TODO Auto-generated method stub
		return enterpriseDao.get(id);
	}

	@Override
	public List<Enterprise> findAll() {
		// TODO Auto-generated method stub
		return enterpriseDao.findAll();
	}

	@Override
	public int delete(Enterprise entity) {
		// TODO Auto-generated method stub
		return enterpriseDao.delete(entity);
	}

}
