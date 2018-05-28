package com.cr.insurance.commerialInquiry.entity;

import java.util.Date;

import com.cr.insurance.common.entity.BaseEntity;

public class CommerialInquiry extends BaseEntity{


    private String name;

    private String address;

    private String postalcode;

    private String type;

    private String propertyat;

    private String propertyenvironment;

    private Date commissiontime;

    private Integer insuranceslipid;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPropertyat() {
        return propertyat;
    }

    public void setPropertyat(String propertyat) {
        this.propertyat = propertyat == null ? null : propertyat.trim();
    }

    public String getPropertyenvironment() {
        return propertyenvironment;
    }

    public void setPropertyenvironment(String propertyenvironment) {
        this.propertyenvironment = propertyenvironment == null ? null : propertyenvironment.trim();
    }

    public Date getCommissiontime() {
        return commissiontime;
    }

    public void setCommissiontime(Date commissiontime) {
        this.commissiontime = commissiontime;
    }

    public Integer getInsuranceslipid() {
        return insuranceslipid;
    }

    public void setInsuranceslipid(Integer insuranceslipid) {
        this.insuranceslipid = insuranceslipid;
    }

	@Override
	public String toString() {
		return "CommerialInquiry [name=" + name + ", address=" + address + ", postalcode=" + postalcode + ", type="
				+ type + ", propertyat=" + propertyat + ", propertyenvironment=" + propertyenvironment
				+ ", commissiontime=" + commissiontime + ", insuranceslipid=" + insuranceslipid + "]";
	}
    
    
}