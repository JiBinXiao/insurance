package com.cr.insurance.commerialInquiry.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr.insurance.commerialInquiry.entity.CommerialInquiry;
import com.cr.insurance.common.dao.CrudDao;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;


@Repository
public class CommerialInquiryDao implements CrudDao<CommerialInquiry>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(CommerialInquiry entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("insert into commerialinquiry(name,address,postalCode,type,propertyat,propertyEnvironment,commissionTime,insuranceSlipId) "
				+ "values(?,?,?,?,?,?,?,?)", entity.getName(),entity.getAddress(),entity.getPostalcode(),
				entity.getType(),entity.getPropertyat(),entity.getPropertyenvironment(),entity.getCommissiontime(),
				entity.getInsuranceslipid());
		return res;
	}

	@Override
	public int update(CommerialInquiry entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommerialInquiry get(int id) {
		// TODO Auto-generated method stub
		List<CommerialInquiry> commerialInquiries= jdbcTemplate.query("select * from commerialinquiry where id=?", new Object[] {id},new BeanPropertyRowMapper<CommerialInquiry>(CommerialInquiry.class));
		if(commerialInquiries!=null && commerialInquiries.size()==1)
			return commerialInquiries.get(0);
		else
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
		int res=jdbcTemplate.update("delete from commerialinquiry where id=?",new Object[] {entity.getId()});
		return res;
	}

	public CommerialInquiry findByInsuranceId(String id) {
		// TODO Auto-generated method stub
		List<CommerialInquiry> commerialInquiries=jdbcTemplate.query("select * from commerialinquiry where insuranceSlipId=?", new Object[] {id},new BeanPropertyRowMapper<CommerialInquiry>(CommerialInquiry.class));
		if(commerialInquiries!=null && commerialInquiries.size()==1)
			return commerialInquiries.get(0);
		else
			return null;
	}
	

	public int insertbyInsuranceSlip(CommerialInquiry entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("insert into commerialinquiry(name,address,postalCode,insuranceSlipId) "
				+ "values(?,?,?,?)", entity.getName(),entity.getAddress(),entity.getPostalcode(),
				entity.getInsuranceslipid());
		return res;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("delete from commerialinquiry where id=?",new Object[] {id});
	}

}
