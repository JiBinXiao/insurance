package com.cr.insurance.enterprise.entity;

import com.cr.insurance.common.entity.BaseEntity;

public class Enterprise extends BaseEntity {
	
	private String type;
	
	private String name;
	
	private String address;
	
	private String postalcode;
	
	private double registeredCapital;
	
	private int userId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	


	public double getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(double registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	
	
	
}
