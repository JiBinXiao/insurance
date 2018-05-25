package com.cr.insurance.user.entity;

import com.cr.insurance.common.entity.BaseEntity;

public class User extends BaseEntity{

	private String email;
	
	private String phone;
	
	private String realname;
	
	private String idcard;
	
	private String password;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", phone=" + phone + ", realname=" + realname + ", idcard=" + idcard
				+ ", password=" + password + "]";
	}

	
	
	
}
