package com.cr.insurance.productiveInquiry.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.cr.insurance.common.dao.CrudDao;
import com.cr.insurance.productiveInquiry.entity.ProductiveInquiry;


@Repository
public class ProductiveInquiryDao implements CrudDao<ProductiveInquiry>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(ProductiveInquiry entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("insert into productiveInquiry(name,address,postalCode,type,propertyat,propertyEnvironment,commissionTime,insuranceSlipId) "
				+ "values(?,?,?,?,?,?,?,?)", entity.getName(),entity.getAddress(),entity.getPostalcode(),
				entity.getType(),entity.getPropertyat(),entity.getPropertyenvironment(),entity.getCommissiontime(),
				entity.getInsuranceslipid());
		return res;
	}

	@Override
	public int update(ProductiveInquiry entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductiveInquiry get(int id) {
		// TODO Auto-generated method stub
		List<ProductiveInquiry> productiveInquiries= jdbcTemplate.query("select * from productiveInquiry where id=?", new Object[] {id},new BeanPropertyRowMapper<ProductiveInquiry>(ProductiveInquiry.class));
		if(productiveInquiries!=null && productiveInquiries.size()==1)
			return productiveInquiries.get(0);
		else
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
		int res=jdbcTemplate.update("delete from productiveInquiry where id=?",new Object[] {entity.getId()});
		return res;
	}

	public ProductiveInquiry findByInsuranceId(String id) {
		// TODO Auto-generated method stub
		List<ProductiveInquiry> productiveInquiries=jdbcTemplate.query("select * from productiveInquiry where insuranceSlipId=?", new Object[] {id},new BeanPropertyRowMapper<ProductiveInquiry>(ProductiveInquiry.class));
		if(productiveInquiries!=null && productiveInquiries.size()==1)
			return productiveInquiries.get(0);
		else
			return null;
	}
	

	public int insertbyInsuranceSlip(ProductiveInquiry entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("insert into productiveInquiry(name,address,postalCode,insuranceSlipId) "
				+ "values(?,?,?,?)", entity.getName(),entity.getAddress(),entity.getPostalcode(),
				entity.getInsuranceslipid());
		return res;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("delete from productiveInquiry where id=?",new Object[] {id});
	}

}
