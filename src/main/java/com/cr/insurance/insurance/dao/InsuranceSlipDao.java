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
				"      createby,createdate, updateby, updatedate," + 
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

	public void updateState(InsuranceSlip insuranceSlip) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update insuranceslip set firstTrialState=?,firstTrialPerson=?,firstTrialtime=? where id=?",insuranceSlip.getFirsttrialstate(),insuranceSlip.getFirsttrialperson(),insuranceSlip.getFirsttrialtime(),insuranceSlip.getId());
	}

	public List<InsuranceSlip> findPassAll() {
		// TODO Auto-generated method stub
		List<InsuranceSlip> insuranceSlips=jdbcTemplate.query("select * from insuranceslip order by firstTrialState", new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
		return insuranceSlips;
	}

	public List<InsuranceSlip> findAllDesc() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from insuranceslip order by id desc", new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
	}

	public List<InsuranceSlip> findAllbyTimeAsc() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from insuranceslip order by createdate asc", new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
	}

	public List<InsuranceSlip> findAllbyTimeDesc() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from insuranceslip order by createdate desc", new BeanPropertyRowMapper<InsuranceSlip>(InsuranceSlip.class));
	}

	public void updateOpinion(InsuranceSlip insuranceSlip) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update insuranceslip set firstTrialState=?,firstTrialPerson=?,firstTrialOpinion=?,firstTrialtime=? where id=?",
				insuranceSlip.getFirsttrialstate(),insuranceSlip.getFirsttrialperson(),insuranceSlip.getFirsttrialopinion(),insuranceSlip.getFirsttrialtime(),insuranceSlip.getId());
	}

}
