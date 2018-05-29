package com.cr.insurance.insurance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr.insurance.common.dao.CrudDao;
import com.cr.insurance.insurance.entity.InsuranceSlip;

@Repository
public class InsuranceSlipDao implements CrudDao<InsuranceSlip> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(InsuranceSlip entity) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into insuranceslip ( sureName, surePostalAddress," + 
				"      sureOrigin, surePerson, surePhone," + 
				"      surePostalcode, sureType,insuredName, insuredPostalAddress," + 
				"      insuredOrigin, insuredPerson, insuredPhone," + 
				"      insuredPostalcode, industryCategory, industryCode," + 
				"      insuredNum, insuredAddress, insuredRegisteredCapital," + 
				"      insuredTotalAssets, insuredOldTurnover," + 
				"      insuredType, deductibleExcess, haveRelevantInsurance," + 
				"      isNewInsurance, totalAmountInsured, startdate," + 
				"      enddate, totalCost, leadTime," + 
				"      disputeMethod, remark, " + 
				"      createby,createtime, updateby, updatetime," + 
				"      userId, enterpriseId)" + 
				"    values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
				,new Object[] {entity.getSurename(),entity.getSurepostaladdress(),
						entity.getSureorigin(),entity.getSureperson(),entity.getSurephone(),
						entity.getSurepostalcode(),entity.getSuretype(),entity.getInsuredname(),entity.getInsuredpostaladdress(),
						entity.getInsuredorigin(),entity.getInsuredperson(),entity.getInsuredphone(),
						entity.getInsuredpostalcode(),entity.getIndustrycategory(),entity.getIndustrycode(),
						entity.getInsurednum(),entity.getInsuredaddress(),entity.getInsuredregisteredcapital(),
						entity.getInsuredtotalassets(),entity.getInsuredoldturnover(),
						entity.getInsuredtype(),entity.getDeductibleexcess(),entity.getHaverelevantinsurance(),
						entity.getIsnewinsurance(),entity.getTotalamountinsured(),entity.getStartdate(),
						entity.getEnddate(),entity.getTotalcost(),entity.getLeadtime(),
						entity.getDisputemethod(),entity.getRemark(),
						entity.getCreateby(),entity.getCreatedate(),entity.getUpdateby(),entity.getUpdatedate(),
						entity.getUserid(),entity.getEnterpriseid()});
		return 0;
	}

	@Override
	public int update(InsuranceSlip entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InsuranceSlip get(int id) {
		// TODO Auto-generated method stub
		List<InsuranceSlip> insuranceSlips=jdbcTemplate.query("select * from insuranceSlip where id = ?", new Object[] {id}, new BeanPropertyRowMapper(InsuranceSlip.class));
		if(insuranceSlips!=null && insuranceSlips.size()>0)
			return insuranceSlips.get(0);
		else
			return null;
	}

	@Override
	public List<InsuranceSlip> findAll() {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query("select * from insuranceslip", new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
	}

	@Override
	public int delete(InsuranceSlip entity) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("delete from insuranceSlip where id = ?",entity.getId());
		return res;
	}
	

	public List<InsuranceSlip> findAll(int userId) {
		// TODO Auto-generated method stub
		List<InsuranceSlip> insuranceSlips=jdbcTemplate.query("select * from insuranceslip where userId=?", new Object[] {userId}, new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
		return insuranceSlips;
	}

	public InsuranceSlip findBySureName(String surename) {
		// TODO Auto-generated method stub
		List<InsuranceSlip> insuranceSlips=jdbcTemplate.query("select * from insuranceslip where sureName=?", new Object[] {surename}, new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
		if(insuranceSlips!=null && insuranceSlips.size()>0)
			return insuranceSlips.get(0);
		else
			return null;
	}

}
