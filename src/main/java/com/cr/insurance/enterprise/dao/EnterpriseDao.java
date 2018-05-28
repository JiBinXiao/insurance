package com.cr.insurance.enterprise.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.cr.insurance.common.dao.CrudDao;
import com.cr.insurance.enterprise.entity.Enterprise;


@Repository
public class EnterpriseDao implements CrudDao<Enterprise> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Enterprise entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("insert enterprise(type,name,address,postalcode,registeredCapital,userId,createby,createdate,updateby,updatedate)"
				+ " values(?,?,?,?,?,?,?,?,?,?)",entity.getType(),entity.getName(),entity.getAddress(),entity.getPostalcode(),entity.getRegisteredCapital(),entity.getUserId(),
						entity.getCreateby(),entity.getCreatedate(),entity.getUpdateby(),entity.getUpdatedate());
		return res;
	
	}

	@Override
	public int update(Enterprise entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("update enterprise set type=?,name=?,address=?,postalcode=?,registeredCapital=?,updateby=?,updatedate=? where id=?",entity.getType(),entity.getName(),entity.getAddress(),entity.getPostalcode(),entity.getRegisteredCapital(),
						entity.getUpdateby(),entity.getUpdatedate(),entity.getId());
		return res;
	}

	@Override
	public Enterprise get(int id) {
		// TODO Auto-generated method stub
		List<Enterprise> enterprises= jdbcTemplate.query("select * from enterprise where id=?", new Object[] {id},new BeanPropertyRowMapper<Enterprise>(Enterprise.class));
		if(enterprises!=null && enterprises.size()>0)
			return enterprises.get(0);
		else
			return null;
	}

	@Override
	public List<Enterprise> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from enterprise",new BeanPropertyRowMapper<Enterprise>(Enterprise.class));

	}

	@Override
	public int delete(Enterprise entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("delete from enterprise where id = ?",entity.getId());
		return res;
	}

	public List<Enterprise> findAll(int userId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from enterprise where userId=?",new Object[] {userId},new BeanPropertyRowMapper<Enterprise>(Enterprise.class));

	}

}
