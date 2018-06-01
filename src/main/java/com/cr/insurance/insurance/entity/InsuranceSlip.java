package  com.cr.insurance.insurance.entity;

import java.util.Date;

import com.cr.insurance.common.entity.BaseEntity;

public class InsuranceSlip extends BaseEntity{


    private String surename;

    private String surepostaladdress;

    private String sureorigin;

    private String sureperson;

    private String surephone;

    private String surepostalcode;
    
    private String suretype;

    private String insuredname;

    private String insuredpostaladdress;

    private String insuredorigin;

    private String insuredperson;

    private String insuredphone;

    private String insuredpostalcode;

    private String industrycategory;

    private String industrycode;

    private String insurednum;

    private String insuredaddress;

    private String insuredregisteredcapital;

    private String insuredtotalassets;

    private String insuredoldturnover;

    private String insuredtype;

    private String deductibleexcess;

    private String haverelevantinsurance;

    private String isnewinsurance;

    private String totalamountinsured;

    private Date startdate;

    private Date enddate;

    private String totalcost;

    private Date leadtime;

    private String disputemethod;

    private String remark;

    private String firsttrialstate;

    private String firsttrialperson;
    
    private String firsttrialopinion;

    private java.sql.Timestamp firsttrialtime;


    private Integer userid;

    private Integer enterpriseid;

  

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename == null ? null : surename.trim();
    }

    public String getSurepostaladdress() {
        return surepostaladdress;
    }

    public void setSurepostaladdress(String surepostaladdress) {
        this.surepostaladdress = surepostaladdress == null ? null : surepostaladdress.trim();
    }

    public String getSureorigin() {
        return sureorigin;
    }

    public void setSureorigin(String sureorigin) {
        this.sureorigin = sureorigin == null ? null : sureorigin.trim();
    }

    public String getSureperson() {
        return sureperson;
    }

    public void setSureperson(String sureperson) {
        this.sureperson = sureperson == null ? null : sureperson.trim();
    }

    
    public String getSurephone() {
        return surephone;
    }

    public void setSurephone(String surephone) {
        this.surephone = surephone == null ? null : surephone.trim();
    }

    public String getSurepostalcode() {
        return surepostalcode;
    }

    public void setSurepostalcode(String surepostalcode) {
        this.surepostalcode = surepostalcode == null ? null : surepostalcode.trim();
    }

    
    public String getSuretype() {
		return suretype;
	}

	public void setSuretype(String suretype) {
		this.suretype = suretype;
	}

	public String getInsuredname() {
        return insuredname;
    }

    public void setInsuredname(String insuredname) {
        this.insuredname = insuredname == null ? null : insuredname.trim();
    }

    public String getInsuredpostaladdress() {
        return insuredpostaladdress;
    }

    public void setInsuredpostaladdress(String insuredpostaladdress) {
        this.insuredpostaladdress = insuredpostaladdress == null ? null : insuredpostaladdress.trim();
    }

    public String getInsuredorigin() {
        return insuredorigin;
    }

    public void setInsuredorigin(String insuredorigin) {
        this.insuredorigin = insuredorigin == null ? null : insuredorigin.trim();
    }

    public String getInsuredperson() {
        return insuredperson;
    }

    public void setInsuredperson(String insuredperson) {
        this.insuredperson = insuredperson == null ? null : insuredperson.trim();
    }

    public String getInsuredphone() {
        return insuredphone;
    }

    public void setInsuredphone(String insuredphone) {
        this.insuredphone = insuredphone == null ? null : insuredphone.trim();
    }

    public String getInsuredpostalcode() {
        return insuredpostalcode;
    }

    public void setInsuredpostalcode(String insuredpostalcode) {
        this.insuredpostalcode = insuredpostalcode == null ? null : insuredpostalcode.trim();
    }

    public String getIndustrycategory() {
        return industrycategory;
    }

    public void setIndustrycategory(String industrycategory) {
        this.industrycategory = industrycategory == null ? null : industrycategory.trim();
    }

    public String getIndustrycode() {
        return industrycode;
    }

    public void setIndustrycode(String industrycode) {
        this.industrycode = industrycode == null ? null : industrycode.trim();
    }

    public String getInsurednum() {
        return insurednum;
    }

    public void setInsurednum(String insurednum) {
        this.insurednum = insurednum == null ? null : insurednum.trim();
    }

    public String getInsuredaddress() {
        return insuredaddress;
    }

    public void setInsuredaddress(String insuredaddress) {
        this.insuredaddress = insuredaddress == null ? null : insuredaddress.trim();
    }

    public String getInsuredregisteredcapital() {
        return insuredregisteredcapital;
    }

    public void setInsuredregisteredcapital(String insuredregisteredcapital) {
        this.insuredregisteredcapital = insuredregisteredcapital == null ? null : insuredregisteredcapital.trim();
    }

    public String getInsuredtotalassets() {
        return insuredtotalassets;
    }

    public void setInsuredtotalassets(String insuredtotalassets) {
        this.insuredtotalassets = insuredtotalassets == null ? null : insuredtotalassets.trim();
    }

    public String getInsuredoldturnover() {
        return insuredoldturnover;
    }

    public void setInsuredoldturnover(String insuredoldturnover) {
        this.insuredoldturnover = insuredoldturnover == null ? null : insuredoldturnover.trim();
    }

    public String getInsuredtype() {
        return insuredtype;
    }

    public void setInsuredtype(String insuredtype) {
        this.insuredtype = insuredtype == null ? null : insuredtype.trim();
    }

    public String getDeductibleexcess() {
        return deductibleexcess;
    }

    public void setDeductibleexcess(String deductibleexcess) {
        this.deductibleexcess = deductibleexcess == null ? null : deductibleexcess.trim();
    }

    public String getHaverelevantinsurance() {
        return haverelevantinsurance;
    }

    public void setHaverelevantinsurance(String haverelevantinsurance) {
        this.haverelevantinsurance = haverelevantinsurance == null ? null : haverelevantinsurance.trim();
    }

    public String getIsnewinsurance() {
        return isnewinsurance;
    }

    public void setIsnewinsurance(String isnewinsurance) {
        this.isnewinsurance = isnewinsurance == null ? null : isnewinsurance.trim();
    }

    public String getTotalamountinsured() {
        return totalamountinsured;
    }

    public void setTotalamountinsured(String totalamountinsured) {
        this.totalamountinsured = totalamountinsured == null ? null : totalamountinsured.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost == null ? null : totalcost.trim();
    }

    public Date getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(Date leadtime) {
        this.leadtime = leadtime;
    }

    public String getDisputemethod() {
        return disputemethod;
    }

    public void setDisputemethod(String disputemethod) {
        this.disputemethod = disputemethod == null ? null : disputemethod.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFirsttrialstate() {
        return firsttrialstate;
    }

    public void setFirsttrialstate(String firsttrialstate) {
        this.firsttrialstate = firsttrialstate == null ? null : firsttrialstate.trim();
    }

    public String getFirsttrialperson() {
        return firsttrialperson;
    }

    public void setFirsttrialperson(String firsttrialperson) {
        this.firsttrialperson = firsttrialperson == null ? null : firsttrialperson.trim();
    }

    public Date getFirsttrialtime() {
        return firsttrialtime;
    }

    

    public void setFirsttrialtime(java.sql.Timestamp firsttrialtime) {
		this.firsttrialtime = firsttrialtime;
	}

	

	public String getFirsttrialopinion() {
		return firsttrialopinion;
	}

	public void setFirsttrialopinion(String firsttrialopinion) {
		this.firsttrialopinion = firsttrialopinion;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

	
    
}